FROM maven:3.6.3-jdk-11 AS requestMaven

WORKDIR /usr/src/servers/request
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:11
COPY --from=requestMaven /usr/src/servers/request/target/request-manager.jar ./
EXPOSE 8080
CMD ["java", "-jar", "request-manager.jar"]

