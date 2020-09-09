# Projeto Base
Criar toda a estrutura para o proejto base

###  **Roadmap:

Tech | Descrição | Situação | 
|-|-|-|
| RestFul | Criação de APIs REST | Concluído | 
| RestTemplate | Comunicação com APIs externas | Concluído | 
| Swagger | Adição de documentação de APIs | Concluído | 
| Circuit breaker | Adição do Circuit breaker | Concluído | 
| Retry pattern | Tentar novamente caso alguma chamada HTTP externa falhe | Concluído | 
| Banco embarcado | Adição do banco embarcado para os testes | Concluído | 
| Junit | Adição do modelo de testes unitários | Concluído | 
| Mockito | Adição do modelo de testes unitários | Concluído | 
| MockMvc | Adição do modelo de testes de integração | Concluído | 
| Docker | Adição do Docker | Não iniciado | 
| JSON Web Token | Adição de segurança nas APIs | Não iniciado |
| CI/CD | Criação das pipelines | Não iniciado | 
| Mensageria | Adição de comunicação por mensageria entre as APIs assincronas (RabbitMQ ou Kafka) | Não iniciado | 
| JSON Web Token | Adição de segurança nas APIs | Não iniciado | 
| Cloud | Preparação do ambiente de cloud | Não iniciado | 
| View | Adição da camada de View (Angular ou React) | Não iniciado | 
| Segurança | Adição de segurança na view | Não iniciado |
| Bando de dados NoSQL| Adição do banco de dados real | Não iniciado | 
| Bando de dados | Adição do banco de dados real | Não iniciado | 

```
```
Modelo
-------------------

Swagger:
```
http://localhost:8080//swagger-ui.html

```


Criar um personagem:

**POST http://localhost:8080/api/magic/personagem/** 

Body:
```
{
    "name": "Harry Potter",
    "role": "student",
    "school": "Hogwarts School of Witchcraft and Wizardry",
    "house": "5a05e2b252f721a3cf2ea33f",
    "patronus": "stag"
}
```

Alterar um personagem:

**PUT http://localhost:8080/api/magic/personagem/{id}**

Exemplo:
```
http://localhost:8080/api/magic/personagem/1
```
Body:
```
{
    "name": "Harry",
    "role": "student",
    "school": "Hogwarts School of Witchcraft and Wizardry",
    "house": "5a05e2b252f721a3cf2ea33f",
    "patronus": "stag"
}
```


Recuperar um personagem:

**GET http://localhost:8080/api/magic/personagem/{id}**

Exemplo:
```
http://localhost:8080/api/magic/personagem/1
```

Deletar um personagem:

**DELETE http://localhost:8080/api/magic/personagem/{id}**

Exemplo:
```
http://localhost:8080/api/magic/personagem/1
```

Listar personagens de acordo com os filtros:

**GET http://localhost:8080/api/magic/personagem/** 

Body - filtros possíveis:
```
{
    "id": 1,
    "name": "Harry Potter",
    "role": "student",
    "school": "Hogwarts School of Witchcraft and Wizardry",
    "house": "5a05e2b252f721a3cf2ea33f",
    "patronus": "stag"
}
```








