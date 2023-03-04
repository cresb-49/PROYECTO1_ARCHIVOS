CREATE DATABASE electronic-homes;

CREATE SCHEMA colaboradores;
CREATE SCHEMA infraestructura;
CREATE SCHEMA mercancia;
CREATE SCHEMA comercio;
CREATE SCHEMA consumidores;

CREATE TABLE colaboradores.rol(
    id INT NOT NULL,
    nombre VARCHAR(10) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE colaboradores.planilla(
    empleado VARCHAR(20) NOT NULL,
    sucursal VARCHAR(10) NOT NULL,
    PRIMARY KEY(empleado),
    Foreign Key (empleado) REFERENCES colaboradores.empleado (nickname),
    Foreign Key (sucursal) REFERENCES infraestructura.sucursal(id)
);

CREATE TABLE colaboradores.empleado(
    nickname VARCHAR(20) NOT NULL,
    passw VARCHAR(20) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    rol INT NOT NULL,
    PRIMARY KEY(nickname)
    Foreign Key (rol) REFERENCES colaboradores.rol(id),
);

CREATE TABLE infraestructura.sucursal(
    id VARCHAR(10) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE mercancia.producto(
    id VARCHAR(10) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    PRIMARY KEY(id),
);

CREATE TABLE mercancia.stock(
    producto VARCHAR(10) NOT NULL,
    sucursal VARCHAR(10) NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY(producto,sucursal),
    Foreign Key (producto) REFERENCES comercio.producto(id),
    Foreign Key (sucursal) REFERENCES infraestructura.sucursal(id)
);

CREATE TABLE mercancia.bodega(
    producto VARCHAR(10) NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY(producto),
    Foreign Key (producto) REFERENCES comercio.producto(id)
);

CREATE TABLE consumidores.cliente(
    nit VARCHAR(20) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(nit)
);

CREATE TABLE comercio.venta(
    id VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    cliente VARCHAR(20) NOT NULL,
    empleado VARCHAR(20) NOT NULL,
    descuento DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(id),
    Foreign Key (empleado) REFERENCES colaboradores.empleado(nickname),
    Foreign Key (cliente) REFERENCES consumidores.cliente(nit)
);

CREATE TABLE comercio.descripcion(
    producto VARCHAR(10) NOT NULL,
    venta VARCHAR(50) NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY(producto),
    Foreign Key (producto) REFERENCES mercancia.producto (id)
);