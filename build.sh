mvn package

docker build -t product-service -f ./product-service/Dockerfile .

docker build -t user-service -f  ./user-service/Dockerfile .

docker build -t discovery-service -f  ./discovery-service/Dockerfile .

docker build -t gateway-service -f  ./gateway-service/Dockerfile .

docker build -t config-service -f  ./config-service/Dockerfile .

docker build -t rabbitmq-producer-consumer -f  ./rabbitmq-producer-consumer/Dockerfile .