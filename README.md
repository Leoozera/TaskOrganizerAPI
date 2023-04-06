# CursTop
Uma API para sistema de um curso online


## Endpoints
- Cadastro
    - [confirmar](#cadastro)
    - [Listar](#listarCadastro)
- Principal
    - professores
    - aulas
    - [tarefa](#)
    - [matéria](#matéria)
    - [listar matéria](#listarMateria)

---
### Cadastro

`POST` /CursTop/api/cadastro

**Campos da Requisição**

|campo | tipo | obrigatório |descrição |
|------|------|:-------------:|----------|
|nome|texto|sim|Primeiro nome do usuário|
|sobrenome|texto|sim|Sobrenome nome do usuário|
|email|texto|sim|E-mail do usuário|
|idade|int|não|Idade do usuário|
|cpf|int|sim|CPF do usuário|

**Exemplo de corpo de requisição**

```
{
    nome: "Pedro"
    sobrenome: "Vidal"
    email: "rm93567@fiap.com.br"
    idade: 18
    cpf: 405.914.580-71
}
```
**Respostas**

|código | descrição |
|-|-
|201 | cadastro concluido
|400 | campos invalidos
|400 | dados já registrados

### ListarCadastro
`GET` /CursTop/api/cadastro{id}

**Exemplo de corpo de resposta**

```
{
    "nome": "Pedro",
    "sobrenome": "Vidal",
    "email": "rm93567@fiap.com.br",
    "dtNascimento": "2004 06 04",
    "cpf": "405.914.580-71"
}
```

**Codigo de Respostas**

|código | nome |
|-|-
|201 | dados do cadastro retornados 
|404 | não existe esse cadastro

### Tarefa

`POST` /CursTop/api/tarefa

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|titulo | Texto | sim | Titulo da tarefa
|descricao | Texto | sim | Descrição da tarefa
|Materia | Materia | sim | Materia a qual a tarefa pertence

**Exemplo de corpo de requisição**

```
{
    "titulo": "Criar os End Points",
    "descricao": "Criar a documentação com os end points do projeto" ,
    "materia": "Java Spring "
}
```

**Respostas**

|código | descrição |
|-|-
|201 | cadastro da tarefa concluido
|400 | campos faltantes
|400 | dados já registrados


`GET` /CursTop/api/materia/tarefa{id}

**Exemplo de corpo de resposta**

```
{
    "titulo": "Documentação do Projeto",
    "Descricao":"Criar a documentação do projeto com base no que foi visto em aula, Criar a lista de endpoints, verbos e codigo de status "
}
```
**Codigo de Respostas**

|código | descrição |
|-|-
|201 | tarefa retornada 
|404 | não tarefa cadastrada



### Matéria

`POST` /CursTop/api/materia

**Campos da Requisição**

|campo | tipo | obrigatório |nome |
|------|------|:-------------:|----------|
|materia|texto|sim|Nome da materia|

**Exemplo de corpo de requisição**

```
{
    matéria: python
}
```
**Respostas**

|código | descrição |
|-|-
|201 | cadastro da materia concluido
|400 | campos faltantes
|400 | dados já registrados

### ListarMateria

`GET` /CursTop/api/materia/listarmateira{id}

**Exemplo de corpo de resposta**

```
{
    "nome": "Pyhton",
    "Tempo": "8",
    "Descricao":"Python é uma linguagem de programação de alto nível — ou High Level Language —, dinâmica, interpretada, modular, multiplataforma e orientada a objetos — uma forma específica de organizar softwares onde, a grosso modo, os procedimentos estão submetidos às classes, o que possibilita maior controle e estabilidade de códigos para projetos de grandes proporções."
}
```

**Codigo de Respostas**

|código | descrição |
|-|-
|201 | matérias relacionadas retornadas 
|404 | não existe matérias relacionadas 






