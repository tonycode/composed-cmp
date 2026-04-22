package dev.tonycode.mpcomposed.feature.shared_transition.ui

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.tonycode.mpcomposed.core.designsystem.components.DsTopBar
import dev.tonycode.mpcomposed.feature.shared_transition.data.di.SharedTransitionDataModule
import dev.tonycode.mpcomposed.feature.shared_transition.domain.Foo
import dev.tonycode.mpcomposed.feature.shared_transition.presentation.FooDetailsViewModel

@Composable
fun FooDetailsScreen(
    itemId: Int,
    onNavigateBack: () -> Unit,
    sharedTransitionScope: SharedTransitionScope? = null,
    animatedVisibilityScope: AnimatedVisibilityScope? = null,
) {
    val viewModel: FooDetailsViewModel =
        viewModel { FooDetailsViewModel(itemId, SharedTransitionDataModule.provideFooRepository()) }
    val item = viewModel.foo ?: return

    Scaffold(
        topBar = { DsTopBar("Details: ${item.title}", onNavigateBack) },
        // Prevent Scaffold from inserting vertical insets (they are handled in the root Scaffold)
        contentWindowInsets =
            ScaffoldDefaults.contentWindowInsets
                .exclude(WindowInsets.safeDrawing.only(WindowInsetsSides.Vertical)),
    ) { contentPadding ->
        ScreenContent(
            item,
            modifier = Modifier.padding(contentPadding),
            sharedTransitionScope = sharedTransitionScope,
            animatedVisibilityScope = animatedVisibilityScope,
        )
    }
}

@Composable
private fun ScreenContent(
    item: Foo,
    modifier: Modifier = Modifier,
    sharedTransitionScope: SharedTransitionScope? = null,
    animatedVisibilityScope: AnimatedVisibilityScope? = null,
) {
    val baseBoxModifier = Modifier.size(162.dp)
    val boxModifier =
        if (sharedTransitionScope != null && animatedVisibilityScope != null) {
            with(sharedTransitionScope) {
                baseBoxModifier
                    .sharedElement(
                        sharedContentState = rememberSharedContentState(key = item.transitionKey()),
                        animatedVisibilityScope = animatedVisibilityScope,
                    )
                    .clip(RoundedCornerShape(25))
                    .background(color = Color(item.color))
            }
        } else {
            baseBoxModifier
        }

    Column(
        modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(boxModifier)

        Text(item.title, Modifier.padding(horizontal = 24.dp), fontWeight = FontWeight.Bold)

        Text(item.descr, Modifier.padding(horizontal = 24.dp), color = MaterialTheme.colorScheme.secondary)
    }
}
