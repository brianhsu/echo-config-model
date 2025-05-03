#!/bin/bash

mvn -f config-model-plugin clean package

docker build -t myvespa . --no-cache

pushd vespa-app
ls -lh
zip ../application.zip -r .
popd
