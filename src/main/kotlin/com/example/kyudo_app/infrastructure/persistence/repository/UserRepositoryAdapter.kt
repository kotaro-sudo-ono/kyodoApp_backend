package com.example.kyudo_app.infrastructure.persistence.repository

import com.example.kyudo_app.domain.model.User
import com.example.kyudo_app.domain.repository.UserRepositoryPort
import com.example.kyudo_app.infrastructure.persistence.mapper.UserMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryAdapter(
    private val userRepository: UserRepository
) : UserRepositoryPort {

    override fun save(user: User): User =
        UserMapper.toDomain(userRepository.save(UserMapper.toEntity(user)))

    override fun findById(id: String): User? =
        userRepository.findByIdOrNull(id)?.let { UserMapper.toDomain(it) }
}
