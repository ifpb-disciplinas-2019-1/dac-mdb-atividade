
ECHO 'Parando banco mdb'
docker stop mdb
docker rm mdb
docker rmi -f mdb