package com.example.data.repositories

import com.example.data.base.BaseRepository
import com.example.data.dtos.toDomain
import com.example.data.remote.apiservices.FilmsApiService
import com.example.domain.models.FilmsResponse
import com.example.domain.repositories.FilmsRepository
import com.example.domain.utils.Either
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(private val service: FilmsApiService) : BaseRepository(),
    FilmsRepository {

    override fun fetchFilms(fields: String, limit: Int): Flow<Either<String, List<FilmsResponse>>> = doRequest {
        service.fetchFilms(fields, limit).map {
            it.toDomain()
        }
    }
}