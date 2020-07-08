FROM maven:3.6.3-jdk-11 AS userMaven

WORKDIR /usr/src/servers/user
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:11
COPY --from=userMaven /usr/src/servers/user/target/user-manager.jar ./
EXPOSE 8081
CMD ["java", "-jar", "user-manager.jar"]
