FROM openjdk:21-jdk-oraclelinux8
WORKDIR /app
COPY ./target/redis-mongo-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "redis-mongo-0.0.1-SNAPSHOT.jar"]