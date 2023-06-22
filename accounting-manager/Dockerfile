ARG APP_JAR=accounting-manager-0.0.1-SNAPSHOT.jar
FROM maven:3.8.1-openjdk-17 AS build
COPY . /usr/src/app/accounting-manager
WORKDIR /usr/src/app/accounting-manager
RUN mvn clean package

FROM openjdk:17
LABEL maintainer="Evren Tan"
ARG APP_JAR
ENV APP_JAR_ENV=$APP_JAR
EXPOSE 8833
RUN mkdir /app
COPY --from=build /usr/src/app/accounting-manager/target/${APP_JAR_ENV} /app/${APP_JAR_ENV}
ENTRYPOINT java -jar /app/${APP_JAR_ENV}