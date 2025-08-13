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

Quando for rodado o codigo, ele vai gerar automaticamente 5 usuarios normais e 1 usuario adm, o email e senha para acesso deles são:

adm@email.com
<br>colab1@email.com
<br>colab2@email.com
<br>colab3@email.com
<br>colab4@email.com
<br>colab5@email.com
<br>a senha para todos é "123456"

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
    
       docker-compose up --build


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

```json
{
  "titulo": "",
  "descricao": "",
  "status": "",
  "responsavel": "",
  "dataDeEntrega": ""
}
```

PUT /adm/transferirTarefa/{id} <- Aqui você coloca o ID da tarefa e no json o email para quem vai receber a tarefa
```json
{
    "email": ""
}
```

GET /adm/exibirTasks

GET /adm/exibirTask/{id}

Comandos Colaborador para editar tarefas

PUT /api/editarTarefa/{id}

GET /api/exibiTask/{id}
