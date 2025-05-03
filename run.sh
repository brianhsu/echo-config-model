#!/bin/bash
docker run --detach --name node0 --hostname node0.vespanet \
            -e VESPA_CONFIGSERVERS=node0.vespanet,node1.vespanet,node2.vespanet \
            -e VESPA_CONFIGSERVER_JVMARGS="-Xms32M -Xmx128M" \
            -e VESPA_CONFIGPROXY_JVMARGS="-Xms32M -Xmx32M" \
            --network vespanet \
            --publish 19071:19071 --publish 19100:19100 --publish 19050:19050 --publish 20092:19092 \
            myvespa configserver,services

docker run --detach --name node1 --hostname node1.vespanet \
    -e VESPA_CONFIGSERVERS=node0.vespanet,node1.vespanet,node2.vespanet \
    -e VESPA_CONFIGSERVER_JVMARGS="-Xms32M -Xmx128M" \
    -e VESPA_CONFIGPROXY_JVMARGS="-Xms32M -Xmx32M" \
    --network vespanet \
    --publish 19072:19071 --publish 19101:19100 --publish 19051:19050 --publish 20093:19092 \
    myvespa configserver,services

docker run --detach --name node2 --hostname node2.vespanet \
    -e VESPA_CONFIGSERVERS=node0.vespanet,node1.vespanet,node2.vespanet \
    -e VESPA_CONFIGSERVER_JVMARGS="-Xms32M -Xmx128M" \
    -e VESPA_CONFIGPROXY_JVMARGS="-Xms32M -Xmx32M" \
    --network vespanet \
    --publish 19073:19071 --publish 19102:19100 --publish 19052:19050 --publish 20094:19092 \
    myvespa configserver,services


