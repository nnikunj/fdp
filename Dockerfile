FROM centos:7
RUN yum update -y
RUN yum install java-1.8.0-openjdk-devel -y
RUN mkdir -p /opt/fdp/app/
RUN mkdir -p /opt/fdp/logs/
COPY FDP/target/FDP-0.0.1-SNAPSHOT.jar /opt/fdp/app/
COPY start-rest /usr/local/bin
RUN  chmod +x /usr/local/bin/start-rest

EXPOSE 8181
ENTRYPOINT  start-rest

