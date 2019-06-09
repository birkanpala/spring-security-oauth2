# Spring Boot OAuth2 Client

### Register OAuth2 Application
Register a OAuth application on [Github](https://github.com/settings/applications/new) and [Google](https://console.developers.google.com/).

### Configure application.yml
Replace `GITHUB_CLIENT_ID` and `GITHUB_CLIENT_SECRET` with Github credentials.

Replace `GOOGLE_CLIENT_ID` and `GOOGLE_CLIENT_SECRET` with Github credentials.


### Run
`gradlew bootRun`

http://localhost:8080

### Build a Docker daemon
`gradlew jibDockerBuild`

Run with

`docker run -p 8080:8080 spring-secuirty-oauth2:0.0.1-SNAPSHOT`
