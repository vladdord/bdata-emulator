FROM java:8

EXPOSE 8081

COPY ["service/build/libs/spring-proxy*.jar", "proxy.jar"]

ENTRYPOINT ["java", "-jar", "proxy.jar"]