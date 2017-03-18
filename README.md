# venus

### Database setup
Install PostgreSQL database.

$ psql postgres  
postgres=# create user venus with password ‘123321’;  
postgres=# create database venusdb owner venus;  
postgres=# \q

### start project
$ cd parent/web  
$ mvn spring-boot:run
