# AnyLLM

WatchApp/
├── app/
│   ├── build.gradle                # Module-level build configuration
│   ├── proguard-rules.pro          # Proguard rules (empty by default)
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml # App manifest file
│   │   │   ├── java/com/example/wearosllmchat/
│   │   │   │   ├── MainActivity.kt       # Main activity with UI and logic
│   │   │   │   ├── LLM.kt                # LLM interface
│   │   │   │   └── OpenAIChatGPT.kt      # OpenAI ChatGPT implementation
│   │   │   └── res/
│   │   │       ├── mipmap/
│   │   │       │   ├── ic_launcher.png
│   │   │       │   └── ic_launcher_round.png
│   │   │       └── values/
│   │   │           ├── strings.xml
│   │   │           ├── themes.xml
│   │   │           └── colors.xml
├── build.gradle                    # Project-level build configuration
├── gradle/
│   ├── gradle-wrapper.jar          # Gradle wrapper executable JAR
│   ├── gradle-wrapper.properties   # Gradle wrapper configuration
├── gradlew                         # Gradle wrapper script (Unix)
├── gradlew.bat                     # Gradle wrapper script (Windows)
└── settings.gradle                 # Gradle settings file


## Description of Key Directories and Files

- **`wearosllmchat/`**: Root project directory.
  - **`app/`**: Main module directory for the WearOS app.
    - **`build.gradle`**: Configures dependencies (e.g., OkHttp, WearOS libraries) and build settings (target SDK 34, min SDK 28).
    - **`proguard-rules.pro`**: Empty by default; can be customized for code shrinking in release builds.
    - **`src/main/`**: Contains the app's source code and resources.
      - **`AndroidManifest.xml`**: Defines permissions (e.g., RECORD_AUDIO, INTERNET) and the main activity.
      - **`java/com/example/wearosllmchat/`**: Package for Kotlin source files.
        - **`MainActivity.kt`**: Core logic for voice chat, including speech recognition, TTS, and button handling.
        - **`LLM.kt`**: Interface defining the `sendMessage` method for LLM interactions.
        - **`OpenAIChatGPT.kt`**: Implementation for OpenAI's ChatGPT API using OkHttp for HTTP requests.
      - **`res/`**: Resource files.
        - **`drawable/`**: Contains default launcher background (not customized here).
        - **`mipmap/`**: App icons (`ic_launcher.png`, `ic_launcher_round.png`) for different screen densities.
        - **`values/`**:
          - **`strings.xml`**: Defines app name and other strings.
          - **`themes.xml`**: Defines the app theme (WearOSLLMChatTheme).
          - **`colors.xml`**: Defines color values (e.g., background).
        - **`layout/`**: Empty since the app uses Jetpack Compose for UI.
    - **`src/androidTest/` and `src/test/`**: Placeholder directories for tests (not implemented yet).
  - **`build.gradle`**: Project-level Gradle file configuring repositories and buildscript dependencies.
  - **`gradle/`**: Gradle wrapper files for consistent builds across systems.
  - **`gradlew` and `gradlew.bat`**: Scripts to run Gradle commands.
  - **`settings.gradle`**: Includes the app module in the project.

## Additional Notes

- **Resources**: The `res/` directory includes minimal customization since the UI is built with Compose in `MainActivity.kt`. Default icons and themes are assumed from the WearOS template in Android Studio.
- **Testing**: The `androidTest/` and `test/` directories are empty but can be populated with tests for robustness.
- **Scalability**: Additional LLM implementations (e.g., `GoogleGemini.kt`, `xAIGrok.kt`) would go under `java/com/example/wearosllmchat/` alongside `OpenAIChatGPT.kt`.
- **Setup**: To build this in Android Studio, create a new WearOS project, replace the files with the provided code, and sync Gradle with the specified dependencies.

This hierarchy aligns with the code provided earlier, ensuring a functional WearOS app for hands-free LLM chat on your Samsung Galaxy Watch 6.