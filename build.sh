!#/bin/bash

for i in * ; do
  if [ -d "$i" ]; then
    cd "$i"
    ant
    cd ..
  fi
done

