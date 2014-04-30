#!/bin/bash

PROJECT_ROOT=$(cd $(dirname $0) && pwd)

pushd web/ > /dev/null 2>&1

docker build -t ksoichiro/http-mock-server .
CONTAINER_MOCK=`docker run -p 8080:8080 -d ksoichiro/http-mock-server`
echo "Running mock-server: $CONTAINER_MOCK"

LOCAL_PROPERTIES=${PROJECT_ROOT}/local.properties
if [ -f ${LOCAL_PROPERTIES} ]; then
  mv ${LOCAL_PROPERTIES} ${LOCAL_PROPERTIES}.bk
fi
LOCAL_PROPERTIES_APP=${PROJECT_ROOT}/app/local.properties
if [ -f ${LOCAL_PROPERTIES_APP} ]; then
  mv ${LOCAL_PROPERTIES_APP} ${LOCAL_PROPERTIES_APP}.bk
fi

# This does not work... Always fail :(
# Emulator container does not know the http-mock-server container.
#
# Solution?:
#   CONTAINER_MOCK=`docker run --name mock -p 8080:8080 -d ksoichiro/http-mock-server`
#   # TODO: Get IP address of the container 'mock'
#   # TODO: Assign mock's IP as some dummy domain
#   # Also, the app's buildConfigField REMOTE_URL should be fixed.
#   # This does work:
#   #   docker run -t -i --link mock:node ubuntu:12.04 /bin/bash
#   #   $ apt-get install -y curl
#   #   $ curl http://${NODE_PORT_8080_TCP_ADDR}:8080/
#   docker run --link mock:node -i -t -v ${PROJECT_ROOT}:/workspace ksoichiro/android-emulator start-emulator "./gradlew :app:connectedAndroidTestIntegrationDebug"
docker run -i -t -v ${PROJECT_ROOT}:/workspace ksoichiro/android-emulator start-emulator "./gradlew :app:connectedAndroidTestIntegrationDebug"

# Stop daemon http server
docker stop ${CONTAINER_MOCK}

if [ -f ${LOCAL_PROPERTIES_APP}.bk ]; then
  mv ${LOCAL_PROPERTIES_APP}.bk ${LOCAL_PROPERTIES_APP}
fi
if [ -f ${LOCAL_PROPERTIES}.bk ]; then
  mv ${LOCAL_PROPERTIES}.bk ${LOCAL_PROPERTIES}
fi

popd > /dev/null 2>&1

