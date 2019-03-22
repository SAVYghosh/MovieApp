FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=newsfeeddb
ENV MYSQL_USER=fsemovieuser
ENV MYSQL_PASSWORD=FsePassword
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/newsfeeddb
ADD ./target/authenticationapp-0.0.1-SNAPSHOT.jar /usr/src/authenticationapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "authenticationapp-0.0.1-SNAPSHOT.jar"]
