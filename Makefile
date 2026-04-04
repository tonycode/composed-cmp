# Most frequently used commands are here

## --- pre-commit ---

.PHONY: fmt

# Format code (ktLint) and update ABI (Application Binary Interface) dumps
# More on ABI dumps: https://kotlinlang.org/docs/gradle-binary-compatibility-validation.html
fmt:
	./gradlew ktlintFormat && ./gradlew updateKotlinAbi


## --- debugging Android app ---

.PHONY: a-dark a-light
.PHONY: a-font-current a-font-small a-font-default a-font-large
.PHONY: a-dpi-current a-dpi-small a-dpi-default a-dpi-large
.PHONY: a-dka a-dka-on a-dka-off

# Adjust these defaults if you want different values
ADB ?= adb
#ADB ?= adb -d # device
#ADB ?= adb -e # emulator

FONT_SMALL ?= 0.85
FONT_DEFAULT ?= 1.0
FONT_LARGE ?= 1.3

DPI_SMALL ?= 240
#DPI_DEFAULT ?= 440
DPI_LARGE ?= 600

a-dark:
	$(ADB) shell cmd uimode night yes

a-light:
	$(ADB) shell cmd uimode night no

# Show current font scale
a-font-current:
	$(ADB) shell settings get system font_scale

a-font-small:
	$(ADB) shell settings put system font_scale $(FONT_SMALL)

a-font-default:
	$(ADB) shell settings put system font_scale $(FONT_DEFAULT)

a-font-large:
	$(ADB) shell settings put system font_scale $(FONT_LARGE)

# Show current density
a-dpi-current:
	$(ADB) shell wm density

a-dpi-small:
	$(ADB) shell wm density $(DPI_SMALL)

a-dpi-default:
#	$(ADB) shell wm density $(DPI_DEFAULT)
	$(ADB) shell wm density reset

a-dpi-large:
	$(ADB) shell wm density $(DPI_LARGE)

# Current status of "Don't keep activities" toggle in Developer options
a-dka:
	$(ADB) shell settings get global always_finish_activities

# Enable "Don't keep activities" toggle in Developer options (destroy activities as soon as user leaves them)
a-dka-on:
	$(ADB) shell settings put global always_finish_activities 1

# Disable "Don't keep activities" toggle in Developer options
a-dka-off:
	$(ADB) shell settings put global always_finish_activities 0
