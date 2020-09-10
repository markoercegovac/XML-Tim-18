FROM mysql:8.0.19
LABEL author="tiberlas1997@gmail.com"

ENV MYSQL_ROOT_PASSWORD=SuperRootPassword1
ENV MYSQL_ALLOW_EMPTY_PASSWORD="true"
ENV MYSQL_DATABASE=main
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=AdminPassword1

ADD init.sql /docker-entrypoint-initdb.d/

EXPOSE 3306