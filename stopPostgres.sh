echo 'Parando banco JMSbd'
docker stop JMSbd
docker rm JMSbd
docker rmi -f jms/bd
