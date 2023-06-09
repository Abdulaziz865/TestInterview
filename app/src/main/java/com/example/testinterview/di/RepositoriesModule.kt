package com.example.testinterview.di

import com.example.data.repositories.DetailFilmsRepositoryImpl
import com.example.data.repositories.FilmsRepositoryImpl
import com.example.domain.repositories.DetailFilmsRepository
import com.example.domain.repositories.FilmsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindFilmsRepository(filmsRepositoryImpl: FilmsRepositoryImpl): FilmsRepository

    @Binds
    abstract fun bindDetailFilmRepository(detailFilmsRepositoryImpl: DetailFilmsRepositoryImpl): DetailFilmsRepository
}