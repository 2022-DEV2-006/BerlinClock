# Berlin Clock (Mengenlehreclock or Berlin Uhr)

The Berlin clock consists of 24 lights which are divided into one circular blinking yellow light on top to denote the seconds, two top rows denoting the hours and two bottom rows denoting the minutes.

The clock is read from the top row to the bottom. 

The top row of four red fields denote five full hours each, alongside the second row, also of four red fields, which denote one full hour each, displaying the hour value in 24-hour format. 

The third row consists of eleven yellow-and-red fields, which denote five full minutes each (the red ones also denoting 15, 30 and 45 minutes past), and the bottom row has another four yellow fields, which mark one full minute each. 

The round yellow light on top blinks to denote odd- (when unlit) or even-numbered (when lit) seconds.

# Setup

Clone the project using below command

```bash
https://github.com/2022-DEV2-006/BerlinClock.git
```

Here are some useful Gradle/adb commands for executing this project:

 * `./gradlew runApp` - Builds and install the debug apk on the current connected device.
 * `./gradlew compileApp` - Builds the debug apk.
 * `./gradlew runUnitTests` - Execute unit tests (both unit and integration).
 * `./gradlew connectedAndroidTest` - Execute UI tests.
 
 # Dependencies used
 
 - Jetpack Compose
 
 - Android Hilt
 
 - Google Truth 
 
 
 # Approaches followed 
 
 - Test Driven Development (TDD)

- UI Tests & Unit Tests

- MVVM architecture

- Dependency Injection
