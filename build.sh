#!/bin/bash

_PWD=`pwd`
CopyLibs=$_PWD/lib/org-netbeans-modules-java-j2seproject-copylibstask.jar

CLASSPATH=$CLASSPATH:$_PWD/lib/ant-contrib-1.0b3.jar:$CopyLibs
export CLASSPATH
echo "CLASSPATH:"$CLASSPATH

echo " "
echo "Compiling these projects:"
echo " "
for i in * ; do
  if [ -d "$i" ]; then
    cd "$i"
    echo "----- $i -----"
    ant -Dlibs.CopyLibs.classpath="$CopyLibs" \
        -Dj2ee.server.home="$_PWD/glassfish-libs"

    RET=$?
    if [ ! "$RET" = "0" ]; then
        exit $RET
    fi
    cd ..
  fi
done

