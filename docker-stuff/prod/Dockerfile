FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/springboot-jms-producer-consumer-0.1.0.jar app.jar
ENV JAVA_OPTS=""
EXPOSE 8080 61616
ENTRYPOINT exec java $JAVA_OPTS -Dactivemq.broker-url=tcp://172.17.0.2:61616 -Djava.security.egd=file:/dev/./urandom -Djms.consumer-enabled=false -jar /app.jar
