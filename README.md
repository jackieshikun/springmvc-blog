# springmvc-blog

Using Thymeleaf, SpringMVC, SpringJPA, MySQL to develop a blog system. Users can create/edit/delete/comment blogs. Other than that, users could design theirs profile, such as changing username, avatar and password.

In addition, I introduces markdown to the blog system, which means users could use markdown grammer to edit their blogs.

To run the problem in local system, you need to install MySQL in your local system and create a database called "blogdb". Then, create a user whose name is "springmvc" and password is "123456" in MySQL and grant all privileges to user "springmvc" on database "blogdb". Besides, create a directory /static/img on your local system and put a image "catty.jpeg" to that directory to make sure avatar display. Above setting can be changed in src/main/resources/application.properties file.

The blog system can be viewed @ http://138.197.212.112:8080/. 
