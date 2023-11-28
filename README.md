Instalación de la base de datos

Para instalar la base de datos, seguir los siguientes pasos:

    Descargar la imagen de Docker de PostgreSQL 16:

docker pull postgres:16

    Crear una instancia Docker con PostgreSQL 16:

docker run --name pg-todoapp -e POSTGRES_PASSWORD=pg123456 -p 15432:5432 -d postgres:16

    Acceder a la base de datos por defecto del contenedor creado anteriormente:

docker exec -it <CONTAINER ID> psql -U postgres

    Ejecutar el script init.sql del directorio 'database'.
