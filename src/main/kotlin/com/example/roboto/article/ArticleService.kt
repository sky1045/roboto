package com.example.roboto.article

import org.springframework.stereotype.Service
import java.util.*

@Service
class ArticleService(private val repository: ArticleRepository) {
    fun create(title: String, content: String) {
        val article = Article(title, content)
        repository.save(article)
    }

    fun all(): List<Article> {
        return repository.findAll()
    }

    fun get(id: Long): Optional<Article> {
        return repository.findById(id)
    }
}