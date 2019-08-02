
ECHO 'Iniciando banco Mdb'
docker build -t mdb/atividade ./postgres
docker run -p 5432:5433 --name mdb d mdb/atividade