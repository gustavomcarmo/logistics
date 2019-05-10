# Logistics

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![Build status](https://travis-ci.org/esign-consulting/logistics.svg?branch=master)](https://travis-ci.org/esign-consulting/logistics) [![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=br.com.esign%3Alogistics&metric=alert_status)](https://sonarcloud.io/dashboard/index/br.com.esign:logistics) [![Docker Pulls](https://img.shields.io/docker/pulls/esignbr/logistics.svg)](https://hub.docker.com/r/esignbr/logistics) [![Demo Application](https://img.shields.io/website-up-down-green-red/http/www.esign.com.br/logistics.svg?label=demo)](http://www.esign.com.br/logistics)

The goal of the Logistcs application is find out the best route between two places within a map. Once created, add routes to the map, as following:

Origin | Destination | Distance (Km)
------ | ----------- | -------------
A | B | 10
B | D | 15
A | C | 20
C | D | 30
B | E | 50
D | E | 30

The best route is the cheapest one, considering the truck autonomy (Km/l) and the fuel price (l). Based on the routes above, if the truck has to go from **place A** to **place D**, its autonomy is **10 Km/l** and the litre of the fuel cost **$2.50**, the best route will be **A -> B -> D**, because it's the cheapest one: **$6.25**.

## Quality Assurance

The Logistics application has quality in its core. Beyond unit tests, the following projects were developed in order to validate the whole solution:

Project | Test type | Build status
------- | --------- | ------------
[logistics-test-arquillian](https://github.com/esign-consulting/logistics-test-arquillian) | Integration test | [![Build status](https://travis-ci.org/esign-consulting/logistics-test-arquillian.svg?branch=master)](https://travis-ci.org/esign-consulting/logistics-test-arquillian)
[logistics-test-restassured](https://github.com/esign-consulting/logistics-test-restassured) | API test | [![Build status](https://travis-ci.org/esign-consulting/logistics-test-restassured.svg?branch=master)](https://travis-ci.org/esign-consulting/logistics-test-restassured)
[logistics-test-selenium](https://github.com/esign-consulting/logistics-test-selenium) | UI test | [![Build status](https://travis-ci.org/esign-consulting/logistics-test-selenium.svg?branch=master)](https://travis-ci.org/esign-consulting/logistics-test-selenium)
[logistics-test-jmeter](https://github.com/esign-consulting/logistics-test-jmeter) | Load test | [![Build status](https://travis-ci.org/esign-consulting/logistics-test-jmeter.svg?branch=master)](https://travis-ci.org/esign-consulting/logistics-test-jmeter)

![Logistics' tests](http://www.esign.com.br/logistics-tests.png)

## The CI/CD Pipeline

Each push to this repository triggers the pipeline below:

1. Travis CI clones this GitHub repository;
2. After compiling and performing several unit tests in the application source code, Maven triggers the SonarQube static code analisys, and the results are sent to [SonarCloud](https://sonarcloud.io);
3. Once generated the Java artifacts, they are deployed to [Sonatype OSSRH](https://oss.sonatype.org), a Nexus Repository Manager instance Sonatype uses to provide repository hosting service to open source projects binaries;
4. After building the Logistics Docker image, it is pushed to [Docker Hub](https://hub.docker.com);
5. The application EAR file is deployed in a Wildfly instance avaliable at [esign.com.br](http://www.esign.com.br). From there, the Logistics application connects to a MongoDB instance maintained by [mLab](https://mlab.com);
6. Several tests are triggered asynchronously. Each one is performed against the Wildfly instance where the latest version of application was deployed.

![Logistics' pipeline](http://www.esign.com.br/logistics-pipeline.png)

## Running with Docker

You can run the application as a [Docker](https://www.docker.com) container. Install [Docker](https://docs.docker.com/install) and then run:

`docker run --name logistics -p 8080:8080 -e MONGODB_URI=mongodb://username:password@host:port/logistics -d esignbr/logistics`

The environment variable **MONGODB_URI** is mandatory and must set the [MongoDB connection URI](https://docs.mongodb.com/manual/reference/connection-string). Remember to replace *username* and *password* with your MongoDB credentials as well as *host* and *port* with the appropriate values, according with where your MongoDB instance is avaliable on.

The Logistics application can also be executed along with MongoDB by using [Docker Compose](https://docs.docker.com/compose). If you've already installed [Docker](https://docs.docker.com/install) and [Docker Compose](https://docs.docker.com/compose/install), clone the repository and then run:

`docker-compose up -d`

The application will be available through the URL <http://localhost:8080/logistics> in your browser.

## Deploying to a local VM

Alternatively, you can deploy both the application and the database to a local VM, by using the [Ansible playbook](playbook.yml). If you want to know how it works, first install [Ansible](https://www.ansible.com), [VirtualBox](https://www.virtualbox.org) and [Vagrant](https://www.vagrantup.com), and then run:

`vagrant up`

Vagrant will download the [codeyourinfra](https://app.vagrantup.com/codeyourinfra)/[docker](https://app.vagrantup.com/codeyourinfra/boxes/docker) [Vagrant box](https://www.vagrantup.com/docs/boxes.html) (if it was not done yet), then will bootstrap the local VM and at the end will trigger the Ansible playbook execution.

Once the local VM is up, open the URL <http://192.168.33.10:8080/logistics> in your browser.

## Deploying to AWS

TO DO
