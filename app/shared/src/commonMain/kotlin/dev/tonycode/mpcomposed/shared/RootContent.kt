package dev.tonycode.mpcomposed.shared

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.savedstate.serialization.SavedStateConfiguration
import dev.tonycode.mpcomposed.core.designsystem.theme.DsTheme
import dev.tonycode.mpcomposed.core.designsystem.theme.NavigationBarColorEffect
import dev.tonycode.mpcomposed.core.navigation.Route
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun RootContent() {
    val navBackStack = rememberNavBackStack(createNavConfig(), Route.Showcases)

    DsTheme {
        NavigationBarColorEffect()

        Scaffold { innerPadding ->
            RootNavGraph(Modifier.padding(innerPadding), navBackStack)
        }
    }
}

@OptIn(ExperimentalSerializationApi::class)
private fun createNavConfig() =
    SavedStateConfiguration {
        serializersModule =
            SerializersModule {
                polymorphic(NavKey::class) {
                    subclassesOfSealed<Route>()
                }
            }
    }
