package com.example.roboto.article

import org.springframework.stereotype.Service
import java.util.*

@Service
class ArticleService(private val repository: ArticleRepository) {
    fun create(title: String, content: String) {
        val mapper = ArticleMapper()
        val article = mapper.requestToEntity(title, content)
        repository.save(article)
    }

    fun all(): List<Article> {
        return repository.findAll()
    }

    fun get(id: Long): Optional<Article> {
        return repository.findById(id)
    }
}