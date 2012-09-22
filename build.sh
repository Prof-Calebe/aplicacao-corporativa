!#/bin/bash

classpath=$classpath:$pwd/ant-contrib-1.0b3.jar:$pwd/org-netbeans-modules-java-j2seproject-copylibstask.jar
export classpath
echo $classpath

for i in * ; do
  if [ -d "$i" ]; then
    cd "$i"
    ant

    RET=$?
    if [ ! "$RET" = "0" ]; then
        exit $RET
    fi
    cd ..
  fi
done

