FROM openjdk:12-jdk-alpine
ARG A_VERSION
VOLUME /tmp
COPY target/bidirect-a-${A_VERSION}.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]