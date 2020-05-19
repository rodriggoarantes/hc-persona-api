ARG VERSION=1.0.0-SNAPSHOT
ARG BUILD_IMAGE=maven:3.6.3-jdk-11-openj9
ARG RUNTIME_IMAGE=adoptopenjdk:11-jre-openj9

#####################################################
###  Stage: Compile                               ###
#####################################################

FROM ${BUILD_IMAGE} as build
ARG MODULE
WORKDIR /app
COPY pom.xml .
COPY . .
RUN mvn -e -B compile -P${MODULE} -DskipTests

#####################################################
###  Stage(Optional): Run Unit Tests              ###
#####################################################

FROM build as test
ARG MODULE
ARG SKIPTESTS=true
WORKDIR /app
RUN if [ "$SKIPTESTS" = "false" ] ; \
    then mvn -e -B test -P${MODULE}; \
    fi

#####################################################
###  Stage: Package                               ###
#####################################################

FROM build as package
ARG MODULE
WORKDIR /app
RUN mvn -e -B package -P${MODULE} -DskipTests

#####################################################
### Stage: Run Image                              ###
#####################################################

FROM ${RUNTIME_IMAGE}
ARG MODULE
COPY --from=package app/product-${MODULE}/target/*.jar app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=env","-jar","/app.jar"]

ARG VERSION
ARG JAR_NAME=target/persona-api-${VERSION}.jar

COPY $JAR_NAME app.jar

ENTRYPOINT ["java", "-Xdebug", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005","-jar","/app.jar", "--spring.profiles.active=prod"]

EXPOSE 8181 15005
