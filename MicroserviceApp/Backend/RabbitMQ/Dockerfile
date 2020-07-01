FROM rabbitmq:3.6.11-management-alpine

EXPOSE 4369
EXPOSE 5671
EXPOSE 5672
EXPOSE 15671
EXPOSE 15672
EXPOSE 25672

ADD rabbitmq.config /etc/rabbitmq/
ADD definitions.json /etc/rabbitmq/
