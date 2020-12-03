# kotlin_espresso

A Demo mobile app based on Java to perform UI Tests using Kotlin and Espresso.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for learning purposes.

### Prerequisites

> #### Java JDK
> #### Android Studio + Android SDK
> - Download [Android Studio](https://developer.android.com/studio)
> - Remember to set the environment variable ANDROID_HOME into PATH
> - Create a new Android device

### Installing

> #### Gradle dependencies
> - All the dependencies are managed by Gradle, so you don't need to install any extra program or library.

### Settings
> Open the project and wait for Gradle's dependencies download.
> To verify the project you could run **build** task or execute the app from *play* button and check it.

### Project Structure
> - The project has two languages: Java for the App and Kotlink for the Tests
> - The App is inside the *java* folder inside the package *com.kotlin.espresso* and contains *views* and *core.helper* packages
> - The Tests are inside the *java* folder inside the package *com.kotlin.espresso (androidTest)* and this package has *views* and *flows* packages
> - In the *views* package are located tests that are executed only in this view. Meanwhile, the *flows* package contains tests that perform actions on more than one view.

## Running the tests
> - To run the test you must have a device started firstly
> - Then you could run a specific test or class from the TestSuite (kotlin file) or execute the Gradle task: *app > Task > verification > connectedAndroidTest*
> - All the test cases must be PASSED


## Versioning

We use [SemVer](http://semver.org/) for versioning. 

## Authors

* **David Gonzalez** - *Initial work* - [github](https://github.com/dsgon/) - [twitter](https://twitter.com/__dsgon) - [linkedIn](www.linkedin.com/in/dsgon)
