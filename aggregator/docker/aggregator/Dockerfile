FROM java:8

COPY ["service/build/libs/aggregator*.jar", "aggregator.jar"]

ENTRYPOINT ["java", "-jar", "aggregator.jar"]