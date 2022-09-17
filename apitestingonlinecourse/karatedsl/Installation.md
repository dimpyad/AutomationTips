## Karate DSL QuickStart Guide
- Download and install intellij idea community edition (https://www.jetbrains.com/idea/download/)

### Open intellij and perform following 
- click on New project
- Select Maven
- Select Create from archetype
- Click on Add archetype
- Enter the following details:
  GroupId=com.intuit.karate 
  ArtifactId=karate-archetype
  Version=1.1.0
- Complete the process

### From command line:
mvn archetype:generate \
-DarchetypeGroupId=com.intuit.karate \
-DarchetypeArtifactId=karate-archetype \
-DarchetypeVersion=1.1.0 \
-DgroupId=com.mycompany \
-DartifactId=myproject

### Install Java cucumber plugin
- Go to File -> Settings -> Plugins and install Cucumber for java
