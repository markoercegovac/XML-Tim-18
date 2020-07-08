FROM maven:3.6.3-jdk-11 AS requestMaven

WORKDIR /usr/src/servers/request
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:11
COPY --from=requestMaven /usr/src/servers/request/target/advert-manager.jar ./
COPY --from=requestMaven /usr/src/servers/request/images ./images
EXPOSE 8080
CMD ["java", "-jar", "advert-manager.jar"]
