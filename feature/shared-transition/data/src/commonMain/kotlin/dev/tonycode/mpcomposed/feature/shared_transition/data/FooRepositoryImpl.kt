package dev.tonycode.mpcomposed.feature.shared_transition.data

import dev.tonycode.mpcomposed.feature.shared_transition.domain.Foo
import dev.tonycode.mpcomposed.feature.shared_transition.domain.FooRepository
import kotlin.random.Random

internal class FooRepositoryImpl : FooRepository {
    private val fooList =
        List(25) { idx ->
            Foo(
                id = idx,
                title = "Item ${idx + 1}",
                descr = "Description ${idx + 1}",
                color = 0xFF000000.toInt() or Random.nextInt(0x01000000),
            )
        }

    override fun getAll(): List<Foo> = fooList

    override fun get(id: Int): Foo? = fooList.firstOrNull { it.id == id }
}
