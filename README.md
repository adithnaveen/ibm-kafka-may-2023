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

