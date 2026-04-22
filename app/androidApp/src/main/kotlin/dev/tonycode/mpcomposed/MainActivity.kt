package dev.tonycode.mpcomposed

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.tonycode.mpcomposed.shared.RootContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            // "2/3-Button" navigation bar:
            // - transparent background with dark-style buttons for an instant,
            // - then dynamically aligned with app theme inside RootContent.
            navigationBarStyle = SystemBarStyle.dark(Color.TRANSPARENT)
        )
        super.onCreate(savedInstanceState)

        setContent {
            RootContent()
        }
    }
}
