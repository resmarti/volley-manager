FROM openjdk:17

ADD target/volley-manager.jar volley-manager.jar

ENTRYPOINT ["java", "-jar", "/volley-manager.jar"]

EXPOSE 8080