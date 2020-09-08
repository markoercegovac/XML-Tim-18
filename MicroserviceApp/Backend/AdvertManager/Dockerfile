FROM maven:3.6.3-jdk-11 AS requestMaven

WORKDIR /usr/src/servers/request
COPY . .
RUN ["mvn", "package", "-DskipTests"]
EXPOSE 8080
CMD ["java", "-jar", "target/advert-manager.jar"]
