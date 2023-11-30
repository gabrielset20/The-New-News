package edu.ifam.thenewnews.repository

import edu.ifam.thenewnews.db.ArticleDatabase
import edu.ifam.thenewnews.api.RetrofitInstance
import edu.ifam.thenewnews.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadLines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArtcileDao().upsert(article)

    fun getFavouritesNews() = db.getArtcileDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArtcileDao().deleteArticle(article)
}