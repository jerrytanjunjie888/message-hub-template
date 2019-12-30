# Message Hub Template Module

This module is used to select template, templates are divided into SMS, Email and Wechat. 

## Architecture

[click this](https://docs.google.com/presentation/d/1gHSOl33SVmchPIy6YesP9oEAcMZy2OVsWFT_TgGupmM/edit?usp=sharing)

<!-- ## Prerequisities
***
* -->

### Built with

* [Java](https://spring.io/projects/spring-boot) Programming Language

#### Launch

To successfully launch this module, you need to do this:

* Set a path on your local computer to save the log files. Example:  ``/data/messaghub/template/``

```     
server:
    port: 3006
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgres
    driver-class-name: org.postgresql.Driver
    username: postgres
    password: 123456

```

* Make sure you map your local log path to the log path in the docker container.
Do this in your ``docker-compose`` file:

```
volumes:
    - /YOUR_LOCAL_LOG_PATH/:/tmp/
```

Run the following commands to launch application


**Run with Docker**

Run ``up.sh`` to start up and ``down.sh`` to shutdown
```
$ up.sh
```
```
$ down.sh
```

## Test
Check out the **TemplateTest.rest** file in the /test folder.
You can copy the examples in there and run using curl or Postman.

Ont the other hand, you can directly test with our [preproduction](https://api-portal.preprod.subsidia.org/#!/apis/8b2fb3af-7c9a-4270-afb3-af7c9ab2703f/pages/f3863dc8-8758-4a6f-863d-c887583a6fcf) environment on Api-Portal

## Roadmap

#### Upcoming

###### Q1 2020

**V2:**

###### Q2 2020

###### Q3 2020

###### Q4 2020

#### Changelog


## Support
For all suggestions, bug reports and feature requests please feel free
to raise an **issue** or check out this [Support document](https://docs.google.com/document/d/1wOpphMC9qt3U6IvbSlUmu68AGelhLQhE9XxhigyB0iY/edit?usp=sharing).

  