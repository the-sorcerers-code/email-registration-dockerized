# How to send emails in Java with microservices and Gmail

## Motivation

A few years ago, a representative from the Adventurer's Guild visited us to complain about the rise in paper costs. Since they used paper to write the details of everyone who registered as an adventurer, the increase in the cost of paper meant that they'd be losing some money. They tried to increase the percentage of loot they took from the adventurers when they returned from the dungeons, but this only led to some protests.

Left without a solution, they came to us to find out if we could use our magic to solve this crisis. Of course, since we could use magic to solve their problem for a small fee, we accepted this quest. We gave this quest to one of our young and bright sorcerers, and this repository contains the spells he used to complete the quest, and make the client happy.

## How to run the project

The backend of the project uses a microservices approach, so it's split into two different services which can be executed with docker-compose. The front-end of the project requires node js and npm / yarn to be installed.

### Requirements

1. Java
2. Docker
3. Node JS

### Notifications Service

This service is under the `notifications` folder, and it's a spring boot application which uses a MySQL database. To run it, do the following steps:

1. Create a copy of the `.env.example` file and rename it to `.env`
2. Edit the missing environment variables like mail username and password
3. Run `docker-compose up -d --build` command in the terminal / command prompt / powershell

### Adventurer Management Service

The service, just like the notifications service, is a spring boot application, under the `adventurer-management` folder, and in order to run it, the following steps need to be followed:

1. Copy the `.env.example` file, and rename the copy to `.env`
2. Change the database password, which is under the `MYSQLDB_PASSWORD` and `MYSQL_ROOT_PASSWORD` environment variables
3. Change the database name, which is under `MYSQL_DATABASE` environment variable
4. After changing the database configurations, run `docker-compose up -d --build` in the terminal / command prompt / powershell

### Front end

The front end of the application is a NextJS application which uses axios to perform Http requests to the `adventurer-management` service. To run it, open a terminal under the `front-end` folder and run the following commands:

1. `yarn install` if you use yarn or `npm install` if you prefer npm for package installations
2. After the installation process, then run `npm run dev`
