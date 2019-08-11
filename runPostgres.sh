
echo 'Iniciando banco JMSbd'
docker build -t jms/bd ./postgres
docker run -p 5433:5432 --name JMSbd -d jms/bd
