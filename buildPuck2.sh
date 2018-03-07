#!/bin/sh

echo 'buildPuck2.sh is started';
git clone https://github.com/geoffreycopin/puck2.git puck2FolderCreatedByPreCommitScript
echo 'puck2 is successfully cloned'
cd ./puck2FolderCreatedByPreCommitScript
echo 'We are now in the cloned folder'
./gradlew
echo 'puck2.jar is successfully builded'
cp ./puck2.jar ../
echo "puck2.jar copied in projet's root directory"
cd ..
echo "Coming back to our project's root directory"
rm -rf puck2FolderCreatedByPreCommitScript
echo 'Cloned puck2 folder is deleted'
echo 'All done here. Bye'