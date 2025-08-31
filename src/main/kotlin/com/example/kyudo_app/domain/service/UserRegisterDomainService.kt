package com.example.kyudo_app.domain.service

import com.example.kyudo_app.domain.model.User
import com.example.kyudo_app.infrastructure.persistence.entity.UserEntity
import com.example.kyudo_app.infrastructure.persistence.mapper.UserMapper
import com.example.kyudo_app.infrastructure.persistence.repository.UserRegisterRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.repository.findByIdOrNull

@Service
class UserRegisterDomainService(
    private val userRegisterRepository: UserRegisterRepository
) {

    @Transactional
    fun registerUser(domainUser: User): User {
        // ドメインモデル → Entity
        val entity: UserEntity = UserMapper.toEntity(domainUser)

        // 保存
        val savedEntity = userRegisterRepository.save(entity)

        // Entity → ドメインモデル
        return UserMapper.toDomain(savedEntity)
    }

    @Transactional(readOnly = true)
    fun getUserById(id: String?): User {
        val entity = userRegisterRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("User not found for id=$id")

        // Entity → ドメインモデル
        return UserMapper.toDomain(entity)
    }
}
