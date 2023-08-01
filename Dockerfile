FROM openjdk:17

ADD target/schedule-0.0.1-SNAPSHOT.jar schedule.jar

ENTRYPOINT [ "java" , "-jar" , "/schedule.jar" ]

