CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE exposicion (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha_inauguracion DATE NOT NULL,
    fecha_clausura DATE NOT NULL
);

CREATE TABLE obra (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    estilo VARCHAR(50),
    precio_salida DECIMAL(10, 2) NOT NULL,
    imagen_url VARCHAR(255),
    artista_id INT REFERENCES usuario(id),
    propietario_id INT REFERENCES usuario(id),
    exposicion_id INT REFERENCES exposicion(id)
);

CREATE TABLE oferta (
    id SERIAL PRIMARY KEY,
    monto DECIMAL(10, 2) NOT NULL,
    fecha_oferta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id INT REFERENCES usuario(id),
    obra_id INT REFERENCES obra(id)
);

CREATE TABLE pago (
    id SERIAL PRIMARY KEY,
    monto DECIMAL(10, 2) NOT NULL,
    fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) NOT NULL,
    usuario_id INT REFERENCES usuario(id),
    obra_id INT REFERENCES obra(id)
);