#!/usr/bin/env bash

./gradlew build
java \
    -javaagent:libs/aspectjweaver-1.8.10.jar \
    -javaagent:libs/spring-instrument-4.3.6.RELEASE.jar \
    -jar build/libs/ddd-aop-entity-behaviour-1.0-SNAPSHOT.jar
