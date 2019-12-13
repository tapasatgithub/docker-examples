FROM openjdk:8-jre-alpine
FROM maven:alpine
WORKDIR /app
COPY . /app
RUN mvn -v
RUN mvn install -DskipTests
EXPOSE 8080
LABEL maintainer="Tapas Dey"
ADD ./target/springboot-example-0.0.1-SNAPSHOT.jar springboot-example-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","springboot-example-0.0.1-SNAPSHOT.jar"]
