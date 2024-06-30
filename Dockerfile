FROM ubuntu:latest
RUN apt update -y
RUN apt install -y openjdk-17-jdk
RUN apt install -y maven
RUN apt install -y git
RUN mkdir /console
RUN mkdir /web
WORKDIR /console
COPY console/* .
RUN mvn package
WORKDIR /web
COPY web/src /web/src
COPY web/pom.xml /web/pom.xml
RUN mvn package
# CMD ["java", "-jar", "./target/javaers-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["java","-jar","./target/javaers-0.0.1-SNAPSHOT.jar"]