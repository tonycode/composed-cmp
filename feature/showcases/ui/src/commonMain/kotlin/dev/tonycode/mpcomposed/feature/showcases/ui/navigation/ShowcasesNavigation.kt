package dev.tonycode.mpcomposed.feature.showcases.ui.navigation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import dev.tonycode.mpcomposed.core.navigation.Route
import dev.tonycode.mpcomposed.feature.showcases.ui.ShowcasesScreen

fun EntryProviderScope<NavKey>.showcasesEntry(rootBackStack: NavBackStack<NavKey>) {
    entry<Route.Showcases> {
        ShowcasesScreen(
            onNavigateToHapticShowcase = { rootBackStack += Route.HapticJindongShowcase },
        )
    }
}
