# アーキテクチャ概要

このプロジェクトは **ヘキサゴナルアーキテクチャ（クリーンアーキテクチャ）** を採用しています。

---

## 各層の意味

| 層 | 一言 | 変わりやすさ |
|---|---|---|
| `domain` | **何が存在するか**（概念・ビジネスルール） | ほぼ変わらない |
| `application` | **何をするか**（ユースケース・シナリオ） | 機能追加で増える |
| `infrastructure` | **どうやるか**（DB・JWT・暗号化の技術詳細） | 技術選定で変わる |
| `presentation` | **どう見せるか**（HTTP I/F） | API設計で変わる |

### `domain/` — ビジネスの世界

「弓道アプリとして何が真実か」を表す層。Spring も JPA も JWT も知らない。

- `model/` — ドメインモデル（`Record`, `User`, `BelongingGroup` など）
- `repository/` — リポジトリの **インターフェース（Port）** のみ。実装は持たない
- `service/` — ドメインサービス（複数のモデルにまたがるビジネスロジック）と `PasswordEncoderPort`

### `application/` — 「何をするか」のシナリオ

ユースケース単位で分割。ドメインのルールを組み合わせてシナリオを組み立てる。DBや認証の具体実装は知らない（Port インターフェース経由のみ）。

- 各ユースケースは独立したディレクトリ（`recordCreate/`, `userLoginUseCase/` など）
- 各ディレクトリに `UseCase`（interface）・`ApplicationService`（実装）・`Command`（input）・`Dto`（output）を持つ
- `TokenGeneratorPort` もここに配置（JWT生成の抽象化）

### `infrastructure/` — 「どうやって実現するか」の技術詳細

具体的な技術がここに閉じる。`domain/` が定義した Port インターフェースを実装する。

- `persistence/entity/` — JPA Entity（DBテーブルとのマッピング）
- `persistence/mapper/` — ドメインモデル ↔ JPA Entity の変換
- `persistence/repository/` — `*RepositoryAdapter`（Port を実装）と JPA Repository
- `jwt/` — `JwtUtil`（`TokenGeneratorPort` を実装）、`SecurityConfig` など
- `security/` — `PasswordEncoder`（`PasswordEncoderPort` を実装）

### `presentation/` — 外の世界との窓口

HTTPリクエストをアプリの言葉に翻訳するだけ。ビジネスロジックは持たない。

- 各操作ごとに独立したディレクトリ（`createRecord/`, `userLoginController/` など）
- 各ディレクトリに `Controller`・`Request`・`Response` を持つ

---

## 依存方向のルール

```
presentation
    │
    │  UseCase interface のみ参照
    ▼
application
    │
    │  DomainService / RepositoryPort (interface) のみ参照
    ▼
domain  ◄──── infrastructure が implements する
    (interface のみ、具体実装を知らない)
```

**禁止事項：**
- `domain` が他の層を import する
- `presentation` が `domain` を直接参照する
- `application` が `infrastructure` を直接 import する

---

## 全体構成図

```
┌─────────────────────────────────────────────────────────────────┐
│                        presentation/                            │
│                                                                 │
│  recordController/          belongingGroupController/           │
│   ├── createRecord/          ├── registerBelongingGroup/        │
│   ├── getRecordByUser/       └── assignGroup/                   │
│   ├── getRecordByDate/                                          │
│   ├── monthlySummary/       userLoginController/                │
│   └── updateRecord/         userRegisterController/             │
│                             userQueryController/                │
│                              ├── getAllUsers/                   │
│                              └── getUserById/                   │
└──────────────────┬──────────────────────────────────────────────┘
                   │ UseCase interface のみ
┌──────────────────▼──────────────────────────────────────────────┐
│                        application/                             │
│                                                                 │
│  recordUseCase/             belongingGroupUseCase/              │
│   ├── recordCreate/          ├── belongingGroupRegister/        │
│   ├── recordGetByUser/       └── assignGroup/                   │
│   ├── recordGetByDate/                                          │
│   ├── recordMonthlySummary/  userLoginUseCase/ (TokenGeneratorPort) │
│   └── recordUpdate/          userRegisterUseCase/               │
│                              getUserByIdUseCase/                │
│                              userGetAllUseCase/                 │
└──────────────────┬──────────────────────────────────────────────┘
                   │ DomainService / RepositoryPort 経由
┌──────────────────▼──────────────────────────────────────────────┐
│                          domain/                                │
│                                                                 │
│  model/                     repository/ (Port = interface)      │
│   ├── User                   ├── UserRepositoryPort             │
│   ├── Record                 ├── RecordRepositoryPort           │
│   ├── BelongingGroup         └── BelongingGroupRepositoryPort   │
│   ├── ArrowRecord                                               │
│   └── ...                   service/                           │
│                              ├── RecordDomainService            │
│                              ├── UserRegisterDomainService      │
│                              ├── BelongingGroupRegisterDomainService │
│                              ├── AssignBelongingGroupDomainService │
│                              └── PasswordEncoderPort (interface) │
└─────────────────────────────────────────────────────────────────┘
                   ▲ implements（依存の逆転）
┌──────────────────┴──────────────────────────────────────────────┐
│                       infrastructure/                           │
│                                                                 │
│  persistence/               jwt/                                │
│   ├── entity/ (JPA Entity)   ├── JwtUtil  ← TokenGeneratorPort  │
│   ├── mapper/ (変換)         ├── JwtConfig                      │
│   └── repository/            ├── JwtAuthenticationFilter        │
│       ├── UserRepositoryAdapter      └── SecurityConfig         │
│       ├── RecordRepositoryAdapter                               │
│       └── BelongingGroupRepositoryAdapter                       │
│                             security/                           │
│  ulid/                       └── PasswordEncoder ← PasswordEncoderPort │
│   └── UlidGenerator                                             │
└─────────────────────────────────────────────────────────────────┘
```

---

## Port / Adapter 対応表

| Port（interface） | 配置 | Adapter（実装） | 配置 |
|---|---|---|---|
| `UserRepositoryPort` | `domain/repository/` | `UserRepositoryAdapter` | `infrastructure/persistence/repository/` |
| `RecordRepositoryPort` | `domain/repository/` | `RecordRepositoryAdapter` | `infrastructure/persistence/repository/` |
| `BelongingGroupRepositoryPort` | `domain/repository/` | `BelongingGroupRepositoryAdapter` | `infrastructure/persistence/repository/` |
| `PasswordEncoderPort` | `domain/service/` | `PasswordEncoder` | `infrastructure/security/` |
| `TokenGeneratorPort` | `application/useCase/userLoginUseCase/` | `JwtUtil` | `infrastructure/jwt/` |

---

## リクエストフロー（例：記録作成）

```
POST /record/create
      │
      ▼
RecordCreateController          (presentation)
      │ RecordCreateCommand
      ▼
RecordCreateUseCase interface   (application)
      │
      ▼
RecordCreateApplicationService  (application)
      │ RecordDomainService
      ▼
RecordRepositoryPort interface  (domain)
      │ implements
      ▼
RecordRepositoryAdapter         (infrastructure)
      │
      ▼
RecordRepository (JPA) → MySQL
```
