FROM openjdk:17-alpine
ADD build/libs/consumer*.jar consumer.jar

ENTRYPOINT $JAVA_HOME/bin/java -Djava.security.egd=file:/dev/./urandom -jar consumer.jar