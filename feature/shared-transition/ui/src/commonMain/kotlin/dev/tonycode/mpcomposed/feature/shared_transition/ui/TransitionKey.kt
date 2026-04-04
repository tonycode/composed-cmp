package dev.tonycode.mpcomposed.feature.shared_transition.ui

import dev.tonycode.mpcomposed.feature.shared_transition.domain.Foo

internal fun Foo.transitionKey(): String = "key-foo-$id"
