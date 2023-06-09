package com.example.domain.repositories

import com.example.domain.models.FilmsResponse
import com.example.domain.utils.Either
import kotlinx.coroutines.flow.Flow

interface FilmsRepository {

    fun fetchFilms(fields: String, limit: Int): Flow<Either<String, List<FilmsResponse>>>
}