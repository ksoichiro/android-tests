docker-http-client
==================

### Sample Output

    $ ./test.sh                                                                                                                                                                                                [~/Workspace/android-tests/docker-http-client]
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
     ---> 3d798cda9ca8
    Step 4 : RUN cd /src; npm install
     ---> Using cache
     ---> 00ae8897bb94
    Step 5 : EXPOSE 8080
     ---> Running in e19bf5f194a6
     ---> 5f1f4af16cbb
    Step 6 : CMD ["node", "/src/index.js"]
     ---> Running in f0ecdddf8af4
     ---> 926d1ace8dd4
    Successfully built 926d1ace8dd4
    Removing intermediate container e19bf5f194a6
    Removing intermediate container f0ecdddf8af4
    Running mock-server: 582b772a29c241bdcffdc8ea63411113578dddd0373c5699dc335bab503e8e2e
    Starting emulator[5554]...
    Waiting for emulator to start...
    sh: 1: file: not found
    Failed to Initialize backend EGL display
    emulator: WARNING: Could not initialize OpenglES emulation, using software renderer.
    :app:compileIntegrationDebugNdk
    :app:preBuild
    :app:preIntegrationDebugBuild
    :app:checkIntegrationDebugManifest
    :app:prepareIntegrationDebugDependencies
    :app:compileIntegrationDebugAidl
    :app:compileIntegrationDebugRenderscript
    :app:generateIntegrationDebugBuildConfig
    :app:mergeIntegrationDebugAssets
    :app:generateIntegrationDebugResValues
    :app:generateIntegrationDebugResources
    :app:mergeIntegrationDebugResources
    :app:processIntegrationDebugManifest
    :app:processIntegrationDebugResources
    :app:generateIntegrationDebugSources
    :app:compileIntegrationDebugJava
    :app:preDexIntegrationDebug
    :app:dexIntegrationDebug
    :app:processIntegrationDebugJavaRes UP-TO-DATE
    :app:validateDebugSigning
    :app:packageIntegrationDebug
    :app:assembleIntegrationDebug
    :app:compileIntegrationDebugTestNdk
    :app:preIntegrationDebugTestBuild
    :app:prepareIntegrationDebugTestDependencies
    :app:compileIntegrationDebugTestAidl
    :app:processIntegrationDebugTestManifest
    :app:compileIntegrationDebugTestRenderscript
    :app:generateIntegrationDebugTestBuildConfig
    :app:mergeIntegrationDebugTestAssets
    :app:generateIntegrationDebugTestResValues
    :app:generateIntegrationDebugTestResources
    :app:mergeIntegrationDebugTestResources
    :app:processIntegrationDebugTestResources
    :app:generateIntegrationDebugTestSources
    :app:compileIntegrationDebugTestJava
    :app:preDexIntegrationDebugTest
    :app:dexIntegrationDebugTest
    :app:processIntegrationDebugTestJavaRes UP-TO-DATE
    :app:packageIntegrationDebugTest
    :app:assembleIntegrationDebugTest
    :app:connectedAndroidTestIntegrationDebug
    
    com.example.dockerhttpclient.MainActivityTest > testOnClickConnect[test(AVD) - 4.2.2] FAILED 
        junit.framework.AssertionFailedError: expected:<Result: 0> but was:<Hello World>
        at com.example.dockerhttpclient.MainActivityTest.testOnClickConnect(MainActivityTest.java:38)
    :app:connectedAndroidTestIntegrationDebug FAILED
    
    FAILURE: Build failed with an exception.
    
    * What went wrong:
    Execution failed for task ':app:connectedAndroidTestIntegrationDebug'.
    > There were failing tests. See the report at: file:///workspace/app/build/reports/androidTests/connected/flavors/integration/index.html
    
    * Try:
    Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.
    
    BUILD FAILED
    
    Total time: 1 mins 51.964 secs
    582b772a29c241bdcffdc8ea63411113578dddd0373c5699dc335bab503e8e2e
