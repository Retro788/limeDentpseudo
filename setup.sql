CREATE DATABASE IF NOT EXISTS limedent;
USE limedent;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    ime VARCHAR(100),
    prezime VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(30),
    profilePhoto LONGBLOB
);

CREATE TABLE IF NOT EXISTS patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    imePrezime VARCHAR(150),
    mail VARCHAR(150),
    phone VARCHAR(30),
    oib BIGINT,
    curp VARCHAR(18),
    patientAddress VARCHAR(255),
    patientCity VARCHAR(100),
    patientMedicalHistory TEXT,
    patientAlergies TEXT,
    profilePhoto LONGBLOB
);

CREATE TABLE IF NOT EXISTS medicalexam (
    id INT AUTO_INCREMENT PRIMARY KEY,
    info TEXT,
    idDoctor INT,
    idPatient INT,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (idDoctor) REFERENCES users(id),
    FOREIGN KEY (idPatient) REFERENCES patients(id)
);

CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productCode INT,
    productTitle VARCHAR(200),
    productPrice DECIMAL(10,2)
);

CREATE TABLE IF NOT EXISTS offers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200),
    authorID INT,
    patientName VARCHAR(200),
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    url VARCHAR(255),
    FOREIGN KEY (authorID) REFERENCES users(id)
);

-- Datos de ejemplo para iniciar el sistema
INSERT INTO users (username, password, ime, prezime, email, phone) VALUES
('admin', '0123456789abcdef0123456789abcdef7085c63043cdaba6840eec3928d8c8bd403d4075d7c3e4b27829710059411132',
 'Admin', 'General', 'admin@example.com', '5551112222');

INSERT INTO patients (imePrezime, mail, phone, oib, curp, patientAddress, patientCity, patientMedicalHistory, patientAlergies) VALUES
('Juan Pérez', 'juan.perez@example.com', '555123456', 87654321, 'PEPJ800101HVZRRL09', 'Calle Mayor 123', 'Madrid', 'Sin antecedentes', 'Ninguna'),
('María López', 'maria.lopez@example.com', '555987654', 87654322, 'LOPM850202MDFRRS05', 'Gran Vía 10', 'Barcelona', 'Alergia a penicilina', 'Penicilina');

INSERT INTO products (productCode, productTitle, productPrice) VALUES
(1, 'Limpieza dental', 50.00),
(2, 'Blanqueamiento', 120.00);

INSERT INTO offers (title, authorID, patientName, url) VALUES
('Oferta inicial', 1, 'Juan Pérez', 'http://example.com/oferta1.pdf');

INSERT INTO medicalexam (info, idDoctor, idPatient) VALUES
('Consulta inicial', 1, 1);
