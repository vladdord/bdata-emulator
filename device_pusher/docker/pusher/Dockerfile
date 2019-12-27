FROM java:8

ADD build/libs/device_pusher*.jar pusher.jar

ENTRYPOINT["java", "-jar", "pusher.jar"]