# spring-boot-blueprint Maven Archetype

## How to use?

This archetype is published to Maven central. 
You can generate project using this archetype using `mvn archetype:generate` and select the archetype number.

### Install archetype locally

```bash
git clone https://github.com/zugzug90/spring-boot-blueprint.git
cd spring-boot-blueprint
./mvnw clean install
```

### Generate application from archetype

```
mvn archetype:generate \
    -B -DarchetypeGroupId=com.room606.maven.archetypes \
    -DarchetypeArtifactId=spring-boot-blueprint \
    -DarchetypeVersion=0.0.1-SNAPSHOT \
    -DgroupId=com.room606.experimental \
    -DartifactId=experimental-app \
    -Dversion=0.0.1 \
    -Dpackage=com.room606.experimental \
    -DmainClassName=AwesomeApp \
    -DfirstModel=AwesomeItem \
    -DapiPrefix=/restapi/v1.0/awesome/ \
    -DdbName=awesome \
    -DdbUser=awesome_app \
    -DdbPassword=awesome_app \
    -DprojectDescription="Awesome Web App With Cool Features Set" \
    && find . -iname \*.sh -print0 | xargs -r0 chmod +x
```

Generates basic SpringBoot REST API application with the following features:

* Database support (Postgres)
* Configured Dockerfile, Jenkinsfile
* Flyway DB migrations
* Monitoring with Prometheus, Grafana
* ELK based logging

## Developer Notes

Procedure for deploying to Maven Central https://central.sonatype.org/pages/apache-maven.html

Create or update archetypes and set version to SNAPSHOT (ex: 1.0.0-SNAPSHOT)

Deploy SNAPSHOT version to https://oss.sonatype.org/content/repositories/snapshots/

`spring-boot-blueprint> ./mvnw clean deploy -P release`

Deploy release version to Maven Central

```
spring-boot-blueprint> ./mvnw release:clean release:prepare -P release
spring-boot-blueprint> ./mvnw release:perform -P release
```
