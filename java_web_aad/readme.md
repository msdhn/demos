set env variable : </br>
AUTHORITY https://login.microsoftonline.com/  </br>
TENANT <TENANT>
CLIENT_ID <CLIENT_ID>
CLIENT_SECRET <CLIENT_SECRET>
OBJ_ID_GRP_1    <object id of group1>
OBJ_ID_GRP_2    <object id of group2>

mvn clean package </br>
mvn cargo:run -p cargo

then go to  http://localhost:8080/java_web_aad/
