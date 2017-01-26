#!/bin/bash

mvn clean install -DskipTests
oc start-build automation-api --from-dir=. -w