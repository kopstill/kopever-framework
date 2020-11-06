call E:
call cd E:\gitlab\kopever-framework\kopever-parent
call mvn clean install
call cd E:\gitlab\kopever-framework\kopever-archetype
call mvn clean install
call C:
call cd C:\Users\Lullaby\Desktop\temp
call rd /s /q kopever-demo
call mvn archetype:generate "-DarchetypeGroupId=com.kopever" "-DarchetypeArtifactId=kopever-archetype" "-DgroupId=com.kopever.demo" "-DartifactId=kopever-demo" "-DinteractiveMode=false"