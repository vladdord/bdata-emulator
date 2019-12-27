FROM java:8

COPY ["service/build/libs/device_pusher*.jar", "pusher.jar"]

ENTRYPOINT ["java", "-jar", "pusher.jar"]