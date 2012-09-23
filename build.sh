#!/bin/bash

CopyLibs=`pwd`/org-netbeans-modules-java-j2seproject-copylibstask.jar

CLASSPATH=$CLASSPATH:`pwd`/ant-contrib-1.0b3.jar:$CopyLibs
export CLASSPATH
echo "CLASSPATH:"$CLASSPATH

for i in * ; do
  if [ -d "$i" ]; then
    cd "$i"
    ant -Dlibs.CopyLibs.classpath="$CopyLibs" \
        -Dj2ee.server.home="../Enterprise Application"

    RET=$?
    if [ ! "$RET" = "0" ]; then
        exit $RET
    fi
    cd ..
  fi
done

