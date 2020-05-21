FROM maven:3.6.3-jdk-11 AS commentMaven

WORKDIR /usr/src/servers/comment
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:11
COPY --from=commentMaven /usr/src/servers/comment/target/comment-manager.jar ./
CMD ["java", "-jar", "comment-manager.jar", "--spring.profiles.active=prod"]
