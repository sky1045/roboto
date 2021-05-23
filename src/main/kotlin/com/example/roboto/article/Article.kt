package com.example.roboto.article

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "articles")
class Article (title: String, content: String, ){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val title: String = title
    val content: String = content
    val createdAt: LocalDateTime? = null
    val updatedAt: LocalDateTime? = null
}