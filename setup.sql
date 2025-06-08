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
    jmbg BIGINT,
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
