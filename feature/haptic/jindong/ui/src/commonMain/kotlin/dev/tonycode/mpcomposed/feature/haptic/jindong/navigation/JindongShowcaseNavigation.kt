package dev.tonycode.mpcomposed.feature.haptic.jindong.navigation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import dev.tonycode.mpcomposed.core.navigation.Route
import dev.tonycode.mpcomposed.feature.haptic.jindong.JindongShowcaseScreen

fun EntryProviderScope<NavKey>.hapticJindongShowcaseEntry(rootBackStack: NavBackStack<NavKey>) {
    entry<Route.HapticJindongShowcase> {
        JindongShowcaseScreen(
            onNavigateBack = { rootBackStack.removeLastOrNull() },
        )
    }
}
