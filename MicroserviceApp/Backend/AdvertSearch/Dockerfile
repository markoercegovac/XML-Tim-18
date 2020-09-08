FROM maven:3.6.3-jdk-11 AS searchMaven

WORKDIR /usr/src/servers/search
COPY . .
RUN ["mvn", "package", "-DskipTests"]
EXPOSE 8080
CMD ["java", "-jar", "target/search-manager.jar"]
