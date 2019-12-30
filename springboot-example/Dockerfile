FROM openjdk:8-jre-alpine
FROM maven:alpine

RUN addgroup -S logstash && adduser -S logstash -G logstash
RUN mkdir /logs && chown logstash:logstash /logs

WORKDIR /app
COPY . /app

RUN mvn -v
RUN mvn install -DskipTests -e

EXPOSE 8080
LABEL maintainer="Tapas Dey"

ENTRYPOINT ["java","-jar","/app/target/springboot-example-0.0.1-SNAPSHOT.jar"]