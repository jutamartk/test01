package com.example.test01

import org.apache.catalina.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(var userService: UserService) {

    @PostMapping
    fun addUser(@RequestBody request: requestUser): UserEntity {
        return userService.createUser(request)
    }

    @GetMapping
    fun getUser(): List<UserEntity> {
        return userService.getAllUser()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id:Int):UserEntity?{
        return userService.getUserById(id)
    }

    @PatchMapping("/{id}")
    fun updateUser(@PathVariable id: Int, @RequestBody request: requestUser) :UserEntity?{
        return userService.updateUser(id, request)
    }
}