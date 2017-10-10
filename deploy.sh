#!/usr/bin/env bash
rm -rf docker-stuff/prod/target/springboot-jms-producer-consumer-0.1.0.jar
rm -rf docker-stuff/consumer/target/springboot-jms-producer-consumer-0.1.0.jar
cp build/libs/springboot-jms-producer-consumer-0.1.0.jar docker-stuff/prod/target/springboot-jms-producer-consumer-0.1.0.jar
cp build/libs/springboot-jms-producer-consumer-0.1.0.jar docker-stuff/consumer/target/springboot-jms-producer-consumer-0.1.0.jar
ls -l docker-stuff/prod/target/
ls -l docker-stuff/consumer/target/

