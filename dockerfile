#base image
FROM openjdk:11
ADD target/GenerateApplicationRunnableJar.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]