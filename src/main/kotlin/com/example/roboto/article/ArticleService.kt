package com.example.roboto.article

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class ArticleService(private val repository: ArticleRepository) {
    fun create(title: String, content: String): Article {
        val mapper = ArticleMapper()
        val article = mapper.requestToEntity(title, content)
        return repository.saveAndFlush(article)
    }

//    fun all(): List<Article> {
//        return repository.findAll()
//    }

    fun all(page: Int = 0, size: Int = 5): Page<Article>  {
        val pageable = PageRequest.of(page, size)
        return repository.findAll(pageable)
    }

    fun get(id: Long): Optional<Article> {
        return repository.findById(id)
    }
}