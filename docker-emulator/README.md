docker-emulator
===============

Android test with gradle and Docker.  
The test in this project is desigend to fail so that you can confirm  
that your test environment are set correctly.

## To install sample app onto your device

    ./gradlew installDebug

## To execute tests on your device

    ./gradlew connectedAndroidTest

## To execute tests on Android Emulator with Docker

    ./test.sh

### Prerequisites (for OS X)

To execute this test, the following softwares must be installed:

* VirtualBox
* boot2docker
 
### Android SDK location

If you develop on your host OS envirionment, you would have the file `local.properties`.  
In this file, the location of the Android SDK is defined.  
So if the file exists, tests in Docker container fail because the Android SDK  
won't be found in the container.  
One solution to avoid this situation is to rename `local.properties` to `local.properties.bk`  
while testing and rename `local.properties.bk` to `local.properties` after test.

### Sample output

If your test works, the output will be like this:

    $ ./test.sh                                                                                                                                                                                                   [~/Workspace/android-tests/docker-emulator]
    Starting emulator[5554]...
    Waiting for emulator to start...
    sh: 1: file: not found
    Failed to Initialize backend EGL display
    emulator: WARNING: Could not initialize OpenglES emulation, using software renderer.
    :compileDebugNdk
    :preBuild
    :preDebugBuild
    :checkDebugManifest
    :prepareDebugDependencies
    :compileDebugAidl
    :compileDebugRenderscript
    :generateDebugBuildConfig
    :mergeDebugAssets
    :generateDebugResValues
    :generateDebugResources
    :mergeDebugResources
    :processDebugManifest
    :processDebugResources
    :generateDebugSources
    :compileDebugJava
    :preDexDebug
    :dexDebug
    :processDebugJavaRes UP-TO-DATE
    :validateDebugSigning
    :packageDebug
    :assembleDebug
    :compileDebugTestNdk
    :preDebugTestBuild
    :prepareDebugTestDependencies
    :compileDebugTestAidl
    :processDebugTestManifest
    :compileDebugTestRenderscript
    :generateDebugTestBuildConfig
    :mergeDebugTestAssets
    :generateDebugTestResValues
    :generateDebugTestResources
    :mergeDebugTestResources
    :processDebugTestResources
    :generateDebugTestSources
    :compileDebugTestJava
    :preDexDebugTest
    :dexDebugTest
    :processDebugTestJavaRes UP-TO-DATE
    :packageDebugTest
    :assembleDebugTest
    :connectedAndroidTest
    
    com.example.dockeremulator.MainActivityTest > testOnClick[test(AVD) - 4.2.2] FAILED 
        junit.framework.AssertionFailedError: expected:<NO!> but was:<OK!>
            at com.example.dockeremulator.MainActivityTest.testOnClick(MainActivityTest.java:35)
            :connectedAndroidTest FAILED
    
            FAILURE: Build failed with an exception.
    
            * What went wrong:
            Execution failed for task ':connectedAndroidTest'.
            > There were failing tests. See the report at: file:///workspace/build/reports/androidTests/connected/index.html
    
            * Try:
            Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.
    
            BUILD FAILED
    
            Total time: 1 mins 3.197 secs
