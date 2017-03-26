# venus

### Database setup
Install PostgreSQL database.

$ psql postgres  
postgres=# create user venus with password ‘123321’;  
postgres=# create database venusdb owner venus;  
postgres=# \q

### env
- PostgreSQL 9.6.2 or newer
- Maven 3.3.1 or newer

### compilation
$ cd parent/
$ mvn clean install

### start project
$ cd parent/web  
$ mvn spring-boot:run

### Eclipse imports projects
