FROM java:8

ADD build/libs/spring-proxy*.jar proxy.jar

ENTRYPOINT["java", "-jar", "proxy.jar"]