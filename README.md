# Issue Demo: Spring Boot + Log4j2 + Azure App Insights

## Steps to reproduce issue

1. In the project's run directory, build project and copy built jar to the Docker workdir:

```bash
mvn clean package
cp target/demo-0.0.1-SNAPSHOT.jar docker/
```

2. In the `docker` directory, build a local docker image with:

```bash
docker build -t azure/ai-demo:latest \
--build-arg JAR_FILE=demo-0.0.1-SNAPSHOT.jar \
--build-arg PORT=8081 \
--build-arg javaOpts="" \
--build-arg appInsightsConnStr="InstrumentationKey=..." \
.
```

3. Run a new container locally, and check whether logs are pushed on App Insights:

```bash
docker run -a stdout --rm -p 8081:8081 azure/ai-demo:latest
```
