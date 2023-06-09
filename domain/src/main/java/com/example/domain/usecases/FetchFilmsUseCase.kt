package com.example.domain.usecases

import com.example.domain.repositories.FilmsRepository
import javax.inject.Inject

class FetchFilmsUseCase @Inject constructor(private val filmsRepository: FilmsRepository) {

    operator fun invoke(fields: String, limit: Int) = filmsRepository.fetchFilms(fields, limit)

}