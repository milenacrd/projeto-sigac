
# Sistema de Gestão Admninistrativa Condominial 
 
Este projeto é uma aplicação backend desenvolvida com **Java Spring Boot**, com o objetivo de auxiliar na gestão administrativa de condomínios, centralizando informações e automatizando processos comuns do dia a dia.

---

## 🎯 Problema

A administração condominial frequentemente enfrenta desafios como:

* Controle descentralizado de moradores
* Falta de padronização nos dados
* Processos manuais e suscetíveis a erros
* Dificuldade na organização de informações administrativas

---

## 💡 Solução Proposta

O sistema propõe uma API REST capaz de:

* Gerenciar usuários (moradores, administradores, etc.)
* Centralizar dados administrativos
* Servir como base para expansão (financeiro, comunicados, reservas, etc.)

---

## 🚧 Status do Projeto

Atualmente o projeto está em fase inicial de desenvolvimento.

### ✅ Funcionalidades implementadas:

* CRUD completo de usuários
* Arquitetura em camadas:
  * Model
  * Repository
  * Service
  * Controller
* Integração com banco de dados MySQL
* Testes básicos da entidade de usuário

### 🔜 Próximos passos:

* Implementação de autenticação (Spring Security / JWT)
* Módulo financeiro
* Gestão de unidades/apartamentos
* Sistema de comunicados

---

## 🛠️ Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* JUnit (testes)

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos:

* Java instalado
* MySQL rodando
* Maven

### Passos:

1. Clone o repositório:

```
git clone https://github.com/milenacr/projeto-sigac
```

2. Configure o banco de dados no `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. Execute o projeto:

```
mvn spring-boot:run
```

---

## 📌 Endpoints (Usuário)

Exemplo de endpoints disponíveis:

* `GET /usuarios` → listar usuários
* `GET /usuarios/{id}` → buscar por ID
* `POST /usuarios` → criar usuário
* `PUT /usuarios/{id}` → atualizar
* `DELETE /usuarios/{id}` → deletar

---

## 👥 Autores

* Milena Cardoso
* Luca Moreira

---

## 📚 Observações

Este repositório foi criado com fins de estudo e prática em desenvolvimento backend com Spring Boot.

Embora o tema tenha origem em um trabalho acadêmico, esta implementação está sendo desenvolvida de forma independente para aprofundamento técnico, organização de código e boas práticas.

---

## 🧠 Aprendizados

* Estruturação de APIs REST
* Arquitetura em camadas
* Integração com banco relacional
* Versionamento com Git
* Boas práticas com Spring Boot

---
