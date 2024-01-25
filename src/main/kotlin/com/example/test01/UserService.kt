package com.example.test01

import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class UserService(var userRepository: UserRepository) {

    fun createUser(request: requestUser): UserEntity {
        return userRepository.save(
            UserEntity(
                id = 0,
                firstName = request.firstName,
                lastName = request.lastName,
                email = request.email,
                department = request.department,
                hireDate = LocalDateTime.parse(request.hireDate),
                salary = request.salary,
                createDate = LocalDateTime.now(),
                updateDate = LocalDateTime.now()
            )
        )
    }

    fun getAllUser(): List<UserEntity> {
        return userRepository.findAll()
    }

    fun getUserById(id: Int): UserEntity? {
        return userRepository.findById(id).getOrNull()
    }

    fun updateUser(id: Int, request: requestUser): UserEntity? {
        var user = userRepository.findById(id)
        if (user.isPresent) {
            var userEntity = user.get()
            return userRepository.save(
                UserEntity(
                    id,
                    firstName = request.firstName,
                    lastName = request.lastName,
                    email = request.email,
                    department = request.department,
                    hireDate = LocalDateTime.parse(request.hireDate),
                    salary = request.salary,
                    createDate = userEntity.createDate,
                    updateDate = LocalDateTime.now()
                )
            )
        } else {
            return null
        }
    }
}

data class requestUser(
    var firstName: String,
    var lastName: String,
    var email: String,
    var department: String,
    var salary: Double,
    var hireDate: String,
)