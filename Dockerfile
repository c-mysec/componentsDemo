#From tomcat:8.0.51-jre8-alpine
#RUN rm -rf /usr/local/tomcat/webapps/*
#COPY ./target/restapi_osg-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
#CMD ["catalina.sh","run"]


FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/*.jar compdemo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=dev","-jar","/compdemo.jar"]