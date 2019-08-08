# Bidirect

Docker deployment of two dependent Spring Boot applications. Bidirect-b calls bidirect-a for current date and shows it.

While bidirect-b always runs inside docker, bidirect-a can run inside docker or directly on host, without config changes in bidirect-b.

Project shows various docker and docker-compose techniques when application needs to reach outside of docker, including routing, volumes, variables during build/runtime.

Prepared and tested with Docker Toolbox on Windows machine.

## Compiling and running the project

Make packages:

    mvn clean package

Make docker images:

    docker-compose build
    
Run both apps in docker:

    docker-compose up
    
_Results in 2 containers: bidirect-a and bidirect-b apps._

Test app:

	http://docker.local:8081/	//docker.local needs to point to IP of your docker-machine
	
_Results in message with current date_

Now to the insteresting stuff, run bidirect-a directly on host:

    java -jar bidirect-a\target\bidirect-a-0.0.1-SNAPSHOT.jar

Use docker-compose.a-on-host override to replace bidirect-a container with one that routes traffic to host:

**Check first that bidirect-host-routing/start.sh has Unix line endings (LF)**

**Also check that .env file contains IP which your host has assigned (HOST_IP=192.168.56.1)**

    docker-compose -f docker-compose.yml -f docker-compose.a-on-host.yaml build
    
    docker-compose -f docker-compose.yml -f docker-compose.a-on-host.yaml up
    
_Results in 2 containers: bidirect-a which routes traffic to host and bidirect-b app (which remains same)_

Test app:

	http://docker.local:8081/	//docker.local needs to point to IP of your docker-machine

_Results in message with current date, check console of bidirect-a on host logs that current date was requested_
	
Cleanup:

	docker-compose down
	

## References

* [Docker Compose](https://docs.docker.com/compose/) - Docker Compose
* [Docker Toolbox](https://github.com/docker/toolbox/releases) - Docker Toolbox


