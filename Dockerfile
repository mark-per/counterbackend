FROM openjdk:17
COPY target/Counter.jar Counter.jar
ENTRYPOINT ["java", "-jar", "/Counter.jar"]