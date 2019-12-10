call E:
call cd E:\gitlab\kopdoctor-framework\kopdoctor-parent
call mvn clean install
call cd E:\gitlab\kopdoctor-framework\kopdoctor-archetype
call mvn clean install
call C:
call cd C:\Users\Lullaby\Desktop\temp
call rd /s /q kopdoctor-demo
call mvn archetype:generate "-DarchetypeGroupId=com.kopdoctor" "-DarchetypeArtifactId=kopdoctor-archetype" "-DgroupId=com.kopdoctor.demo" "-DartifactId=kopdoctor-demo" "-DinteractiveMode=false"