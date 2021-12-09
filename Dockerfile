
FROM maven:3.8.3-jdk-11

COPY ./target/demo1-0.0.1-SNAPSHOT.jar server.jar
CMD ["java","-jar","server.jar"]