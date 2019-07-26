
**[How To Migrate Schema Using Flyway In MySQL With Database Created Via `createDatabaseIfNotExist`](https://github.com/AnghelLeonard/Hibernate-SpringBoot/tree/master/HibernateSpringBootFlywayMySQLQuick)**

**Note:** For production don't rely on `hibernate.ddl-auto` to create your schema. Remove (disable) `hibernate.ddl-auto` or set it to `validate` and rely on Flyway or Liquibase.

**Description:** This application is an example of migrating a MySQL schema when the database exists (is created before migration via MySQL specific, `createDatabaseIfNotExist=true`). In this example, the names of the table specified in `CREATE TABLE` queries are the same as the names of the entities, therefore, there is no need to use `@Table(name="...")`.

**Key points:**\
     - for Maven, in `pom.xml`, add the Flyway dependency\
     - remove (disable) `spring.jpa.hibernate.ddl-auto`\
     - in `application.properties`, set the JDBC URL as follows: `jdbc:mysql://localhost:3306/bookstoredb?createDatabaseIfNotExist=true`\
     - each SQL file containing the schema update add it in `classpath:db/migration`\
     - each SQL file name it as `V1.1__Description.sql`, `V1.2__Description.sql`, ...

-------------------------------

**You may like to try as well:**
<a href="https://leanpub.com/java-persistence-performance-illustrated-guide"><p align="center"><img src="https://github.com/AnghelLeonard/Hibernate-SpringBoot/blob/master/Java%20Persistence%20Performance%20Illustrated%20Guide.jpg" height="410" width="350"/></p></a>