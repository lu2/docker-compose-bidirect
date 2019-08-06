FROM openjdk:12-jdk-alpine
ARG B_VERSION
VOLUME /tmp
COPY target/bidirect-b-${B_VERSION}.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]