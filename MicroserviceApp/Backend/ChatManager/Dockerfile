FROM maven:3.6.3-jdk-11 AS chatMaven

WORKDIR /usr/src/servers/chat
COPY . .
RUN ["mvn", "package", "-DskipTests"]
EXPOSE 8080
CMD ["java", "-jar", "target/chat.jar"]
