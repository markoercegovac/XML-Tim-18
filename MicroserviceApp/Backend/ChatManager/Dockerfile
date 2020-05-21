FROM maven:3.6.3-jdk-11 AS chatMaven

WORKDIR /usr/src/servers/chat
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:11
COPY --from=chatMaven /usr/src/servers/chat/target/chat.jar ./
EXPOSE 8080
CMD ["java", "-jar", "chat.jar", "--spring.profiles.active=prod"]

