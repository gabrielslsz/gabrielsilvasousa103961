# gabrielsilvasousa103961
Projeto para o Processo Seletivo SEPLAG/MT 2026 - Analista de TI (Sênior) - Opção: BACK-END
# SGATI - Sistema de Gestão de Acessos e Tarefas Integrado

## Visão Geral

SGATI é uma aplicação Spring Boot desenvolvida para gerenciamento de usuários. O projeto segue as melhores práticas de arquitetura em camadas (Controller → Service → Repository) e utiliza H2 como banco de dados.

## Tecnologias Utilizadas

- Java 17 LTS
- Spring Boot 3.5.10
- Spring Security
- Spring Data JPA
- Hibernate
- H2 Database
- Lombok
- Maven

## Pré-requisitos

- Java 17 ou superior
- Maven 3.8.9 ou superior
- Git

## Instalação e Configuração

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/sgati.git
cd sgati
```

### 2. Executar a aplicação

```bash
./mvnw spring-boot:run
```

A aplicação será iniciada em `http://localhost:8080`

## API Endpoints

### Health Check

- GET `/api/health` - Verificar status da aplicação
- GET `/api/hello` - Mensagem de teste

### Gerenciamento de Usuários

- GET `/api/users` - Listar todos os usuários
- GET `/api/users/{id}` - Obter usuário por ID
- GET `/api/users/email/{email}` - Obter usuário por email
- POST `/api/users` - Criar novo usuário
- PUT `/api/users/{id}` - Atualizar usuário
- DELETE `/api/users/{id}` - Deletar usuário

### Banco de Dados

- GET `/h2-console` - Acessar console H2

## Exemplos de Uso

### Criar Usuário

```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "email": "joao@example.com",
    "password": "senha123"
  }'
```

### Listar Usuários

```bash
curl http://localhost:8080/api/users
```

### Atualizar Usuário

```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "password": "novaSenha123"
  }'
```

### Deletar Usuário

```bash
curl -X DELETE http://localhost:8080/api/users/1
```

## Estrutura do Projeto

```
src/main/java/com/Gabriel/sgati/
├── SgatiApplication.java
├── controller/
│   ├── HealthController.java
│   └── UserController.java
├── service/
│   └── UserService.java
├── repository/
│   └── UserRepository.java
├── model/
│   └── User.java
├── dto/
│   ├── UserDTO.java
│   └── CreateUserRequest.java
├── config/
├── security/
└── audit/
```

## Banco de Dados

A aplicação utiliza H2 com persistência em arquivo:

```yaml
spring:
  datasource:
    url: jdbc:h2:file:./data/sgati
    driver-class-name: org.h2.Driver
```

O banco é criado automaticamente no diretório `./data/sgati.mv.db`.

## Build e Deploy

### Gerar JAR

```bash
./mvnw clean package
```

### Executar JAR

```bash
java -jar target/sgati-0.0.1-SNAPSHOT.jar
```

## Testes

```bash
./mvnw test
```

## Autor

Gabriel Silva Sousa
