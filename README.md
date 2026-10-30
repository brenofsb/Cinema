# Sistema de Cinema

Projeto desenvolvido para a disciplina de **Programação Orientada a Objetos**. É uma aplicação de console em Java para gerenciar filmes e sessões de cinema e simular a venda de ingressos.

## Funcionalidades

- Consultar filmes e seus dados: título, duração, classificação etária, categoria e sinopse.
- Alterar a categoria e a sinopse de um filme.
- Consultar sessões, incluindo filme, horários, capacidade e arrecadação.
- Vender ingressos integrais ou com meia-entrada.
- Verificar a classificação etária do filme e a disponibilidade de lugares antes da venda.
- Consultar e alterar o preço integral dos ingressos.
- Consultar o total de ingressos vendidos e a arrecadação das sessões.

## Estrutura do projeto

- `Cinema.java`: contém o menu de console e a interação com o usuário.
- `Filme.java`: representa os filmes e suas informações.
- `Sessao.java`: representa as sessões, controla ingressos, capacidade e arrecadação.

## Requisitos

- JDK 11 ou superior.

O projeto usa `String.isBlank()`, disponível a partir do Java 11.

## Como compilar e executar

No terminal, na pasta do projeto:

```bash
javac Cinema.java Filme.java Sessao.java
java Cinema
```

O programa inicia com filmes e sessões de exemplo. Use as opções exibidas no menu para navegar pelas funcionalidades; digite `0` para voltar ou sair dos menus.
