package com.example.mongo_service.user

import com.example.mongo_service.user.dto.CreateUserDto
import com.example.mongo_service.user.dto.UpdateUserDto
import com.example.mongo_service.user.documents.UserDocument
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Tag(name = "UserRestController")
@RestController
@RequestMapping("/api")
class UserRestController(private val userService: UserService) {
    @GetMapping("/users")
    fun getAllArticles(): List<UserDocument> =
        userService.findAll()


    @PostMapping("/users")
    fun createNewArticle(@Valid @RequestBody createUserDto: CreateUserDto): UserDocument =
        userService.save(createUserDto)


    @GetMapping("/users/{id}")
    fun getArticleById(@PathVariable(value = "id") userId: String): ResponseEntity<UserDocument> =
        userService.findById(userId);


    @PatchMapping("/users/{id}")
    fun updateArticleById(
        @PathVariable(value = "id") userId: String,
        @Valid @RequestBody updateUserDto: UpdateUserDto
    ): ResponseEntity<UserDocument> =
        userService.update(userId, updateUserDto);

    @DeleteMapping("/users/{id}")
    fun deleteArticleById(@PathVariable(value = "id") userId: String): ResponseEntity<Void> =
        userService.delete(userId);
}