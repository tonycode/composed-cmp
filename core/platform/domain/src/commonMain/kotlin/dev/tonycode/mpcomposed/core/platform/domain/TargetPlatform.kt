package dev.tonycode.mpcomposed.core.platform.domain

enum class TargetPlatform {
    Android,
    Ios,
}

expect val targetPlatform: TargetPlatform

val TargetPlatform.isAndroid: Boolean
    get() = (this == TargetPlatform.Android)

val TargetPlatform.isIos: Boolean
    get() = (this == TargetPlatform.Ios)
