# composed-cmp

[![Platform](http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat)](https://developer.android.com)
[![API](https://img.shields.io/badge/API-23%2B-blue.svg?style=flat)](https://apilevels.com)

[![Platform](http://img.shields.io/badge/platform-ios-brightgreen.svg?style=flat)](https://developer.apple.com/ios/)

Various samples for [Compose Multiplatform](https://kotlinlang.org/compose-multiplatform/) (CMP), targets 🤖Android and 🍎iOS


## Structure

```shell
- app/
    - androidApp/ # Android native app (Kotlin)
    - iosApp/     # iOS native app (Swift)
    - shared/     # shared UI in Compose Multiplatform, and ViewController binding for iOS
```


## Fresh stack

(as of 21.03.2026)

- Gradle 9.4.1
- Kotlin 2.3.20
- ComposeMultiplatform 1.10.3
- Material3
- AGP 9.1.0


## Running

### 🤖Android

**Android Studio**
- Pick `app.androidApp` run configuration

### 🍎iOS

- Put your `TEAM_ID` into `app/iosApp/Configuration/Config.xcconfig`

**Xcode**
- Open `app/iosApp/iosApp.xcodeproj` with Xcode

**Android Studio**
- Pick `iosApp` run configuration


## License

[MIT](LICENSE)
