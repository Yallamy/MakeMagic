# MakeMagic
Desafio Dextra

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








