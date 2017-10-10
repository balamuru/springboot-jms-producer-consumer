FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/springboot-jms-producer-consumer-0.1.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Dserver.port=9090 -Dactivemq.broker-url=tcp://172.17.0.2:61616 -Djava.security.egd=file:/dev/./urandom -jar /app.jar
