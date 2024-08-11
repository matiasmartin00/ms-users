FROM maven:3.9.8-amazoncorretto-21-al2023 AS build

ARG GITHUB_TOKEN

ENV MAVEN_GH_TOKEN=${GITHUB_TOKEN}

WORKDIR /app

COPY code/pom.xml ./

COPY .github/maven-settings.xml /root/.m2/settings.xml

RUN mvn dependency:go-offline

COPY code/src ./src

RUN mvn clean package -DskipTests

FROM azul/zulu-openjdk-alpine:21-latest

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]