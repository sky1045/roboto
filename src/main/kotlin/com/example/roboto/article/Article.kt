package com.example.roboto.article

import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "articles")
class Article(title: String, content: String, createdAt: LocalDateTime?, updatedAt: LocalDateTime?) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val title: String = title
    val content: String = content
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd HH:mm", timezone = "Asia/Seoul")
    val createdAt: LocalDateTime? = createdAt
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd HH:mm", timezone = "Asia/Seoul")
    val updatedAt: LocalDateTime? = updatedAt

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Article

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Article(id=$id, title='$title', content='$content')"
    }
}