#!/bin/bash
rm -rf bin/
mkdir bin/
CP="./lib/org.junit.jupiter.engine_5.0.0.v20170910-2246.jar:./lib/junit.jar:./lib/org.junit.platform.engine_1.0.0.v20170910-2246.jar:./lib/org.opentest4j_1.0.0.v20170910-2246.jar:./lib/org.junit.jupiter.migrationsupport_5.0.0.v20170910-2246.jar:./lib/piccolo2d-swt-3.1-SNAPSHOT.jar:./lib/org.junit.jupiter.api_5.0.0.v20170910-2246.jar:./lib/org.junit.platform.runner_1.0.0.v20170910-2246.jar:./lib/org.junit.vintage.engine_4.12.0.v20170910-2246.jar:./lib/org.junit.platform.suite.api_1.0.0.v20170910-2246.jar:./lib/org.apiguardian_1.0.0.v20170910-2246.jar:./lib/org.hamcrest.core_1.3.0.v201303031735.jar:./lib/org.junit.platform.commons_1.0.0.v20170910-2246.jar:./lib/piccolo2d-core-3.1-SNAPSHOT.jar:./lib/piccolo2d-extras-3.1-SNAPSHOT.jar:./lib/org.junit.jupiter.params_5.0.0.v20170910-2246.jar:./lib/org.junit.platform.launcher_1.0.0.v20170910-2246.jar."
# compile
# specify the directory output -d
# specify the classpath -cp

# specify just the class that contains the main method
javac -sourcepath src/ -cp $CP -d ./bin/ $(find ./src/ -name '*.java')

# execution
java -cp "./bin/:$CP:."  com.puck.display.piccolo2d.NewDisplayDG
