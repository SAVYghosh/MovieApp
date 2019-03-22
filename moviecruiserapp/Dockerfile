FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=cplayerdb
ENV MYSQL_USER=fsemovieuser
ENV MYSQL_PASSWORD=FsePassword
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/cplayerdb
ADD ./target/favouriteservice-1.0.jar /usr/src/favouriteservice-1.0.jar
ENTRYPOINT ["java", "-jar", "favouriteservice-1.0.jar"]
