# SGATI - Sistema de Gestão de Acessos e Tarefas Integrado

## Visão Geral

SGATI é uma aplicação Spring Boot desenvolvida para gerenciamento de usuários, acessos e tarefas. O projeto segue as melhores práticas de arquitetura em camadas (Controller → Service → Repository) e utiliza H2 como banco de dados.

## 🚀 Tecnologias Utilizadas

- **Java 17 LTS** - Linguagem de programação
- **Spring Boot 3.5.10** - Framework web
- **Spring Security** - Autenticação e autorização
- **Spring Data JPA** - Persistência de dados
- **Hibernate** - ORM
- **H2 Database** - Banco de dados em arquivo
- **Lombok** - Redução de boilerplate
- **Maven** - Gerenciador de dependências
- **PostgreSQL Driver** - Suporte para banco em produção

## 📋 Pré-requisitos

- Java 17 ou superior instalado
- Maven 3.8.9 ou superior
- Git

## 🛠️ Instalação e Configuração

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/sgati.git
cd sgati
```

### 2. Configurar variáveis de ambiente (opcional)

```bash
# Linux/Mac
export JAVA_HOME=/caminho/para/java17
export PATH=$JAVA_HOME/bin:$PATH

# Windows PowerShell
$env:PATH = "C:\path\to\java17\bin;$env:PATH"
```

### 3. Construir o projeto

```bash
./mvnw clean install
```

### 4. Executar a aplicação

```bash
./mvnw spring-boot:run
```

A aplicação iniciará em `http://localhost:8080`

## 📚 API Endpoints

### Saúde da Aplicação

- **GET** `/api/health` - Verifica se a aplicação está rodando
- **GET** `/api/hello` - Mensagem de boas-vindas

### Gerenciamento de Usuários

- **GET** `/api/users` - Listar todos os usuários
- **GET** `/api/users/{id}` - Obter usuário por ID
- **GET** `/api/users/email/{email}` - Obter usuário por email
- **POST** `/api/users` - Criar novo usuário
- **PUT** `/api/users/{id}` - Atualizar usuário
- **DELETE** `/api/users/{id}` - Deletar usuário

### H2 Console (Desenvolvimento)

- **GET** `/h2-console` - Acessar o console do H2

## 📝 Exemplos de Requisições

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
    "name": "João Silva Atualizado",
    "password": "novaSenha123"
  }'
```

### Deletar Usuário

```bash
curl -X DELETE http://localhost:8080/api/users/1
```

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/Gabriel/sgati/
│   │   ├── SgatiApplication.java       # Classe principal
│   │   ├── controller/                 # Controladores REST
│   │   │   ├── HealthController.java
│   │   │   └── UserController.java
│   │   ├── service/                    # Lógica de negócio
│   │   │   └── UserService.java
│   │   ├── repository/                 # Acesso a dados
│   │   │   └── UserRepository.java
│   │   ├── model/                      # Entidades JPA
│   │   │   └── User.java
│   │   ├── dto/                        # Data Transfer Objects
│   │   │   ├── UserDTO.java
│   │   │   └── CreateUserRequest.java
│   │   ├── config/                     # Configurações
│   │   ├── security/                   # Segurança
│   │   └── audit/                      # Auditoria
│   └── resources/
│       └── application.yml             # Configurações da aplicação
└── test/
    └── java/com/Gabriel/sgati/
        └── SgatiApplicationTests.java
```

## 🗄️ Banco de Dados

### Configuração

A aplicação utiliza H2 com persistência em arquivo:

```yaml
spring:
  datasource:
    url: jdbc:h2:file:./data/sgati
    driver-class-name: org.h2.Driver
```

O banco de dados é criado automaticamente na primeira execução no diretório `./data/sgati.mv.db`.

## 🔐 Segurança

- Spring Security configurado para validação
- Suporte a diferentes roles (ADMIN, USER)
- Validação de email único
- Senhas armazenadas no banco

## 📦 Build e Deploy

### Gerar JAR executável

```bash
./mvnw clean package
```

O arquivo JAR será gerado em `target/sgati-0.0.1-SNAPSHOT.jar`

### Executar JAR

```bash
java -jar target/sgati-0.0.1-SNAPSHOT.jar
```

## 🧪 Testes

```bash
./mvnw test
```

## 📄 Licença

Este projeto é fornecido como é, para fins educacionais e de seleção.

## 👨‍💻 Autor

Gabriel Silva Sousa

## 📞 Contato

Email: seu-email@example.com

---

**Última atualização:** Fevereiro, 2026
