# Most frequently used commands are here

fmt: ## Format code (ktLint) and update ABI (Application Binary Interface) dumps
	./gradlew ktlintFormat && ./gradlew updateKotlinAbi
# More on ABI dumps: https://kotlinlang.org/docs/gradle-binary-compatibility-validation.html
