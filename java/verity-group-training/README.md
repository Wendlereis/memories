# Treinamento Java

Este repositório contém detalhes do treinamento de Java, ministrado pela empresa [Verity](http://verity.com.br/)

Uma semana antes do inicio do treinamento recebi apostilas de estudo sobre Java e SQL. Portanto os exercícios iniciam no capitulo 3 da apostila de Java.

## Primeiro Dia - 07/01

### Capitulo 3
O Capitulo 3 aborda o conteúdo de Orientação a Objetos, iniciamos apenas com uma abstração simples de um objeto do mundo real.

O objeto escolhido foi um lápis, onde extraímos os seguintes atributos

- cor
- formato
- material

e sua função

- escrever

### Capitulo 4
O capitulo 4 aborda o uso de Array para armazenar diversos valores em uma só variável.

O exercício e o seguinte: _Uma empresa ao ser criada dever ter N funcionários._ Para isso foi utilizada 2 classes [Empresa e Funcionário].
Ao ser criada a empresa, abria a possibilidade de adicionar funcionários a uma lista do mesmo tipo. Ao ser preenchida podemos regatar valores da empresa e nome de sus funcionários.

### Capitulo 5
O capitulo 5 aborda o uso de encapsulamento, utilizando atributos privados e seus respectivos `Getters and Setters` 

O exercício e o seguinte: _O funcionário da empresa tem que ter uma conta, porém outros funcionários não podem fazer saques e depósitos_
Para resolução deste exercício foi criado classe Funcionário e Conta, e na função _min_ foi criado objetos do tipo conta e funcionário e foram armazenado em um lista.
ao executar um saque deve ser informado nome do titular da conta e seu numero da conta, caso uma conta exista com estas credenciais o saque ou deposito será realizado.

## Segundo Dia - 14/01

### Capitulo 6
O capitulo 6 aborda o uso de herança, o conceito de receber atributos de uma classe pai. O exercício propost tinha como objetivo
abtrair um objeto e criar sua classe pai para que fosse feita a sua herança

### Capitulo 7
O Capitulo 7 aborda o uso de classes e metodos abstrados, incluindo em nosso exercício da herança o conceito de que super classes nao devem ser instanciadas
pois sao sao objetos palpaveis e servem apenas como molde para criacao de outros objetos das classes filhas

### Capitulo 8
O O Capitulo 7 aborda o uso de interface, que sao regras impostas para implementacao em classes diferentes. Tambem foi adicionado ao exercicio de herança com intuito de melhorar 
implementacao de metodos abstratos
