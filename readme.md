---

# 📝 Fórum API REST

API REST desenvolvida em **Java 21** com **Spring Boot 3.5.3** para um sistema de fórum onde usuários autenticados podem criar, atualizar, listar e deletar tópicos. Autenticação segura via JSON Web Token (JWT) garante acesso restrito à criação de conteúdos.

---

## 🚀 Tecnologias Utilizadas

* 💻 **Java 21**
* ⚙️ **Spring Boot 3.5.3**
* 🔒 **Spring Security** com **JWT** (biblioteca [auth0/java-jwt](https://github.com/auth0/java-jwt))
* 📚 **JPA / Hibernate** para persistência
* ✔️ **Bean Validation** com **Hibernate Validator** para validação dos dados
* 🐘 **PostgreSQL** como banco relacional
* 📖 **Swagger (OpenAPI)** para documentação interativa da API

---

## 🔥 Funcionalidades Principais

* 🔐 **Autenticação via Token JWT:**
  Usuários recebem token após login para acessar endpoints protegidos.
* 📝 **CRUD de Tópicos:**
  Criar, atualizar, listar e remover tópicos no fórum.
* 🚫 **Controle de Acesso:**
  Apenas usuários autenticados podem criar tópicos.
* ✅ **Validação automática:**
  Atributos dos objetos são validados para garantir consistência dos dados.
* 📑 **Documentação Swagger:**
  Teste e explore as rotas com uma interface amigável.

---

## ⚙️ Como Rodar o Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/LuisAugustoDev/Forum-Hub-Challenge.git
   ```

2. Configure o banco de dados PostgreSQL e ajuste o arquivo `application.properties` com suas credenciais:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Execute a aplicação na IDE de sua preferência.

4. Acesse a documentação Swagger na URL:

   ```
   http://localhost:8080/swagger-ui/index.html
   ```

---

## 🗂 Estrutura do Projeto

```
src/
 ├── main/
 │    ├── java/com/augusto/forumhub/
 │    │    ├── controller/      # Endpoints REST
 │    │    ├── dto/             # Objetos de transferência de dados
 │    │    ├── infra/           # Arquivos de segurança e exceções
 │    │    ├── model/           # Entidades JPA
 │    │    ├── repository/      # Repositórios para acesso ao banco
 │    │    ├── service/         # Lógica de negócio
 │    │    └── validacoes       # Validações das regras de negócio
 │    └── resources/
 │         └── application.properties
```

---

## 💡 Considerações

* Envie o token JWT no cabeçalho `Authorization` usando o formato:

  ```
  Authorization: Bearer <seu-token>
  ```
* Senhas são armazenadas de forma segura usando **BCrypt**.
* A validação automática impede o envio de dados inválidos.
* A API está preparada para ser ampliada e integrada facilmente.

---