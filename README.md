
# Room booking for students

:house_with_garden: This app allows house owners manage their rooms and students view and pick rooms for renting.




## Main functions and tech stacks:

 - :link: Using Java Spring Boot framework for the Rest API web app with Postgres database.
 - :package: The app uses Maven build tool and runs on Docker containers (server and database).
 - :mag_right: The database is monitored by PgAdmin tool (also runs on Docker).
 - :office_worker: The owners can register, update, read and delete their own list of advertising rooms and the students can view all rooms and list of their rented room.
 - :scientist: The owners and students is provided authentication and authorisation by Spring Security framework.
 - :credit_card: The payment is processed through Stripe API.
 - :hamburger: The data returned from database is processed through DTO and pagination.

