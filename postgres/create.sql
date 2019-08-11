--CRIANDO A TABELA CLIENTE
CREATE TABLE public.cliente
(
  id integer NOT NULL,
  cpf character varying(255),
  email character varying(255),
  nome character varying(255),
  CONSTRAINT cliente_pkey PRIMARY KEY (id)
)
