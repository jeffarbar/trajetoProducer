FROM openjdk:8-jdk-alpine
RUN mkdir /app
COPY target/*.jar /app/trajetoProducer.jar
WORKDIR /app
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "trajetoProducer.jar"]