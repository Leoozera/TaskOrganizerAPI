# CursTop
Uma API para sistema de um curso online


## Endpoints
- Cadastro
    - [confirmar](#cadastro)
    - [Listar](#listarcadastro)
- Principal
    - professores
    - aulas
    - turmas
    - matéria[]

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

### Listarcadastro
`GET` /CursTop/api/cadastro{id}

**Exemplo de corpo de resposta**

```
{
    nome: "Pedro"
    sobrenome: "Vidal"
    email: "rm93567@fiap.com.br"
    idade: 18
    cpf: 405.914.580-71
}
```

**Codigo de Respostas**

|código | descrição |
|-|-
|201 | dados do cadastro retornados 
|404 | não existe esse cadastro
