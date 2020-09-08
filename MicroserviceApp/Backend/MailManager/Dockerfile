FROM maven:3.6.3-jdk-11 AS mailMaven

WORKDIR /usr/src/servers/mail
COPY . .
RUN ["mvn", "package", "-DskipTests"]
EXPOSE 8080
CMD ["java", "-jar", "target/mail-manager.jar", "--spring.profiles.active=prod"]
