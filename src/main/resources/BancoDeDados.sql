CREATE TABLE Usuarios (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE Categorias (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Projetos (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          nome VARCHAR(100) NOT NULL,
                          descricao TEXT,
                          usuario_id INT,
                          FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

CREATE TABLE Tarefas (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         titulo VARCHAR(100) NOT NULL,
                         descricao TEXT,
                         status VARCHAR(50),
                         projeto_id INT,
                         categoria_id INT,
                         FOREIGN KEY (projeto_id) REFERENCES Projetos(id),
                         FOREIGN KEY (categoria_id) REFERENCES Categorias(id)
);