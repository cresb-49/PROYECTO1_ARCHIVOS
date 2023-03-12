CREATE DATABASE electronichomes;
\c electronichomes;
CREATE SCHEMA colaborador;
CREATE SCHEMA infraestructura;
CREATE SCHEMA mercancia;
CREATE SCHEMA comercio;
CREATE SCHEMA consumidor;

CREATE TABLE colaborador.rol(
    id INT NOT NULL,
    nombre VARCHAR(10) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE colaborador.empleado(
    nickname VARCHAR(20) NOT NULL,
    passw VARCHAR(200) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    rol INT NOT NULL,
    PRIMARY KEY(nickname),
    Foreign Key (rol) REFERENCES colaborador.rol(id)
);
CREATE TABLE infraestructura.sucursal(
    id VARCHAR(10) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE colaborador.planilla(
    empleado VARCHAR(20) NOT NULL,
    sucursal VARCHAR(10) NOT NULL,
    PRIMARY KEY(empleado),
    Foreign Key (empleado) REFERENCES colaborador.empleado (nickname),
    Foreign Key (sucursal) REFERENCES infraestructura.sucursal(id)
);
CREATE TABLE mercancia.producto(
    id VARCHAR(10) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE mercancia.stock(
    producto VARCHAR(10) NOT NULL,
    sucursal VARCHAR(10) NOT NULL,
    cantidad INT NOT NULL,
    Foreign Key (producto) REFERENCES mercancia.producto(id),
    Foreign Key (sucursal) REFERENCES infraestructura.sucursal(id)
);
CREATE TABLE mercancia.bodega(
    producto VARCHAR(10) NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY(producto),
    Foreign Key (producto) REFERENCES mercancia.producto(id)
);
CREATE TABLE consumidor.cliente(
    nit VARCHAR(20) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(nit)
);
CREATE TABLE comercio.venta(
    id VARCHAR(50) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    cliente VARCHAR(20) NOT NULL,
    empleado VARCHAR(20) NOT NULL,
    descuento DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(id),
    Foreign Key (empleado) REFERENCES colaborador.empleado(nickname),
    Foreign Key (cliente) REFERENCES consumidor.cliente(nit)
);
CREATE TABLE comercio.descripcion(
    producto VARCHAR(10) NOT NULL,
    venta VARCHAR(50) NOT NULL,
    cantidad INT NOT NULL,
    Foreign Key (producto) REFERENCES mercancia.producto (id),
    Foreign Key (venta) REFERENCES comercio.venta (id)
);

--Inserscion de roles del sistema
INSERT INTO colaborador.rol VALUES(1,'VENDEDOR');
INSERT INTO colaborador.rol VALUES(2,'INVENTARIO');
INSERT INTO colaborador.rol VALUES(3,'BODEGA');
INSERT INTO colaborador.rol VALUES(4,'ADMIN');

--Ingreso de la sucurlales de la empresa
INSERT INTO infraestructura.sucursal VALUES('S0001','Sucursal Central');
INSERT INTO infraestructura.sucursal VALUES('S0002','Sucursal Norte');
INSERT INTO infraestructura.sucursal VALUES('S0003','Sucursal Sur');

--Ingreso del cliente consumidor final
INSERT INTO consumidor.cliente VALUES('C/F','Consumidor Final');

--Administrador por defecto
INSERT INTO colaborador.empleado VALUES ('usuario17', 'a63f9709abc75bf8bd8f6e1ba9992573', 'Lucas Sánchez', 4);