#set( $symbol_dollar = '$' )
# ${artifactId}

# Tech Stack
1. JDK 11
1. Spring Boot
1. Postgres as main Storage
1. Maven 3+
1. Docker, docker-compose

# How to build
1. For *.jar executable launch command in root of the project
    ```shell
    mvn clean package
    ```
1. For Docker image goto docker/ folder and execute
    ```shell
    ./build.sh
    ```
   as a result the following image would be built:
    ```shell
    ${symbol_dollar} docker images
    ... 
    room606/${artifactId}   ${version}   c3938813832e   20 seconds ago   341MB
    ...
    ```
# Launch locally
Start either the main class in IDE or use shell helper script `start.sh` in docker folder:
    ````shell
    ./start.sh
    ````

To stop all deployed stuff use `stop.sh` shell script:
    ````shell
    ./stop.sh
    ````
# Prod deployment
TBD

# Secrets section
TBD

# Monitoring
Hit local link `http://localhost:8081/actuator/`

# Swagger UI

http://localhost:8080/swagger-ui.html

# Database migration

`./mvnw compile flyway:migrate`
