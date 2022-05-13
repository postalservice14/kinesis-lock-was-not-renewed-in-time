FROM openjdk:17-alpine
ADD build/libs/producer*.jar producer.jar

ENTRYPOINT $JAVA_HOME/bin/java -Djava.security.egd=file:/dev/./urandom -jar producer.jar