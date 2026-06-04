#FROM: uses the image - java 21
FROM eclipse-temurin:21-jdk-jammy

MAINTAINER rawnak.com

# copy the jar into docker image
COPY target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar

# the commands when runnig - excuting the application
ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]