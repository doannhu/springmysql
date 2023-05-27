FROM eclipse-temurin:17-jdk-focal
 
WORKDIR /app
 
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# RUN ./mvnw dependency:go-offline
 
COPY src ./src

RUN ./mvnw package
 
CMD ["./mvnw", "spring-boot:run"]
#ENTRYPOINT ["java","-jar","springmysql-0.0.1-SNAPSHOT.jar"]