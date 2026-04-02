package dev.tonycode.mpcomposed.core.platform.presentation

import dev.tonycode.mpcomposed.core.platform.domain.TargetPlatform
import dev.tonycode.mpcomposed.core.platform.domain.targetPlatform

val platformName: String =
    when (targetPlatform) {
        TargetPlatform.Android -> "Android"
        TargetPlatform.Ios -> "iOS"
    }
