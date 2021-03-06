FROM debian:latest
RUN apt-get update && apt-get upgrade -y && apt-get install -y software-properties-common && apt-get install default-jdk -y
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
ENV PATH="$PATH:$JAVA_HOME/bin"
RUN useradd -ms /bin/bash monitor
USER monitor
WORKDIR /home/monitor
RUN mkdir -p stapi_uat/bin
