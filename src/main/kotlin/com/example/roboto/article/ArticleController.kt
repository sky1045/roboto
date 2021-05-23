package com.example.roboto.article

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ArticleController {
    @Autowired
    private lateinit var service: ArticleService

    @GetMapping("/")
    fun getArticles(): List<Article> {
        return service.all()
    }

    @GetMapping("/{id}")
    fun getArticle(@PathVariable id: Long): Optional<Article> {
        return service.get(id)
    }
}
