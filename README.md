# ibm-kafka-may-2023



### System Requirement 
- System with 8 GB 
- Hypervisor Support to test with docker 
- abount 50 GB free space 
- Operating System Mac / Windows / Linux
- Open internet access 

### Step 1 
> Download and install jdk 11 for your respective OS(Mac/Win/Linux) - https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html

### Step 2 
>  Download Kafka from - https://downloads.apache.org/kafka/3.2.3/kafka_2.12-3.2.3.tgz
> Extract with softwares like 7 zip / win zip etc 

* Note Windows Users: install wsl2 first -  https://docs.microsoft.com/en-us/windows/wsl/install
-  To install wsl 
    > wsl --install


### Step 3 
> Add Kafka to system path - kafka_2.13-3.1.0/bin 

### Additional Softwares 
> Docker - https://www.docker.com/products/docker-desktop/

> Eclipse JEE - https://www.eclipse.org/downloads/



# Introduction of cohort 

- Arun J - 9 year exp, data integration working as backend engg, integrating cloud services, in project will involve in kafka, have knowledge on kafka, knows at overview level, expecting practicle workflow and architecture 

- Bhaskara - 16 years exp,  working as test lead, how kafka works 

- Kranthi - 10 Year exp, working as tester, IBM Information center, currently using kafka in the project needs to gear up 

- Maria Sharon - 1.5 years exp, working as tester, interested in middleware testing, want to learn kafka 

- Puja agarwal - 6 year exp in testing, functional + automation testing, currently kakfa is used in the project, need to know the crux of the kafka 

- Pushpalata Sharma - 15 year exp, working with java and ibm products, and working as testers in the project kafka is used, but need to know who things work in kafka behind the screen 

- Sanjiv - 6.8 yrs exp, mdm project, kafka is used in inbound and outbound, understanding at arch level 

- Sarita - 12 year exp,  working as tester, need to understand kafka and messaging 

- Shubhi Agarwal - 7 yrs exp, with ibm 2 years, working as UI and API testing + performance testing, need to know how to integrate kafka in testing + generic to understand  

- Sonali - 8 yrs exp, in software testing, function and API testing, have known some ideas of kafka and currently being used. 

- Vishal - 10 yrs exp, working in middleware testing, worked on UFT, exploring KAFKA in next project coming 



## Notes

> Rest Template is used to create applications that consume RESTful Web Services.
> Json 

- producer-consumer problem 
- publisher always sends the message -subscriber always looks for the message(topic) and consumes
- ESB (Enterprise Service Bus)
    - Tibco
    - Mule Soft 
    - Open MQ 
    - IBM MQ 
    - Rabbit MQ
    - Kafka 
    .... 

- in kafka all the messages are immutable 
- kafka was tossed by a company called LinkedIn and given to open source community Apache (Tier 1)
- kafka is written in Scala - reactive in nature 

- no of services are growing day by day 



- in our arch 
    - if kafka is down then all service communication shall not happen 
    - we need to have backup approach of multiple clusters 
    - we need to employ a load balancer + registry 

- soln 
    - https://zookeeper.apache.org
    - zookeeper - ZooKeeper is a centralized service for maintaining configuration information, naming, providing distributed synchronization, and providing group services. 


## Commands 

(for windows users pls execute .bat files in windows folder)

- to start zookeeper 

>  zookeeper-server-start.sh ../config/zookeeper.properties 

- to start zookeeper (windows users)

>  zookeeper-server-start.bat ..\..\config\zookeeper.properties 

- to start kafka 

> kafka-server-start.sh ../config/server.properties 

- to list the topics 

> $ kafka-topics.sh --bootstrap-server localhost:9092 --list

- to create topic 
> $ kafka-topics.sh --bootstrap-server localhost:9092 --topic first-topic --create

> $ kafka-topics.sh --bootstrap-server localhost:9092 --topic second-topic --create

- to start producer 

> kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first-topic

- to start consumer 
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first-topic

- to start consumer from beginning 
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first-topic --from-beginning



- creating with 3 partitions 
> kafka-topics.sh --bootstrap-server localhost:9092 --topic topic-with-partition --create --partitions 3  

- creating with 3 partitions + 2 replication factor(which will not work as of now since we have single cluster) 
kafka-topics.sh --bootstrap-server localhost:9092 --topic topic-with-partition-repl --create --partitions 3 --replication-factor 2





# Day 2 

1. Creating partition 
2. Implementiation of kafka with partition + consumer groups 
    ```
    > It is a performance goal to have all the records sent to a single partition and not multiple partitions to improve batching. - sticky partition (by default after 3.2 kafka)
    > earlier to this was RoundRobin 
    ```
3. Rebalancing (shift the messages which we need)
4. connecting kafka with programming language (Java)
    - Eclipse 
5. to start kafka with kraft 
    - Kafka 2.x - Mandatory to have zookeeper 
    - Kafka 3.x - option to have zookeeper, you can have kraft but kraft is not production ready 
    - Kafka 4.x - will not support zookeeper 
6. the data when it is kept it follows murmur2 algoritham 
    - Utils.toPositive(Utils.murmur2(keyBytes)) % numPartitions;
    - at store and inflight also 
7. to consume public site kafka messages to our application (wiki)
8. delete topic 
    - to delete pls edit server.properties and add - delete.topic.enable=true
    - 



```
- optional 
    > copy the bin or bin/windows appropriate to your OS
    > put it in env variables 
```

## commands / practicles 


- staring zookeeper 
> zookeeper-server-start.sh /Volumes/Kanchan/Softwares/kafka/kafka-3.1.0/config/zookeeper.properties 

- starting kafka 
> kafka-server-start.sh /Volumes/Kanchan/Softwares/kafka/kafka-3.1.0/config/server.properties 

- list all the topics 
> kafka-topics.sh --bootstrap-server localhost:9092 --list

- to delete topics 
> kafka-topics.sh --bootstrap-server localhost:9092 --topic first-topic --delete

- to create topic with partition (by default 1)
> kafka-topics.sh --bootstrap-server localhost:9092 --topic topic-with-partition1 --create --partitions 3

- start producer 
> kafka-console-producer.sh --bootstrap-server localhost:9092 --topic topic-with-partition1

- start consumer (anonymous / without group)
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic-with-partition1

- create a consumer but it should be part of the group 
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic-with-partition1 --group first-application

- create a consumer but it should be part of the group (creating one more consumer part of the same group and messages are spread here)
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic-with-partition1 --group first-application

- create another group consumer from beginning 
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic-with-partition1 --group second-application --from-beginning 

- create another group consumer   (the data split between 3 consumer groups)
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic-with-partition1 --group second-application  

- create another group consumer   (the data split between 3 consumer groups)
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic-with-partition1 --group second-application 

- see how many paritions are there for the given topic 
> kafka-topics.sh --bootstrap-server localhost:9092 --topic topic-with-partition --describe


## trying to have the producer with round robin partitioner algorithm 



> kafka-console-producer.sh --bootstrap-server localhost:9092 --topic topic-with-partition1 --producer-property partitioner.class=org.apache.kafka.clients.producer.RoundRobinPartitioner 



# working with consumer groups 

- listing  all the consumer groups 
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list


- describe specific group 
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group first-application 


> Please Note: when the consumer is off then there shall be lag in the reading, when any grouped consumer comes then the left over messages are read implicityly 


## reset offsets 

- this will not work since --execute is missing 
> kafka-consumer-groups.sh  --bootstrap-server localhost:9092 --group first-application --reset-offsets --to-earliest 

- this will not work either you to have to give --all-topics or --topic 
> kafka-consumer-groups.sh  --bootstrap-server localhost:9092 --group first-application --reset-offsets --to-earliest --execute 

- will work and set the offset to earliest (0)
> kafka-consumer-groups.sh  --bootstrap-server localhost:9092 --group first-application --reset-offsets --to-earliest --execute --topic topic-with-partition1

- reset by shifting (go back by 5)
> $ kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group first-application --reset-offsets --shift-by -5 --execute --topic topic-with-partition1

```

Consumer group 'first-application' has no active members.

GROUP             TOPIC                 PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID     HOST            CLIENT-ID
first-application topic-with-partition1 0          13              18              5               -               -               -
first-application topic-with-partition1 1          15              20              5               -               -               -
first-application topic-with-partition1 2          15              20              5               -               -               -
```


- reset by shifting (go ahead by 2)
> $ kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group first-application --reset-offsets --shift-by 2 --execute --topic topic-with-partition1

```

Consumer group 'first-application' has no active members.

GROUP             TOPIC                 PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID     HOST            CLIENT-ID
first-application topic-with-partition1 0          15              18              3               -               -               -
first-application topic-with-partition1 1          17              20              3               -               -               -
first-application topic-with-partition1 2          17              20              3               -               -               -
```


# day 3 
1. work with kraft 
    - we are expecting 1000's of topics and clusters to be managed at the same time 
    - eventually is getting slower + getting registerd as zookeeper which is single point of failure 
    - 3.x - kraft is available but not production ready 
    - 4.x - zookeeper will not be there, only kraft this is expected by april 2024

    ```
        > kafka-storage.sh random-uuid
        (this will generage UUID)
        
        > kafka-storage format -t <UUID> -c ../config/kraft/server.properties 

        > kafka-server-start.sh ../config/kraft/server.properties 

        > kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first-topic
        
        > kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first-topic
 
    ```
2. work with public data available for kafka and process
    - https://codepen.io/Krinkle/pen/BwEKgW?editors=1010
    - https://esjewett.github.io/wm-eventsource-demo/
3. pull data from external source like DB and send it to kafka (selenium)
    - 3.1 setup database 
        - create a table and put some values 
        - we shall use H2 
        - java -jar h2.jar 

        ```
            create table myuser(
                userid int primary key, 
                username varchar(25) not null, 
                useremail varchar(50), 
                salary int
            );

            insert into myuser values(1, 'Arun', 'arun@arun.com', 1234); 
            insert into myuser values(2, 'Deepa', 'deepa@deepa.com', 2233); 
            insert into myuser values(3, 'Shubhi', 'shubhi@shubhi.com', 3322); 


        ```
    3.2 pull the data from java application with JDBC 
    3.3 with the data invoked, send it to selenium 
    3.4 integrate with kafka 

4. testing spring boot application with kafka 


## Sink and source 
> Connectors come in two flavors, source connectors and sink connectors. The connector that takes data from a Producer and feeds them into a topic is called source connector. The connector that takes data from a Topic and delivers them to a Consumer is called Sink Connector.












id = username 
id = login-submit







## spring boot + kafka works 

> https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.12&packaging=jar&jvmVersion=11&groupId=com.ibm&artifactId=spring-kafka&name=spring-kafka&description=Demo%20project%20to%20showcase%20spring%20boot%20with%20kafka%20&packageName=com.ibm.spring-kafka&dependencies=web,kafka

```
    GetMapping, PostMapping, Delete, PutMapping, PatchMapping
```





