# FROM adoptopenjdk/openjdk11:alpine-jre
#ADD target/CRUDAccenture-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]

FROM adoptopenjdk/openjdk11:alpine
ADD target/CRUDAccenture-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]