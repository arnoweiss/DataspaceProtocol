#!/bin/bash
set -e

mkdir -p HEAD
git fetch --all --tags
tags_string=$(git tag)
echo got tag string
echo $tags_string
tags_array=($tags_string)
mv $(ls --ignore=HEAD) HEAD/
for tag in "${tags_array[@]}"
do
  echo starting with tag $tag
  mkdir $tag
  cd $tag
  git clone https://github.com/eclipse-dataspace-protocol-base/DataspaceProtocol.git --depth 1 --branch ${tag} --quiet
  pwd
  mv ./DataspaceProtocol/* .
  cd ..
done
pwd
for dir in */; do
  if [ -f "$dir/index.html" ]; then
      mkdir ./figures
      mkdir -p ./message/schema
      mkdir -p ./message/example
      mkdir -p ./message/table
      cp -r "./artifacts/src/main/resources"/**/* ./message/schema || true
      echo "successfully copied message schemas"
      cp -r "./artifacts/src/main/resources"/**/"example"/* ./message/example
      echo "successfully copied message examples"
      cp -r "./specifications"/**/"figures"/*".png" ./figures/
      echo "successfully copied figures"
      cp -r "./artifacts/build/generated/tables"/*".html" ./message/table
      echo "successfully copied message property tables"
  else
    echo "index does not exist. No copy operations"
  fi
done