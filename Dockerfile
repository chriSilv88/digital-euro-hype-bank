FROM openjdk:8-jdk-alpine AS java-base

ADD opentelemetry-javaagent.jar /app/opentelemetry-javaagent.jar

RUN addgroup -S hype && adduser -S -G hype hype
RUN mkdir -p /app/tmp
RUN chown -R hype:hype /app

ADD target/poc-digital-euro-0.0.1-SNAPSHOT.jar /app/profile-vantaggi.jar
ADD opentelemetry-agent-extension.jar /app/opentelemetry-agent-extension.jar
RUN mv agent.jar /app/agent.jar

FROM gcr.io/distroless/java21-debian12

COPY --from=java-base /etc/passwd /etc/group /etc/shadow /etc/
COPY --from=java-base /app /app

EXPOSE 8080
USER hype
VOLUME /tmp

ENTRYPOINT ["java", "-Xmx2g", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "/app/profile-vantaggi.jar"]
