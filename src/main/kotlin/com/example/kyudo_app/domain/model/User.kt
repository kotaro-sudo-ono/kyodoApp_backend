package com.example.kyudo_app.domain.model



class User(
    val userId: Long,
    val name: String,
    val email: String,
    val userRole: Int,
    val gameMatches: List<GameMatch> = emptyList(),
    val records: List<Record> = emptyList(),
    val teamMembers: List<TeamMember> = emptyList(),
    val belongingGroup: BelongingGroup? = null
) {
    // ビジネスロジック（例: ユーザーロールチェックなど）
    fun isAdmin(): Boolean = userRole == 1

    // その他、ドメインルールをここに実装
}