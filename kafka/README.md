## Kafka example
- Needs to be basic example of producer and consumer 
- ideally dockerize kafka up and running



## Getting started with cli first and not using docker
- Let's first walk through a few basic examples using their shell scripts
- So first we'll need to install [kafka](https://kafka.apache.org/quickstart#quickstart_download)
- Once you download it - unzip and you should end up with a repo for kafka
- cd into that repo, under `bin` you should see a bunch of shell scripts
- There's 2 parts to running kafka
    - default config is assumed for now
    - [commands](https://docs.confluent.io/kafka/operations-tools/kafka-tools.html#search-by-tool-name)
    - one is the cluster itself, in the examples they use zookeeper
        - `bin/zookeeper-server-start.sh config/zookeeper.properties`
    - and then the next part is actually starting the kafka broker server
        - `bin/kafka-server-start.sh config/server.properties`

- once we have kafka up and running - we should be able to run these commands (assuming your in the kafka directory)
    - list topics: `bin/kafka-topics.sh --bootstrap-server localhost:9092 --list`
    - delete topic: `bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic <topic-name>`
    - to read and write events
        - open up 2 more terminals, we'll need one to
            - send the messages
            - view the messages incoming
        - in one terminal run `bin/kafka-console-producer.sh --topic <topic-name> --bootstrap-server localhost:9092`
            - this will prompt up a new line - each line is a message
        - then in the other terminal, run `bin/kafka-console-consumer.sh --topic <topic-name> --from-beginning --bootstrap-server localhost:9092`
            - this will be your terminal to read each message

## using docker to bring up kafka
- this just uses the image from `apache/kafka`, so pretty barebones
- there's alot that we can probably config, but we'll add those as we learn
- `docker-compose.yaml` -> `docker-compose up -d`


## Spring boot application layout
- Prereqs
    - need zookeeper started - this is needed for the kafka cluster
    - need the broker started
    - Otherwise - you're going to run into something like this `Bootstrap broker localhost:9092 (id: -1 rack: null) disconnected (org.apache.kafka.clients.NetworkClient)`
- domain
    - Sample `UserDomain` -> should represent whatever object we need
- endpoint
    - Endpoints for this api
        - we just have a health endpoint
        - and a post endpoint to post messages too
- service
    - `UserConsumer` -> service that consumers messages from a given topic
    - `UserProducer` -> service that produces messages to a given topic
    - In real life, we'll probably want to split these out in seperate services
- config
    - under the `src/main/resources/application.properties` -> this is the kafka config

## To run spring boot application
- `./gradlew clean build` -> builds app
- `./gradlew bootRun` -> run application