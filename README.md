# BugTracker
This application will manage Bug System. THis has end points to create/update/delete/Read all bug details. 
It uses In memory H2 database.
It stores all data in bugTracker table. Which has bugId as unique autogenerated ID.
REfer Postman collection to use all end points.
Docker File is attatched so please follow below steps to run app.
go to folder where projected is downloaded 
Mvn clean install
 to create docker image with tags run command-> docker build . t freenow/carmanagement
docker image will be built
you can see this image by- docker images
 push docker image to dockerhub-optional
To run project through image- docker run -p 8082:8082 freenow/carmanagement
You can use postman collection to test APi's
