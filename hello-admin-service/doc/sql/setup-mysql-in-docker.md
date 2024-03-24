# Setup MySql

## Docker CLI

### Solve a problem

`mysqld: Can't read dir of '/etc/mysql/conf.d/' (Errcode: 2 - No such file or directory)`.

```bash
docker run -dit --name tempMysql57 -p 3306:3306 -e MYSQL_ROOT_PASSWORD='123456' mysql:5.7
docker cp tempMysql57:/etc/mysql/conf.d D:\\MyData\\DockerVolumes\\hello-admin-mysql57\\conf
docker cp tempMysql57:/etc/mysql/mysql.conf.d D:\\MyData\\DockerVolumes\\hello-admin-mysql57\\conf
docker rm -fv tempMysql57
```

### Create and run a new container

```bash
docker run -dit \
--name hello-admin-mysql57 \
-p 33061:3306 -e MYSQL_ROOT_PASSWORD='123456' \
-v D:\\MyData\\DockerVolumes\\hello-admin-mysql57\\data:/var/lib/mysql \
-v D:\\MyData\\DockerVolumes\\hello-admin-mysql57\\conf:/etc/mysql \
mysql:5.7
```

### Connect to the MySql server

```bash
docker exec -it hello-admin-mysql57 bash
mysql -u root -p
```

## MySql CLI

### Create a new database

```mysql
SHOW DATABASES;
-- DROP DATABASE IF EXISTS hello_admin;
CREATE DATABASE hello_admin CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE hello_admin;
```
