# composed-cmp

[![Kotlin](https://img.shields.io/badge/Kotlin-v2.3.20-blueviolet?logo=kotlin)](https://kotlinlang.org/)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.10.3-4285F4?logo=jetpackcompose)](https://kotlinlang.org/compose-multiplatform/)

[![Platform](http://img.shields.io/badge/platform-Android-brightgreen.svg?logo=android&style=flat)](https://developer.android.com)
[![API](https://img.shields.io/badge/API-24%2B-blue.svg?style=flat)](https://apilevels.com)

[![Platform](http://img.shields.io/badge/platform-iOS-brightgreen.svg?logo=apple&style=flat)](https://developer.apple.com/ios/)

Playground for [Compose Multiplatform](https://kotlinlang.org/compose-multiplatform/) (CMP)

Targets: 🤖Android and 🍎iOS


## Showcases

**Haptic / Vibration**
- Jindong lib usage

**Master / Detail flow**
- Shared element transition with Navigation 3

## Structure

```shell
- app/
    - androidApp/ # Android native app (Kotlin)
    - iosApp/     # iOS native app (Swift)
    - shared/     # shared UI in Compose Multiplatform, and ViewController binding for iOS
- core/*
- feature/*
```


## Fresh stack

(as of 2026-Apr-22)

- Gradle 9.4.1
- Kotlin 2.3.20
- ComposeMultiplatform 1.10.3
- Material3
- Navigation3
- AGP 9.2.0


## Running

### 🤖Android

**Android Studio**
- Pick `app.androidApp` run configuration

### 🍎iOS

- Put your `TEAM_ID` into `app/iosApp/Configuration/Config.xcconfig`

**Android Studio**
- Pick `iosApp` run configuration

**Xcode**
- Open `app/iosApp/iosApp.xcodeproj` with Xcode


## License

[MIT](LICENSE)
