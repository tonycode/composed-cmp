package dev.tonycode.mpcomposed.feature.shared_transition.data.di

import dev.tonycode.mpcomposed.feature.shared_transition.data.FooRepositoryImpl
import dev.tonycode.mpcomposed.feature.shared_transition.domain.FooRepository

object SharedTransitionDataModule {
    private val fooRepositoryImpl = FooRepositoryImpl()

    fun provideFooRepository(): FooRepository = fooRepositoryImpl
}
