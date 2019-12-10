cd /Users/kopever/Workspace/workspace-gitlab/kopdoctor-framework/kopdoctor-parent
mvn clean install
cd /Users/kopever/Workspace/workspace-gitlab/kopdoctor-framework/kopdoctor-archetype
mvn clean install
cd /Users/kopever/Workspace/temp
rm -r kopdoctor-demo
mvn archetype:generate -DgroupId=com.kopdoctor.demo -DartifactId=kopdoctor-demo -DarchetypeGroupId=com.kopdoctor -DarchetypeArtifactId=kopdoctor-archetype -DinteractiveMode=false