# Spring-Boot Application with docker, mysql, elk(elastic,logstash,kibana)
> We will update soon

## Table of Contents
- [Build the image](#build-the-image)
- [Installation](#installation)
- [Uninstall](#uninstall)
- [FAQ](#faq)

## Build the image
```shell
$ docker volume create logs
$ docker-compose build --no-cache
```

## Installation
```shell
$ docker-compose up
```
- POST: "http://localhost:8087/api/users"
- Sample Payload: {"name":"Tapas Dey","country":"India"}

## Uninstall
```shell
$ docker-compose down
$ docker-compose rm
```

## FAQ
> Will update soon
