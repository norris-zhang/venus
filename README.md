# venus

## env
- PostgreSQL 9.6.2 or newer
- Maven 3.3.1 or newer

## Database setup
Install PostgreSQL database.

> #### MacOs
Use homebrew. See also [Homebrew Documentation](https://brew.sh/)

> #### Windows
Download installer from [PostgreSQL](https://www.postgresql.org/download/)

> #### Linux
Use package management tools like apt on Ubuntu or yum on CentOS. See also [PostgreSQL](https://www.postgresql.org/download/linux/ubuntu/)

After installing PostgreSQL database, you may need to start database server.
On MacOS you do:  
$ brew services list  
$ brew services start postgresql

Create a user and a database  
$ psql postgres  
postgres=# create user venus with password ‘123321’;  
postgres=# create database venusdb owner venus;  
postgres=# \q

Please stick to the username (venus), password (123321) and database name (venusdb). When the program starts, it will automatically create tables, insert initial data into database venus using venus/123321. If you do need to change them, you can find the configuration in  
parent/web/src/main/resources/application.properties

## Install JDK
Download JDK 8 or newer, the newest update. [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)  
Install JDK, then setup JAVA_HOME, CLASSPATH and PATH environment variables.
> #### [MacOS](http://stackoverflow.com/questions/24342886/how-to-install-java-8-on-mac)
> #### [Windows](https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html)
> #### [Ubuntu](http://www.wikihow.com/Install-Oracle-Java-JDK-on-Ubuntu-Linux)

## Install Maven
See [Maven](https://maven.apache.org/)

## Install Git
See [Git-SCM](https://git-scm.com/)

## Clone repository
Generate SSH key pair and put private key in ~ home directory, then public key onto [GitHub Settings](https://github.com/settings/keys).  
See [GitHub SSH guide](https://help.github.com/articles/connecting-to-github-with-ssh/)  
Start a terminal. On windows, Git Bash is recommended.
> $ cd <your work directory>  
$ git clone git@github.com:norris-zhang/venus.git

## Compile projects
$ cd parent/
$ mvn clean install

## Start project
$ cd parent/web  
$ mvn spring-boot:run

## Eclipse imports projects
