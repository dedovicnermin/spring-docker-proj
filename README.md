###
Any changes made to the file should follow up with these commands in your shell

	: (root of proj) $ mvn clean package -DskipTests
	:		 $ cp target/<projfoldername>-0.0.1-SNAPSHOT.jar src/main/docker


### Docker container startup
 
* $ cd src/main/docker
* $ docker-compose down			(not necessary if first time)
* $ docker rmi <projname>:latest      	(not necessary if first time)
* $ docker-compose up --build
