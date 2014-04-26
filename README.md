ejb3study
=========

Repository for EJB 3.1 study

To run this EJB sample:

1. Go to root folder (ejb3study): mvn clean install
2. Deploy /ejb3study/ejb3study-ear/target/ejb3study-ear-0.0.1-SNAPSHOT.ear into JBoss
3. Open Postman and send request
   - URL: http://127.0.0.1:8080/ejb3study/services/request
   - TYPE: POST
4. Check the result