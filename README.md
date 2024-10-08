# Projeto Emi Chatbot
Descrição: O Emi é um Chatbot de Threat Intelligence que utiliza inteligência artificial para buscar e identificar domínios maliciosos, sites falsos e dados vazados de uma marca ou companhia. Nossa solução visa proteger a integridade e a reputação de empresas, oferecendo uma camada extra de segurança contra ameaças cibernéticas.

## Integrantes do grupo

- [Ezequiel Bispo de Jesus](https://github.com/EzequielBispo) - RM 99573 - Turma  2TDSPY

- [Helena Cristina](https://github.com/19helena) - RM 551873 - Turma  2TDSPY

- [Kelvin Gomes](https://github.com/kelving0mes) - RM 98126 - Turma  2TDSPN 

- [Leonardo Seiti](https://github.com/LeonardoSeiti) - RM 550207 - Turma  2TDSPN

## Responsáveis do projeto
Ezequiel Bispo de Jesus<br>
Leonardo Seiti de Souza

#Requisitos do sistema / System requirements

- [Maven ver. 3.8.X+](https://maven.apache.org/download.cgi)
- [Java JDK 17](https://www.oracle.com/br/java/technologies/downloads/#java17)
- IDE VSCode or InteliJ
- [Repositório](https://github.com/LeonardoSeiti/Sprint-DevOps.git)
- [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)
- [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

## Instruções / How To
O usuário para se cadastrar deve inserir:
- Email (Pessoal ou Corporativo)
- Senha
- Usuário
- Nome da empresa
- Departamento

Após inserir os dados, poderá ter acesso ao serviço de atendimento do Emi

## Link demonstração do deploy do projeto

[Youtube](https://youtu.be/gMACdKv88gc)

## Documentação do projeto usando swagger
[Docs](https://sprint-emi.azurewebsites.net/swagger-ui/index.html)

## EndPoints
`POST` /pesquisa <br>

```js
[
    {
  "id": 1,
  "indicador": "IP",
  "tipo": "malware"
    }
]
```

#### Códigos de Status
|código|descrição
|------|---------
| 200| Pesquisa salva
| 401| Argumento inválido  
| 404| Recurso não encontrado

`GET` /pesquisa <br>
#### Códigos de Status


```js
[
    {
  "id": 1,
  "indicador": "IP",
  "tipo": "malware"
    }
]
```

|código|descrição
|------|---------
| 200 | Pesquisa realizada com sucesso           
| 400 | Falta ou excesso de argumentos           
| 404 | Pesquisa não encontrada                  
| 500 | Erro interno no servidor                 
---

`PUT` {/id} <br>
#### Códigos de Status

```js
[
    {
  "id": 1,
  "indicador": "URL",
  "tipo": "malware"
    }
]
```

|código|descrição
|------|---------
| 200 | Dados atualizados com sucesso  |
| 404 | Conta não encontrada           |
| 400 | Dados de entrada inválidos     |
| 500 | Erro interno no servidor       |
---

`DELETE` {/id} <br>
#### Códigos de Status

|código|descrição
|------|---------
| 200 | Conta deletada com sucesso     |
| 204 | Conta deletada (sem conteúdo)  |
| 404 | Conta não encontrada           |
| 500 | Erro interno no servidor       |
---

