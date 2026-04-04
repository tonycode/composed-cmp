package dev.tonycode.mpcomposed.feature.shared_transition.ui.navigation

import androidx.compose.animation.SharedTransitionScope
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import dev.tonycode.mpcomposed.core.navigation.Route
import dev.tonycode.mpcomposed.feature.shared_transition.ui.FooDetailsScreen
import dev.tonycode.mpcomposed.feature.shared_transition.ui.FooListScreen

fun EntryProviderScope<NavKey>.sharedTransitionFlow(
    rootBackStack: NavBackStack<NavKey>,
    sharedTransitionScope: SharedTransitionScope,
) {
    entry<Route.SharedTransition.FooList> {
        FooListScreen(
            onNavigateBack = { rootBackStack.removeLastOrNull() },
            onNavigateToDetails = { itemId ->
                rootBackStack += Route.SharedTransition.FooDetails(id = itemId)
            },
            sharedTransitionScope = sharedTransitionScope,
            animatedVisibilityScope = LocalNavAnimatedContentScope.current,
        )
    }

    entry<Route.SharedTransition.FooDetails> { key ->
        FooDetailsScreen(
            itemId = key.id,
            onNavigateBack = { rootBackStack.removeLastOrNull() },
            sharedTransitionScope = sharedTransitionScope,
            animatedVisibilityScope = LocalNavAnimatedContentScope.current,
        )
    }
}
