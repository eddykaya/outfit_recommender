FROM java:openjdk-8-jre-alpine

ADD ${project.name}-${project.version}.jar /opt/${project.name}.jar
ADD startApp.sh /opt/startApp.sh

ENTRYPOINT ["bin/sh","/opt/startApp.sh"]