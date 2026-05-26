# Use a lightweight JRE for the runtime environment
FROM eclipse-temurin:21-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} test-repo.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/test-repo.jar"]