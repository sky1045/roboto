package com.example.roboto.article

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ArticleController {
    @Autowired
    private lateinit var service: ArticleService

    @GetMapping("/article")
    fun getArticles(
        @RequestParam("page", defaultValue = "0") page: Int,
        @RequestParam("size", defaultValue = "5") size: Int
    ): Page<Article> {
        return service.all(page, size)
    }

    @GetMapping("/article/{id}")
    fun getArticle(@PathVariable id: Long): Optional<Article> {
        return service.get(id)
    }

    @PostMapping("/article")
    fun createArticle(@RequestBody article: Article): Article {
        return service.create(article.title, article.content)
    }
}
