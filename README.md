# tasktwo:

This is a Spring Boot service with below APIs:

> GET /tasktwo/relations
>
> Example Request:
> curl 'http://ec2-44-193-82-27.compute-1.amazonaws.com:8080/tasktwo/relations'
>
> Example Response:
> {"id":1,"parentId":0,"name":"Warrior","color":"red"}
>
> POST /tasktwo/relations
>
> Example Request:
> curl --location --request POST 'http://ec2-44-193-82-27.compute-1.amazonaws.com:8080/tasktwo/relations' --header 'Content-Type: application/json' --data-raw '{ "parentId" : 0, "name" : "Warrior", "color" : "red" }'
>
> Example Response:
> {"id":1,"parentId":0,"name":"Warrior","color":"red"}

Note:
1. For more information related to APIs access http://ec2-44-193-82-27.compute-1.amazonaws.com:8080/tasktwo/swagger-ui.html
2. H2 db Console can be accessed at http://ec2-44-193-82-27.compute-1.amazonaws.com:8080/tasktwo/h2-console/

Relation Table in H2 database:

![Relation](https://github.com/vamsivegesna/tasktwo/blob/main/src/main/resources/static/RelationTable.png)