package dev.tonycode.mpcomposed.feature.shared_transition.domain

interface FooRepository {
    fun getAll(): List<Foo>

    fun get(id: Int): Foo?
}
