docker-http-client
==================

This sample project includes HTTP client and in the test, the emulator send HTTP request to
Docker Node container.  

### Sample Output

    $ ./test.sh
    Uploading context 5.632 kB
    Uploading context 
    Step 0 : FROM centos:6.4
     ---> 539c0211cd76
    Step 1 : RUN rpm -Uvh http://download.fedoraproject.org/pub/epel/6/i386/epel-release-6-8.noarch.rpm
     ---> Using cache
     ---> 15b4bc81e79a
    Step 2 : RUN yum install -y npm
     ---> Using cache
     ---> d6e1c3f93596
    Step 3 : ADD . /src
     ---> Using cache
     ---> 57227d737194
    Step 4 : RUN cd /src; npm install
     ---> Using cache
     ---> dbc48f7c65ef
    Step 5 : EXPOSE 8080
     ---> Running in a4a2da5cee76
     ---> d67421875c86
    Step 6 : CMD ["node", "/src/index.js"]
     ---> Running in 2225692011aa
     ---> e8fff0ab9647
    Successfully built e8fff0ab9647
    Removing intermediate container a4a2da5cee76
    Removing intermediate container 2225692011aa
    Running mock-server: 5f86d3e2844bf95827298cb915beb18c04415bf403a969ddb284fabf60b65aac
    Starting emulator[5554]...
    Waiting for emulator to start...
    sh: 1: file: not found
    Failed to Initialize backend EGL display
    emulator: WARNING: Could not initialize OpenglES emulation, using software renderer.
    Download http://repo1.maven.org/maven2/com/android/tools/build/gradle/0.9.2/gradle-0.9.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/build/builder/0.9.2/builder-0.9.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/lint/lint/22.7.2/lint-22.7.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/build/builder-model/0.9.2/builder-model-0.9.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/sdk-common/22.7.2/sdk-common-22.7.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/build/manifest-merger/22.7.2/manifest-merger-22.7.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/ddms/ddmlib/22.7.2/ddmlib-22.7.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/sdklib/22.7.2/sdklib-22.7.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/build/builder-test-api/0.9.2/builder-test-api-0.9.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/common/22.7.2/common-22.7.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/lint/lint-checks/22.7.2/lint-checks-22.7.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/layoutlib/layoutlib-api/22.7.2/layoutlib-api-22.7.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/dvlib/22.7.2/dvlib-22.7.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/lint/lint-api/22.7.2/lint-api-22.7.2.pom
    Download http://repo1.maven.org/maven2/com/android/tools/build/gradle/0.9.2/gradle-0.9.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/build/builder/0.9.2/builder-0.9.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/lint/lint/22.7.2/lint-22.7.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/build/builder-model/0.9.2/builder-model-0.9.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/sdk-common/22.7.2/sdk-common-22.7.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/build/manifest-merger/22.7.2/manifest-merger-22.7.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/ddms/ddmlib/22.7.2/ddmlib-22.7.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/sdklib/22.7.2/sdklib-22.7.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/build/builder-test-api/0.9.2/builder-test-api-0.9.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/common/22.7.2/common-22.7.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/lint/lint-checks/22.7.2/lint-checks-22.7.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/layoutlib/layoutlib-api/22.7.2/layoutlib-api-22.7.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/dvlib/22.7.2/dvlib-22.7.2.jar
    Download http://repo1.maven.org/maven2/com/android/tools/lint/lint-api/22.7.2/lint-api-22.7.2.jar
    :app:compileIntegrationDebugNdk UP-TO-DATE
    :app:preBuild
    :app:preIntegrationDebugBuild
    :app:checkIntegrationDebugManifest
    :app:prepareIntegrationDebugDependencies
    :app:compileIntegrationDebugAidl UP-TO-DATE
    :app:compileIntegrationDebugRenderscript UP-TO-DATE
    :app:generateIntegrationDebugBuildConfig
    :app:mergeIntegrationDebugAssets
    :app:generateIntegrationDebugResValues UP-TO-DATE
    :app:generateIntegrationDebugResources UP-TO-DATE
    :app:mergeIntegrationDebugResources
    :app:processIntegrationDebugManifest
    :app:processIntegrationDebugResources
    :app:generateIntegrationDebugSources
    :app:compileIntegrationDebugJava
    :app:preDexIntegrationDebug UP-TO-DATE
    :app:dexIntegrationDebug
    :app:processIntegrationDebugJavaRes UP-TO-DATE
    :app:validateDebugSigning
    :app:packageIntegrationDebug
    :app:assembleIntegrationDebug
    :app:compileIntegrationDebugTestNdk UP-TO-DATE
    :app:preIntegrationDebugTestBuild
    :app:prepareIntegrationDebugTestDependencies
    :app:compileIntegrationDebugTestAidl UP-TO-DATE
    :app:processIntegrationDebugTestManifest UP-TO-DATE
    :app:compileIntegrationDebugTestRenderscript UP-TO-DATE
    :app:generateIntegrationDebugTestBuildConfig UP-TO-DATE
    :app:mergeIntegrationDebugTestAssets UP-TO-DATE
    :app:generateIntegrationDebugTestResValues UP-TO-DATE
    :app:generateIntegrationDebugTestResources UP-TO-DATE
    :app:mergeIntegrationDebugTestResources UP-TO-DATE
    :app:processIntegrationDebugTestResources UP-TO-DATE
    :app:generateIntegrationDebugTestSources UP-TO-DATE
    :app:compileIntegrationDebugTestJava
    :app:preDexIntegrationDebugTest UP-TO-DATE
    :app:dexIntegrationDebugTest UP-TO-DATE
    :app:processIntegrationDebugTestJavaRes UP-TO-DATE
    :app:packageIntegrationDebugTest
    :app:assembleIntegrationDebugTest
    :app:connectedAndroidTestIntegrationDebug
    
    BUILD SUCCESSFUL
    
    Total time: 1 mins 16.064 secs
    5f86d3e2844bf95827298cb915beb18c04415bf403a969ddb284fabf60b65aac
    5f86d3e2844bf95827298cb915beb18c04415bf403a969ddb284fabf60b65aac
