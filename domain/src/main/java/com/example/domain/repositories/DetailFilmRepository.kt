package com.example.domain.repositories

import com.example.domain.models.FilmsResponse
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DetailFilmRepository {

    fun fetchDetailFilms(id: String): Flow<Resource<FilmsResponse>>
}