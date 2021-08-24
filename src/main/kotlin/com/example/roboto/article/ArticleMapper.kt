package com.example.roboto.article

import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class ArticleMapper {
    fun requestToEntity(title: String, content: String): Article {
        val now = LocalDateTime.now()
        return Article(
            title = title,
            content = content,
            createdAt = now,
            updatedAt = now
        )
    }

    fun entityToRequest(oldArticle: Article, article: Article): Article {
        val now = LocalDateTime.now()
        return Article(
            id = oldArticle.id,
            title = article.title,
            content = article.content,
            createdAt = oldArticle.createdAt,
            updatedAt = now
        )
    }
}