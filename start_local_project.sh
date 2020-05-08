docker build --tag chess-game .

docker run -it -p 8080:8080 -d chess-game

bash health_check.sh