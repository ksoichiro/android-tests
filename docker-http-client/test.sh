#!/bin/bash

PROJECT_ROOT=$(cd $(dirname $0) && pwd)
echo "Testing on ${PROJECT_ROOT}..."

pushd web/ > /dev/null 2>&1

docker build -t ksoichiro/http-mock-server .
CONTAINER_MOCK=`docker run --name node -p 8080:8080 -d ksoichiro/http-mock-server`
echo "Running mock-server: $CONTAINER_MOCK"

LOCAL_PROPERTIES=${PROJECT_ROOT}/local.properties
if [ -f ${LOCAL_PROPERTIES} ]; then
  mv ${LOCAL_PROPERTIES} ${LOCAL_PROPERTIES}.bk
fi
LOCAL_PROPERTIES_APP=${PROJECT_ROOT}/app/local.properties
if [ -f ${LOCAL_PROPERTIES_APP} ]; then
  mv ${LOCAL_PROPERTIES_APP} ${LOCAL_PROPERTIES_APP}.bk
fi

docker run --link node:mock -i -t -v ${PROJECT_ROOT}:/workspace -w /workspace ksoichiro/android-emulator start-emulator "./gradlew :app:connectedAndroidTestIntegrationDebug"

# Stop daemon http server
docker stop ${CONTAINER_MOCK}
docker rm ${CONTAINER_MOCK}

if [ -f ${LOCAL_PROPERTIES_APP}.bk ]; then
  mv ${LOCAL_PROPERTIES_APP}.bk ${LOCAL_PROPERTIES_APP}
fi
if [ -f ${LOCAL_PROPERTIES}.bk ]; then
  mv ${LOCAL_PROPERTIES}.bk ${LOCAL_PROPERTIES}
fi

popd > /dev/null 2>&1

