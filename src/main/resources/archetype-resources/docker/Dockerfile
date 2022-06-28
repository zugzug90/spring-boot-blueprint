FROM openjdk:11.0.11-jre

MAINTAINER zugzug <noname@noname.noname>

VOLUME /tmp
ADD target/${artifactId}-${version}.jar app.jar
#RUN sh -c 'touch /app.jar'
#ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=5005,suspend=n"
ENV SPRING_PROFILES_ACTIVE "docker"
#EXPOSE 8080 8787
EXPOSE 8080 5005
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -jar /app.jar" ]
