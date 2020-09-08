FROM maven:3.6.3-jdk-11 AS commentMaven

WORKDIR /usr/src/servers/comment
COPY . .
RUN ["mvn", "package", "-DskipTests"]
EXPOSE 8080
CMD ["java", "-jar", "target/comment-manager.jar"]
