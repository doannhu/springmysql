
# Room booking for students

This app allows house owners manage their rooms and students view and pick rooms for renting.




## Main functions and tech stacks:

 - Using Java Spring Boot framework for the Rest API web app with Postgres database.
 - The app uses Maven build tool and runs on Docker containers (server and database).
 - The database is monitored by PgAdmin tool (also runs on Docker).
 - The owners can register, update, read and delete their own list of advertising rooms and the students can view all rooms and list of their rented room.
 - The owners and students is provided authentication and authorisation by Spring Security framework.
 - The payment is processed through Stripe API.
 - The data returned from database is processed through DTO and pagination.

