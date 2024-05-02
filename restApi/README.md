## Warning
- the following code isn't meant to be production ready - just for learning
- use at own risk

### REST API
- Split into few different directories
    - dao -> Data Access Object
        - `UserDao.java` -> interface for user dao methods
        - `UserDaoImpl.java` -> implementation for interface
        - `UserRowMapper.java` -> Row mapper to map rows to java object
    - domain
        - `User.java` -> should be all the columns we want from the database
    - exceptions
        - `GetResponseModel.java` -> response model for GET calls
        - `GetResponseModelPaginated.java` -> paginated response for GET
        - `UpdateResponseMOdel.java` -> response model for PATCH, PUT, DELETE calls
    - service
        - `UserService.java` -> service that's called from the endpoint, and then calls the `UserDaoImpl.java`
- To run...
    - `./gradlew clean build` -> removes previous build dir and builds again
    - `./gradlew bootRun` -> runs spring boot application

### PSQL Docker
- `docker-compose.yaml` -> brings up a local psql instance running on port 5431
    - `docker-compose up -d`
