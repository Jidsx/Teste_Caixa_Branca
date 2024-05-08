# Teste de Caixa Branca

Este é um projeto em Java que demonstra um teste de caixa branca em uma aplicação simples de verificação de usuário em um banco de dados MySQL. O código apresenta métodos para conectar ao banco de dados, verificar um usuário e retornar o resultado da verificação.

## Documentação no código:
Não há documentação no código.

## Nomenclatura:
Tem uma boa nomenclatura das variáveis e constantes mas poderia ser melhorada. Por exemplo, a variável 'sql' poderia ser mais descritivo como 'sqlNomeUsuario'.

## Legibilidade e organização:
O código não está muito bem organizado, faltam espaços em algumas partes do código, o que dificulta a leitura. Além disso, a concatenação de strings na construção da consulta SQL poderia ser melhor formatada para facilitar a leitura. Além disso, a captura genérica das exceções (Exception e) torna difícil identificar problemas específicos.

## NullPointerExceptions:
Não há tratamento explícito para NullPointerExceptions.

## Arquitetura utilizada:
O código está seguindo um padrão básico de arquitetura de acesso a banco de dados, utilizando JDBC para se conectar ao banco de dados MySQL.

## Fechamento das conexões:
As conexões com o banco de dados não estão sendo fechadas corretamente. É necessário fechar as conexões, os statements e os result sets após o uso para evitar vazamento de recursos e problemas de desempenho.

# Erros Encontrados
### Erro na URL de conexão com o banco de dados:
Na linha onde a URL de conexão com o banco de dados é construída, há um erro de digitação:  com.mysql.Driver.Manager A classe correta para o driver do MySQL é com.mysql.jdbc.Driver. Portanto, a linha correta deveria ser:

java
Class.forName("com.mysql.jdbc.Driver").newInstance();


### Ausência de tratamento de exceções:
Embora o código contenha blocos try-catch para lidar com exceções durante a conexão com o banco de dados e a execução da consulta SQL, os blocos estão vazios. Isso significa que as exceções são simplesmente ignoradas, o que pode levar a problemas não tratados e comportamento inesperado da aplicação.

## Planilha de Teste
[Teste_Caixa_Branca.xlsx](https://github.com/Jidsx/Teste_Caixa_Branca/files/15243117/Teste_Caixa_Branca.xlsx)

## Grafo de Fluxo
![Grafo_fluxo](https://github.com/Jidsx/Teste_Caixa_Branca/assets/113401757/14ab9bdd-955d-49d0-8294-9c1344e49177)

## Cálculo da Complexidade Ciclomática
V(G) = é a complexidade ciclomática. 

E = é o número de arestas.

N = é o número de nós.

P = é o número de componentes conexos.

N = 20 (número de nós)

E = 20 (número de arestas)

P = 1 (número de componentes conexos)

V(G) = 20 - 20 + 2 * 1 = 2

## Caminhos: 

Caminho 1:

1-2-3-4-5-6-8-9-10-11-12-13-14-15-16-17-18-19-20

Caminho 2:

1-2-3-7-6-8-9-10-11-12-13-14-15-16-17-18-19-20

