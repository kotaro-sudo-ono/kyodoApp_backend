# カスタムスキル一覧

このプロジェクトで使用できるカスタムスキル（スラッシュコマンド）の一覧です。

## /update-openapi

APIを作成・修正したあとに `docs/openapi.yaml` を最新の状態に同期する。

**使い方:**
```
/update-openapi
/update-openapi RecordCreateController.kt
```

**動作:**
- 引数なし: 直近で変更されたコントローラーを自動検出して更新
- 引数あり: 指定したファイルに対応するエンドポイントを更新

**更新内容:**
- `components/schemas/` への新スキーマ追加
- `paths/` への新エンドポイント追加
- JWT認証の要否を SecurityConfig から自動判定
