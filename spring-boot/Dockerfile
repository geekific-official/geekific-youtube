FROM ubuntu:22.04

RUN apt-get update
RUN apt-get install -y openjdk-17-jdk openjdk-17-jre maven

COPY . /spring-boot-app

WORKDIR /spring-boot-app

RUN mvn clean install

WORKDIR /spring-boot-app/target

CMD ["java","-jar","spring-boot-1.0.jar"]
