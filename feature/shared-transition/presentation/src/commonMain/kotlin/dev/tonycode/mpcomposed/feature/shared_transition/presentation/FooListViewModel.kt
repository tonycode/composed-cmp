package dev.tonycode.mpcomposed.feature.shared_transition.presentation

import androidx.lifecycle.ViewModel
import dev.tonycode.mpcomposed.feature.shared_transition.domain.FooRepository

class FooListViewModel(
    fooRepository: FooRepository,
) : ViewModel() {
    val fooList = fooRepository.getAll()
}
