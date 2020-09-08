FROM maven:3.6.3-jdk-11 AS userMaven

WORKDIR /usr/src/servers/user
COPY . .
RUN ["mvn", "package", "-DskipTests"]
EXPOSE 8080
CMD ["java", "-jar", "target/user-manager.jar"]
