# 📋 Kanban API RESTful 📋

---

## Descrição do Projeto

O objetivo do projeto é criar uma ferramenta similar ao quadro kanban, onde cada usuário que faz o login  
tem o seu próprio quadro e somente ele e o administrador podem mexer em suas tarefas. Porém, o administrador  
é quem cria as tarefas, aloca o funcionário, e o funcionário tem acesso mais restrito, sendo possível  
somente editar a tarefa, assim podendo colocar um status, descrição e título.

Esse projeto é uma API RESTful que tem como meta se conectar com o front-end, onde estará toda  
a parte visual dos quadros, e é por onde os pedidos HTTP são feitos e enviados para o código,  
verificando o banco e confirmando se o usuário tem acesso às informações.

---

## Tecnologias Utilizadas

- Java 21  
- Spring JPA  
- Spring Security  
- Validator  
- Spring Web  
- Spring Devtools  
- Java JWT  
- PostgreSQL  
- Docker + Docker Compose  

---

## Como Usar

1. Baixe o Docker Desktop para Windows/Mac.  
2. Abra o terminal e navegue até a pasta do projeto:  
    
        cd nome-do-projeto

3. Rode o comando para subir os containers:  
    
        docker compose up -d

---

## Comandos HTTP

---

### Tipos de Status

- CONCLUIDO  
- PENDENTE  
- PAUSADO  
- FAZENDO  

---

### Tipos de Role

- COLABORADOR  
- ADM  

---

### Autenticação

**POST /Login**  
Corpo (JSON):  
```json
{
  "email": "",
  "senha": ""
}
```
PUT /adm/editarUsuario

PUT /adm/editarSenha

GET /adm/exibirTodosUsuario

GET /adm/exibirUsuario/{id}

DELETE /adm/excluirUsuario

ADM TAREFAS
POST /adm/cadastroTarefa

{
  "titulo": "",
  "descricao": "",
  "status": "",
  "responsavel": "",
  "dataDeEntrega": ""
}

PUT /adm/transferirTarefa/{id}

GET /adm/exibirTasks

GET /adm/exibirTask/{id}

Comandos Colaborador para editar tarefas
PUT /api/editarTarefa/{id}

GET /api/exibiTask/{id}
