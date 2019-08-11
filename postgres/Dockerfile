FROM postgres
ENV POSTGRES_DB dac_jms
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres
COPY create.sql /docker-entrypoint-initdb.d/
COPY insert.sql /docker-entrypoint-initdb.d/
