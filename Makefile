# Most frequently used commands are here

ANDROID_PACKAGE_NAME ?= dev.tonycode.mpcomposed
IOS_BUNDLE_ID ?= dev.tonycode.mpcomposed

ADB ?= adb
#ADB ?= adb -d # device
#ADB ?= adb -e # emulator

SIMCTL ?= xcrun simctl
SIM_DEVICE ?= booted


## --- pre-commit ---

.PHONY: fmt

# Format code (ktLint) and update ABI (Application Binary Interface) dumps
# More on ABI dumps: https://kotlinlang.org/docs/gradle-binary-compatibility-validation.html
fmt:
	./gradlew ktlintFormat && ./gradlew updateKotlinAbi


## --- Android App - Management ---

.PHONY: a-clear a-uninstall

# Clear app data and reset permissions
a-clear:
	$(ADB) shell pm clear $(ANDROID_PACKAGE_NAME)

a-uninstall:
	$(ADB) shell pm uninstall $(ANDROID_PACKAGE_NAME)


## --- Android App - Debugging ---

.PHONY: a-dark a-light
.PHONY: a-font-current a-font-small a-font-default a-font-large
.PHONY: a-dpi-current a-dpi-small a-dpi-default a-dpi-large
.PHONY: a-dka a-dka-on a-dka-off
.PHONY: a-nav-buttons a-nav-gestures

FONT_SMALL ?= 0.85
FONT_DEFAULT ?= 1.0
FONT_LARGE ?= 1.3

DPI_SMALL ?= 240
#DPI_DEFAULT ?= 440
DPI_LARGE ?= 600

a-dark:
	$(ADB) shell cmd uimode night yes
	@echo "Android → dark"

a-light:
	$(ADB) shell cmd uimode night no
	@echo "Android → light"

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

# Switch to 3-button navigation
a-nav-buttons:
	$(ADB) shell settings put secure navigation_mode 0
	$(ADB) shell cmd overlay enable com.android.internal.systemui.navbar.threebutton
	$(ADB) shell cmd overlay disable com.android.internal.systemui.navbar.gestural
	@echo "Android → navigation: 3-button"

# Switch to gesture navigation
a-nav-gestures:
	$(ADB) shell settings put secure navigation_mode 2
	$(ADB) shell cmd overlay enable com.android.internal.systemui.navbar.gestural
	$(ADB) shell cmd overlay disable com.android.internal.systemui.navbar.threebutton
	@echo "Android → navigation: gestures"


## --- iOS App - Management (Simulator) ---

.PHONY: i-uninstall

# Uninstall app (removes all data as well)
i-uninstall:
	$(SIMCTL) uninstall $(SIM_DEVICE) $(IOS_BUNDLE_ID)


## --- iOS App - Debugging (Simulator) ---

.PHONY: i-dark i-light
.PHONY: i-font-current i-font-small i-font-default i-font-large

# Enable dark mode
i-dark:
	$(SIMCTL) ui $(SIM_DEVICE) appearance dark
	@echo "iOS simulator → dark"

# Enable light mode
i-light:
	$(SIMCTL) ui $(SIM_DEVICE) appearance light
	@echo "iOS simulator → light"

# Font size (Dynamic Type)
i-font-current:
	$(SIMCTL) ui $(SIM_DEVICE) content_size

i-font-small:
	$(SIMCTL) ui $(SIM_DEVICE) content_size extra-small

i-font-default:
	$(SIMCTL) ui $(SIM_DEVICE) content_size large

i-font-large:
	$(SIMCTL) ui $(SIM_DEVICE) content_size extra-extra-large
