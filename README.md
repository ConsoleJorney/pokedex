# Pokédex

Projeto Full Stack de uma Pokédex desenvolvido para estudo de desenvolvimento web.

A aplicação permite buscar Pokémon através da PokeAPI, exibindo informações como imagem, tipo, descrição, habilidades e status. Os dados pesquisados também são armazenados em um banco de dados MySQL.

## Tecnologias utilizadas

### Frontend
- HTML5
- CSS3
- JavaScript

### Backend
- Java
- Javalin
- Maven
- Jackson
- PokeAPI

### Banco de dados
- MySQL

## Funcionalidades

- Buscar Pokémon pelo nome
- Exibir imagem do Pokémon
- Mostrar número da Pokédex
- Exibir tipo
- Mostrar altura e peso
- Exibir descrição
- Mostrar habilidades
- Mostrar status:
  - HP
  - Ataque
  - Defesa
  - Ataque Especial
  - Defesa Especial
  - Velocidade
- Salvar Pokémon pesquisados no banco de dados

## Estrutura do projeto

```
pokedex/
│
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── script.js
│
├── backend/
│   └── Projeto Java com Javalin
│
└── database/
    └── pokedex.sql
```

## Como executar

### Banco de dados

1. Abra o XAMPP e inicie o MySQL.
2. Acesse o phpMyAdmin.
3. Importe o arquivo:

```
database/pokedex.sql
```

### Backend

1. Abra a pasta `backend`.
2. Execute o projeto Java.
3. O servidor será iniciado em:

```
http://localhost:7000
```

### Frontend

Abra o arquivo:

```
frontend/index.html
```

no navegador.

## API utilizada

Este projeto utiliza a:

PokeAPI

https://pokeapi.co/

## Autor

Elias Miguel Abbate Leão

GitHub:
https://github.com/ConsoleJorney
