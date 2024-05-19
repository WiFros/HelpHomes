FROM eclipse-temurin:17

RUN apt-get update && \
    apt-get install -y wget && \
    wget https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz && \
    tar -xvf apache-maven-3.9.6-bin.tar.gz && \
    mv apache-maven-3.9.6 /opt/apache-maven-3.9.6 && \
    rm apache-maven-3.9.6-bin.tar.gz && \
    ln -s /opt/apache-maven-3.9.6/bin/mvn /usr/local/bin/mvn

WORKDIR /app
COPY . /app

CMD ["mvn", "clean", "package"]
