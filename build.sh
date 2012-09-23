#!/bin/bash

CLASSPATH=$CLASSPATH:`pwd`/ant-contrib-1.0b3.jar:`pwd`/org-netbeans-modules-java-j2seproject-copylibstask.jar
export CLASSPATH
echo $CLASSPATH

for i in * ; do
  if [ -d "$i" ]; then
    cd "$i"
    ant -Dlibs.CopyLibs.classpath=../org-netbeans-modules-java-j2seproject-copylibstask.jar \
        -Dj2ee.server.home="../Enterprise Application"

    RET=$?
    if [ ! "$RET" = "0" ]; then
        exit $RET
    fi
    cd ..
  fi
done

