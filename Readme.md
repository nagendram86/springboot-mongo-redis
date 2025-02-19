# Spring boot + Mongodb + Redis (for Caching) Example
---

## Prerequisites:
1. pull mongo and redis-stack images from docker hub.

## Commands
1) docker network create mongonetwork
2) docker run --name mongodb-latest -p 27017:27017 --network mongonetwork -d mongo:latest
3) docker run --name redis-stack-latest -p 6379:6379 -p 8001:8001 --network mongonetwork -d redis/redis-stack:latest
4) docker build -t springboot-mongoredis:latest .
5) docker run --name springboot-mongoredis -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=docker" --network mongonetwork -d springboot-mongoredis

## How to use the demo?

1. Import the project and Run App class 
2. Use a browser to visit http://localhost:8080/api/users
3. Using one of the user's id, make another request (e.g, http://localhost:8080/api/users/{sample-id-from-mongodb})

