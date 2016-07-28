# Docker-Jenkins (2.11) - current - version 1.1.2
How to build your jenkins environment

## Build and Run (Jenkins Master)

* cd jenkins-master -> docker-compose up -d
* Enter the secretKey / install plugins / create a admin account
* CloudBees Docker Pipeline (Issue, needs to be installed manually)
* First run - docker exec -it <container> cat /var/jenkins_home/secrets/initialAdminPassword (copy and paste the generated password)

## Build and Run (Jenkins Slave)

* Create a new node from jenkins interface (give the name that is specified within docker-compose.yml
* Remote root directory - /var/jenkins_home
* Lunch method - Java Web Start
* Open your node and take the secretKey (copy it to the docker-compose.yml)
* cd jenkins-jnlp-agent -> docker-compose up -d
* (wait) Slave will be online

## Cleanup environment (from scratch)
* .\docker_cleanup.sh

## Test jobs
* docker-in-shell.groovy
* docker-inside.groovy
* sans-docker.groovy

* Jenkinsfile - pipeline definitions

----

## Configuration files
Files that you want to provision jenkins

* Stored configurations - /jenkins/files
* Installing plugins - plugins.txt (pluginID:version)
* Custom scripts - /scripts

----

## Version
* 1.0.0 - Initial commit (default jenkins with test plugins)
* 1.0.1 - Tested version for Ubuntu VM and Kitematic (Windows)
* 1.0.2 - dos2unix added for plugins install (need to convert the plugins txt file before any plugins are installed properly)
* 1.1.2 - Skipping initial setup of jenkins 2.x (credentials and default plugins) "ENV JAVA_OPTS="-Xmx8192m -Dhudson.Main.development=true -Djenkins.install.runSetupWizard=false""

----