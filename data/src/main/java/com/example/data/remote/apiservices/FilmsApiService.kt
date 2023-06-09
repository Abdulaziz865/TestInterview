package com.example.data.remote.apiservices

import com.example.data.dtos.FilmsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmsApiService {

    @GET("films")
    suspend fun fetchFilms(
        @Query("fields") fields: String?,
        @Query("limit") limit: Int?
    ): List<FilmsResponseDto>

    @GET("films/{id}")
    suspend fun fetchDetailFilmById(
        @Path("id") id: String
    ): FilmsResponseDto
}
