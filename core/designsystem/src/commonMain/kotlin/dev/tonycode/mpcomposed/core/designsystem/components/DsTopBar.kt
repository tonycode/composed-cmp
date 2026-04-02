package dev.tonycode.mpcomposed.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tonycode.mpcomposed.core.designsystem.theme.DsTheme

/**
 * @param onNavigateBack `null` means no "back" button
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun DsTopBar(
    title: String? = null,
    onNavigateBack: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) = TopAppBar(
    title = {
        title.takeIf { !it.isNullOrBlank() }?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.titleLargeEmphasized,
            )
        }
    },
    modifier = modifier,
    navigationIcon = {
        onNavigateBack?.let {
            IconButton(it) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Home",
                )
            }
        }
    },
)

//region preview
@Preview
@Composable
private fun PreviewDsTopBar() {
    DsTheme {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            DsTopBar(onNavigateBack = {}, modifier = Modifier.fillMaxWidth())
            DsTopBar("Title here", onNavigateBack = {}, modifier = Modifier.fillMaxWidth())
            DsTopBar("No back button", onNavigateBack = null, modifier = Modifier.fillMaxWidth())
        }
    }
}
//endregion
