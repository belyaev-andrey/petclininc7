FROM openjdk:11
COPY . /opt/petclinic
CMD java -Dspring.profiles.active=dev,docker -Dapp.home=/opt/petclinic-home -jar /opt/petclinic/app-core.jar