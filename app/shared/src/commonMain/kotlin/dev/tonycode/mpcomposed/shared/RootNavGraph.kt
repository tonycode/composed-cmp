package dev.tonycode.mpcomposed.shared

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import dev.tonycode.mpcomposed.feature.haptic.jindong.navigation.hapticJindongShowcaseEntry
import dev.tonycode.mpcomposed.feature.showcases.ui.navigation.showcasesEntry

@Composable
internal fun RootNavGraph(rootBackStack: NavBackStack<NavKey>) =
    NavDisplay(
        backStack = rootBackStack,
        transitionSpec = {
            fadeIn(tween(300)) togetherWith fadeOut(tween(300))
        },
        entryProvider =
            entryProvider {
                showcasesEntry(rootBackStack = rootBackStack)
                hapticJindongShowcaseEntry(rootBackStack = rootBackStack)
            },
    )
