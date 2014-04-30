#!/bin/bash

cd $(dirname $0)
mv local.properties local.properties.bk
docker run -t -i -v `pwd`:/workspace ksoichiro/android-emulator start-emulator "./gradlew connectedAndroidTest"
mv local.properties.bk local.properties
