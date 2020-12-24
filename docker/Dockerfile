FROM adoptopenjdk/openjdk11:alpine as builder

WORKDIR application

ARG JAR_FILE

COPY $JAR_FILE app.jar

RUN java -Djarmode=layertools -jar app.jar extract

# =======================================

FROM adoptopenjdk/openjdk11:alpine
# Add Maintainer Info
LABEL maintainer="S.T."

WORKDIR application

ARG JAR_FILE
ARG PORT

ARG javaOpts
ARG appInsightsConnStr

ENV JAVA_OPTS="$javaOpts -javaagent:applicationinsights-agent-3.0.0.jar"
ENV APPLICATIONINSIGHTS_CONNECTION_STRING=$appInsightsConnStr

# Expose port to the outside world
EXPOSE $PORT

COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
COPY applicationinsights-agent-3.0.0.jar ./
COPY applicationinsights.json ./

ENTRYPOINT exec java $JAVA_OPTS org.springframework.boot.loader.JarLauncher
