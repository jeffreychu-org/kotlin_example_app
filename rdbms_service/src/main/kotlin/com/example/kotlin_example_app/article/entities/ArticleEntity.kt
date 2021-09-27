package com.example.kotlin_example_app.article.entities

import javax.persistence.*
import javax.validation.constraints.NotBlank
import java.io.Serializable

@Entity
@Table(name = "article")
data class ArticleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @get: NotBlank
    val title: String? = null,

    @get: NotBlank
    val content: String? = null
)