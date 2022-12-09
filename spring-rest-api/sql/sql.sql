CREATE TABLE users (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     username VARCHAR(50) NOT NULL, /*contraint unique*/
     password VARCHAR(100) NOT NULL 
     );

CREATE TABLE ordenes(
	id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	fecha_creacion DATE NOT NULL,
    socios_id INT(10) NOT NULL,
    estados_ordenes_id INT(10) NOT NULL,
    monto_total FLOAT NOT NULL,
    cupones_id INT(10) NULL DEFAULT NULL
    );
 
     
CREATE TABLE roles (
	 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	 role VARCHAR(50) NOT NULL
     );
	
/* Muchos a muchos*/
CREATE TABLE users_roles(
	users_id INT NOT NULL,
    roles_id INT NOT NULL,
    PRIMARY KEY(users_id, roles_id)
);
CREATE TABLE socios(
	id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	apellido VARCHAR(50) NOT NULL,
    nombre VARCHAR(60) NOT NULL,
    codigo VARCHAR(6) NOT NULL
    );
    
CREATE TABLE estados_ordenes(
	id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	descripcion VARCHAR(45) NOT NULL,
    descripcion_corta VARCHAR(45) NOT NULL,
    estado_final INT(10) NOT NULL
    );
    
CREATE TABLE cupones(
	id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
	codigo VARCHAR(10) NOT NULL,
    fecha_vigencia_dese DATE NOT NULL,
    fecha_vigencia_hasta DATE NULL DEFAULT NULL,
    descuento FLOAT NULL
    );
    
ALTER TABLE ordenes 
ADD CONSTRAINT FK_ORDENES_SOCIOS_socios_id
FOREIGN KEY (socios_id)
REFERENCES socios(id);
    
ALTER TABLE ordenes 
ADD CONSTRAINT FK_ORDENES_ESTADOS_ORDENES_estados_ordenes_id
FOREIGN KEY (estados_ordenes_id)
REFERENCES estados_ordenes(id);
        
ALTER TABLE ordenes 
ADD CONSTRAINT FK_ORDENES_CUPONES_cupones_id
FOREIGN KEY (cupones_id)
REFERENCES cupones(id);
    
    
/*CONSTRAINT unique */
    
ALTER TABLE socios
ADD CONSTRAINT UN_SOCIOS_codigo
UNIQUE(codigo);
    
ALTER TABLE cupones
ADD CONSTRAINT UN_CUPONES_codigo
UNIQUE(codigo);
    
     /*users
     roles
     user_roles
     */

ALTER TABLE users_roles 
ADD CONSTRAINT FK_USERS_users_id
FOREIGN KEY(users_id)
REFERENCES users(id);

ALTER TABLE users_roles
ADD CONSTRAINT FK_ROLES_roles_id
FOREIGN KEY(role_id)
REFERENCES roles(id);

ALTER TABLE users
ADD CONSTRAINT UN_USERS_username
UNIQUE(username);
    
ALTER TABLE roles
ADD CONSTRAINT UN_ROLES_role
UNIQUE(ROLE);

DESCRIBE roles;

INSERT INTO users(username,password) values('admin', 'admin');
INSERT INTO roles(role) values('ADMIN');
 
