package com.example.test01

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.time.LocalDateTime

@Entity
data class UserEntity(
    @Id
    @GeneratedValue
    val id: Int,
    var firstName: String,
    var lastName: String,
    var email: String,
    var department: String,
    var hireDate: LocalDateTime,
    var salary: Double,

    @CreationTimestamp
    var createDate: LocalDateTime,

    @UpdateTimestamp
    var updateDate: LocalDateTime?
)
