docker build -t jeffersonfarias/trajeto-producer:latest  -f Dockerfile .
docker login --username=jeffersonfarias
docker push jeffersonfarias/trajeto-producer:latest
