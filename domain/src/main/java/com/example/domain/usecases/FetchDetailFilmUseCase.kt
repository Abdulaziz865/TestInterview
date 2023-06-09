package com.example.domain.usecases

import com.example.domain.repositories.DetailFilmsRepository
import javax.inject.Inject

class FetchDetailFilmUseCase @Inject constructor(private val detailFilmsRepository: DetailFilmsRepository) {

    operator fun invoke(id: String) = detailFilmsRepository.fetchDetailFilms(id)
}