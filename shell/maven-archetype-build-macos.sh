cd /Users/kopever/Workspace/workspace-gitlab/kopever-framework/kopever-parent
mvn clean install
cd /Users/kopever/Workspace/workspace-gitlab/kopever-framework/kopever-archetype
mvn clean install
cd /Users/kopever/Workspace/temp
rm -r kopever-demo
mvn archetype:generate -DgroupId=com.kopever.demo -DartifactId=kopever-demo -DarchetypeGroupId=com.kopever -DarchetypeArtifactId=kopever-archetype -DinteractiveMode=false