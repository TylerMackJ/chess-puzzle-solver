FROM maven:3.6-openjdk-11

WORKDIR /chess-puzzle-solver

COPY . .

CMD ["mvn", "spring-boot:run"]
