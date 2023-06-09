package com.example.data.repositories

import com.example.data.base.BaseRepository
import com.example.data.dtos.toDomain
import com.example.data.remote.apiservices.FilmsApiService
import com.example.domain.models.FilmsResponse
import com.example.domain.repositories.DetailFilmsRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailFilmsRepositoryImpl @Inject constructor(private val service: FilmsApiService) :
    BaseRepository(),
    DetailFilmsRepository {

    override fun fetchDetailFilms(id: String): Flow<Resource<FilmsResponse>> = doRequestForDetail {
        service.fetchDetailFilmById(id).toDomain()
    }
}