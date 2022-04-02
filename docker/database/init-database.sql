-- create databases
CREATE DATABASE boaEntrega;
CREATE DATABASE boaEntregaSupport;

----create root user and grant rights
GRANT ALL PRIVILEGES ON DATABASE "boaEntrega" to root;
GRANT ALL PRIVILEGES ON DATABASE "boaEntregaSupport" to root;