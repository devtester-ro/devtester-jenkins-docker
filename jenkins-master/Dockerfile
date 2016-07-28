FROM jenkinsci/jenkins
MAINTAINER iulian.petcu@payu.ro

# Prep Jenkins Directories

USER root
RUN mkdir /var/log/jenkins
RUN mkdir /var/cache/jenkins
RUN chown -R jenkins:jenkins /var/log/jenkins
RUN chown -R jenkins:jenkins /var/cache/jenkins

# Install plugins and assign executors
COPY plugins.txt /usr/share/jenkins/plugins.txt
COPY scripts/ /usr/share/jenkins/ref/init.groovy.d/
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

# Custom stuff for jenkins master
RUN apt-get update \
      && apt-get install -y sudo \
      && apt-get install -y software-properties-common \
      && apt-get install -y apache2 \
      && apt-get install -y nano \
      && export DEBIAN_FRONTEND=noninteractive \
      && DEBIAN_FRONTEND=noninteractive sudo -E apt-get -q -y install mysql-server \
      && apt-get -y install php5 php-pear php5-mysql \
      && sudo service apache2 restart \
      && php --version \
      && curl -LOS https://phar.phpunit.de/phpunit-5.2.0.phar \
      && chmod +x phpunit-5.2.0.phar \
      && sudo mv phpunit-5.2.0.phar /usr/local/bin/phpunit \
      && phpunit --version
RUN echo "jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers

USER jenkins
#COPY root/credentials.xml /var/jenkins_home/
#COPY root/config.xml /var/jenkins_home/
# Set Defaults
ENV JAVA_OPTS="-Xmx8192m"
