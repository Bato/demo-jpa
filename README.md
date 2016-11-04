# Demo JPA 

The default database is H2 memory database but I have also added configuration needed to use HSQL, 
MySQL and PostgreSQL.

Set environment
```batch 
set M2_HOME=D:\tools\maven\apache-maven-3.3.3
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_05

set PATH=%JAVA_HOME%\bin
set PATH=%PATH%;%M2_HOME%\bin
set PATH=%PATH%;%SystemRoot%\system32;%SystemRoot%

set eclipse=D:\eclipse\eclipse-jee-mars\eclipse.exe
set workspace=D:\dev\wss\ws_SpringData
```

## About Spring Boot Maven Plugin

The plugin provides several goals to work with a Spring Boot application:

    repackage: create a jar or war file that is auto-executable. It can replace the regular artifact or can be attached to the build lifecycle with a separate classifier.
    run: run your Spring Boot application with several options to pass parameters to it.
    start and stop: integrate your Spring Boot application to the integration-test phase so that the application starts before it.
    build-info: generate a build information that can be used by the Actuator.
     
     

The active profiles to use in this application can be specified using the profiles argument. 
The following configuration enables the h2,mysql,hsql and bar profiles:
```   
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<profiles>
						<profile>h2</profile>
						<profile>mysql</profile>
						<profile>hsql</profile>
						<profile>postgresql</profile>						
					</profiles>
				</configuration>         				
			</plugin>
			
```
For more details see [http://docs.spring.io/spring-boot/docs/current/maven-plugin/usage.html](Usage)

Quick Start

cd /D D:\tools\Spring\Boot\demo-jpa

mvn clean spring-boot:run -Drun.profiles=h2
mvn clean spring-boot:run -Drun.profiles=mysql
mvn clean spring-boot:run -Drun.profiles=postgresql
mvn verify -Dit.skip=true

mvn package -Dmaven.test.skip -Drun.profiles=development
java -jar -Drun.profiles=development target\wps-microservice-0.0.1-SNAPSHOT.jar
```

# Test 

```
curl -i -X GET --url http://localhost:8080/api/ElementCollection

```
# Links

