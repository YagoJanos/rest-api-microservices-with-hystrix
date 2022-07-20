# Tweet and repository counter API

## User manual

### 1-Clone this repository.

### 2-In each project, enter the following command through the terminal:
***./gradlew bootjar***

**This will create the jar for each service.**
**I put this step outside the dockerfile thinking about deployment speed. Compiling each service would make each deploy more time consuming.**

### 3- In twitter-api project, go to Dockerfile and put your Bearer_Toker.

### 4- Build an image from each Dockerfile by entering in the terminal:

***docker build -t "twitterapi" .*** (inside twitter-api project)

***docker build -t "githubapi" .*** (inside github-api project)

***docker build -t "mainapi" .*** (inside main-api project)

### 5- Run a container for each project with the respective ports:

***docker run -d -p 8081:8081 twitterapi***

***docker run -d -p 8082:8082 githubapi***

***docker run --network="host" -d -p 8083:8083 mainapi***

### 6. Access the url http://localhost:8083/pubcounter/accounts?twitter=YOURTWITTERACCOUNT&github=YOURGITHUBPROFILEACCOUNT

**Change YOURTWITTERACCOUNT to your twitter account username and change YOURGITHUBPROFILEACCOUNT to your github profile username.**
#### For example:
**http://localhost:8083/pubcounter/accounts?twitter=janosyago&github=yagojanos**

## Hystrix Dashboard

**If you want to use Hystrix Dashboard, just download its .war file from the maven repository:**

***https://repo1.maven.org/maven2/com/netflix/hystrix/hystrix-dashboard/1.5.8/***

**Now place this .war file in Tomcat's webapps folder, start the server and access the URL:**

***http://localhost:8080/hystrix-dashboard-1.5.18/***

**Now register the services that you want to monitor in the second text box:**

**(To monitor the Twitter API service)**

***http://localhost:8081/hystrix.stream***

**Do this with the other services with their respective ports.**
