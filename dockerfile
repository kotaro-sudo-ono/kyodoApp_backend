FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . /app

RUN chmod +x ./mvnw

COPY .env .env

EXPOSE ${SERVER_PORT}

CMD ["./mvnw", "spring-boot:run"]
