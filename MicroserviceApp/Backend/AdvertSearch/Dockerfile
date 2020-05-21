FROM maven:3.6.3-jdk-11 AS searchMaven

WORKDIR /usr/src/servers/search
COPY . .
RUN ["mvn", "package", "-DskipTests"]

FROM openjdk:11
COPY --from=searchMaven /usr/src/servers/search/target/advert-search.jar ./
EXPOSE 8080
CMD ["java", "-jar", "advert-search.jar", "--spring.profiles.active=prod"]