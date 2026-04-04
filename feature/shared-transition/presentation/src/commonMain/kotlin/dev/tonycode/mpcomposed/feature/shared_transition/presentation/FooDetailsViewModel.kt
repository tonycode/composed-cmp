package dev.tonycode.mpcomposed.feature.shared_transition.presentation

import androidx.lifecycle.ViewModel
import dev.tonycode.mpcomposed.feature.shared_transition.domain.Foo
import dev.tonycode.mpcomposed.feature.shared_transition.domain.FooRepository

class FooDetailsViewModel(
    itemId: Int,
    fooRepository: FooRepository,
) : ViewModel() {
    val foo: Foo? = fooRepository.get(itemId)
}
