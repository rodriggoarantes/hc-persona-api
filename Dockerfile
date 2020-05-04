ARG VERSION=1.0.0-SNAPSHOT
FROM openjdk:8-jdk-alpine
VOLUME /tmp
MAINTAINER Rodrigo
LABEL maintainer="rodriggoarantes@gmail.com"

ARG VERSION
ARG JAR_NAME=target/kotlin-study-${VERSION}.jar

COPY $JAR_NAME app.jar

ENTRYPOINT ["java", "-Xdebug", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005","-jar","/app.jar", "--spring.profiles.active=prod"]

EXPOSE 8181 15005
