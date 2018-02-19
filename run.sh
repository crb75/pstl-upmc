a#!/bin/bash
rm -rf bin/
mkdir bin/
CP="./lib/hamcrest-core-1.3.jar:./lib/jackson-core-lgpl-1.2.1.jar:./lib/piccolo2d-swt-3.1-SNAPSHOT.jar:./lib/core-0.15.1.jar:./lib/poi-ooxml-schemas-3.14.jar:./lib/commons-codec-1.10.jar:./lib/poi-3.14.jar:./lib/snakeyaml-1.16.jar:./lib/commons-collections-3.2.2.jar:./lib/poi-ooxml-3.14.jar:./lib/stax-api-1.0.1.jar:./lib/opentest4j-1.0.0-M1.jar:./lib/jackson-mapper-lgpl-1.2.1.jar:./lib/slf4j-api-1.7.12.jar:./lib/junit-4.12.jar:./lib/junit-platform-commons-1.0.0-M2.jar:./lib/junit-jupiter-api-5.0.0-M2.jar:./lib/slf4j-simple-1.7.12.jar:./lib/xmlbeans-2.6.0.jar:./lib/piccolo2d-core-3.1-SNAPSHOT.jar:./lib/junit5-0.15.1.jar:./lib/curvesapi-1.03.jar:./lib/piccolo2d-extras-3.1-SNAPSHOT.jar:./lib/dbunit-2.5.3.jar"
# compile
# specify the directory output -d
# specify the classpath -cp

# specify just the class that contains the main method
javac -sourcepath src/ -cp $CP -d ./bin/ $(find ./src/ -name '*.java')

# execution
java -cp "./bin/:$CP:."  com.puck.display.piccolo2d.NewDisplayDG
