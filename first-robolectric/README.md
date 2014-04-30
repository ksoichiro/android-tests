first-robolectric
==================

Robolectric with gradle sample project, based on this very nice tutorial:  
[http://www.peterfriese.de/android-testing-with-robolectric/](http://www.peterfriese.de/android-testing-with-robolectric/)

## Usage

You can confirm the basic structure of the Robolectric testable project
in the `first` directory.  

You can try testing with these commands:

    cd first
    ./gradlew test

If the test fails, you can say that the Robolectric is working well
because the test case has `assertTrue(false)`.
