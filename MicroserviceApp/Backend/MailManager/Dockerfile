FROM maven:3.6.3-jdk-11 AS mailMaven

WORKDIR /usr/src/servers/mail
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:11
COPY --from=mailMaven /usr/src/servers/mail/target/mail-manager.jar ./
EXPOSE 8080
CMD ["java", "-jar", "mail-manager.jar", "--spring.profiles.active=prod"]