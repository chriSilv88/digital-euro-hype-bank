FROM openjdk:8-jdk-alpine AS java-base

RUN wget -O agent.jar #{opentelemetry-v1.33.4.jar}#

RUN addgroup -S hype && adduser -S -G hype hype
RUN mkdir /app
RUN chown hype:hype /app

ADD target/profile-vantaggi-#{setVersion.originalVersion}#.jar /app/profile-vantaggi.jar
ADD opentelemetry-agent-extension.jar /app/opentelemetry-agent-extension.jar
RUN mv agent.jar /app/agent.jar

FROM gcr.io/distroless/java21-debian12

COPY --from=java-base /etc/passwd /etc/group /etc/shadow /etc/
COPY --from=java-base /app /app

EXPOSE 8080

USER hype

VOLUME /tmp

ENTRYPOINT ["java", "-Xmx2g", "-jar", "-javaagent:/app/agent.jar", "/app/profile-vantaggi.jar"]