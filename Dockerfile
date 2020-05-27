ARG VERSION=1.0.0-SNAPSHOT
ARG BUILD_IMAGE=maven: 3.6-openjdk-8
ARG RUNTIME_IMAGE=openjdk:8-jre-alpine

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
COPY --from=package app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar", "--spring.profiles.active=prod"]

