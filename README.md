<h1 align="center">📋 Kanban API RESTful 📋</h1>

---

<h2 align="center">Descrição do Projeto</h2>

O objetivo do projeto é criar uma ferramenta similar ao quadro kanban, onde cada usuário que faz o login  
tem o seu próprio quadro e somente ele e o administrador podem mexer em suas tarefas. Porém, o administrador  
é quem cria as tarefas, aloca o funcionário, e o funcionário tem acesso mais restrito, sendo possível  
somente editar a tarefa, assim podendo colocar um status, descrição e título.

Esse projeto é uma API RESTful que tem como meta se conectar com o front-end, onde estará toda  
a parte visual dos quadros, e é por onde os pedidos HTTP são feitos e enviados para o código,  
verificando o banco e confirmando se o usuário tem acesso às informações.

---

<h2 align="center">Tecnologias Utilizadas</h2>

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

<h2 align="center">Como Usar</h2>

1. Baixe o Docker Desktop para Windows/Mac.  
2. Abra o terminal e navegue até a pasta do projeto:  
```bash
cd nome-do-projeto
```
3. Rode no terminal o seguinte comando para iniciar o proejto:
```bash
docker compose up -d
```
<h2 align="center">Comandos HTTP</h2>

<h3 align="center">Tipos de Status
CONCLUIDO

PENDENTE

PAUSADO

FAZENDO

<h3 align="center">Tipos de Role</h3>
COLABORADOR

ADM

<h3 align="center">Autenticação</h3>
POST /Login
Corpo (JSON):

{
  "email": "",
  "senha": ""
}

<h3 align="center">Comandos para cadastrar usuários - ADM</h3>
POST /adm/cadastroUsuario

{
  "email": "",
  "senha": "",
  "role": ""
}
PUT /adm/editarUsuario

PUT /adm/editarSenha

GET /adm/exibirTodosUsuario

GET /adm/exibirUsuario/{id}

DELETE /adm/excluirUsuario

<h3 align="center">ADM TAREFAS</h3>
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

<h3 align="center">Comandos Colaborador para editar tarefas</h3>
PUT /api/editarTarefa/{id}

GET /api/exibiTask/{id}
