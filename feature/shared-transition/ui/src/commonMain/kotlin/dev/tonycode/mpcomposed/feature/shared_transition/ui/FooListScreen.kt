package dev.tonycode.mpcomposed.feature.shared_transition.ui

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import dev.tonycode.mpcomposed.feature.shared_transition.presentation.FooListViewModel

@Composable
fun FooListScreen(
    onNavigateBack: () -> Unit,
    onNavigateToDetails: (itemId: Int) -> Unit,
    sharedTransitionScope: SharedTransitionScope? = null,
    animatedVisibilityScope: AnimatedVisibilityScope? = null,
) {
    val viewModel: FooListViewModel =
        viewModel { FooListViewModel(SharedTransitionDataModule.provideFooRepository()) }

    Scaffold(
        topBar = { DsTopBar("Foo list", onNavigateBack) },
    ) { contentPadding ->
        ScreenContent(
            viewModel.fooList,
            onNavigateToDetails = onNavigateToDetails,
            modifier = Modifier.padding(contentPadding),
            sharedTransitionScope = sharedTransitionScope,
            animatedVisibilityScope = animatedVisibilityScope,
        )
    }
}

@Composable
private fun ScreenContent(
    fooList: List<Foo>,
    onNavigateToDetails: (itemId: Int) -> Unit,
    modifier: Modifier = Modifier,
    sharedTransitionScope: SharedTransitionScope? = null,
    animatedVisibilityScope: AnimatedVisibilityScope? = null,
) {
    LazyColumn(
        modifier,
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(fooList, key = { it.id }) { item ->
            ItemView(
                item,
                onClick = { onNavigateToDetails(item.id) },
                modifier = Modifier.fillMaxWidth(),
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = animatedVisibilityScope,
            )
        }
    }
}

@Composable
private fun ItemView(
    item: Foo,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    sharedTransitionScope: SharedTransitionScope? = null,
    animatedVisibilityScope: AnimatedVisibilityScope? = null,
) {
    Card(modifier.clickable(onClick = onClick)) {
        Row(
            Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val boxModifier = Modifier.size(108.dp)

            val finalBoxModifier =
                if (sharedTransitionScope != null && animatedVisibilityScope != null) {
                    with(sharedTransitionScope) {
                        boxModifier
                            .sharedElement(
                                sharedContentState = rememberSharedContentState(key = item.transitionKey()),
                                animatedVisibilityScope = animatedVisibilityScope,
                            )
                            .clip(RoundedCornerShape(25))
                            .background(color = Color(item.color))
                    }
                } else {
                    boxModifier
                }

            Box(finalBoxModifier)

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(item.title, fontWeight = FontWeight.Bold)
                Text(item.descr, color = MaterialTheme.colorScheme.secondary)
            }
        }
    }
}
