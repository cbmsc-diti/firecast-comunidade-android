# Contribuindo com o FireCast Comunidade (Android)

## Rodando o projeto
1. Instalar Java 8
2. Instalar Android e Android Studio: https://developer.android.com/studio/install.html
3. Criar uma conta no [Github](www.github.com)
4. Clonar o projeto do Github
```
git clone https://github.com/cbmsc-diti/firecast-comunidade-android
```
5. No Android Studio, clicar em  `File > New > Import Project...` e selecionar a pasta para onde o projeto foi clonado.
6. Após terminar de importar o projeto, clicar em `Run`

## Como Contribuir

A lista de features, bugs e tarefas a serem completadas no firecast comunidade estão organizadas
usando Trello. O link para acessar a board é https://trello.com/b/jzmBA6SU/firecastcomunidade. Contribuições
não estão limitadas ao que está listado na board, novas ideias são bem vindas.

> Importante: Quando desejar contribuir, é interessante conversar com os responsáveis pelo projeto.

## Estrutura do Git

As branches do repositório são divididas da seguinte forma:

- `master`: Branch que contém versões estáveis para release.
- `dev`: Branch contendo features finalizadas (alpha).
- `feature/[iniciais]-[nome da feature]`: Branch me que uma feature está sendo desenvolvida. Por exemplo,
se José Maria fosse responsável pela feature `create button`, o nome da branch em que ele desenvolveria isso
seria `feature/jm-create-button`.
- `hotfix/[id]`: branch que corrige algum bug.


> Nenhum commit deve ser feito diretamente nas branches Master e Dev, todas as adições devem ser feitas
 via PullRequest.


## Considerações sobre o desenvolvimento

### Arquitetura

Usamos a arquitetura MVP (Model-View-Presenter), que são declaradas através de um contrato. Cada
componente da aplicação (uma tela, por exemplo), tipicamente possui seu package próprio com um arquivo Contract,
que define os contratos a serem seguidos naquele componente.

### Estrutura do app

Os pacotes são organizados da seguinte forma:

- `domain`: Definições do domínio (modelos e lógica de negócios)
- `data`: Definições de acesso aos dados (se acessa do servidor, de um sql, entre outros)
- `presentation`: Camada de apresentação do app, inclue tudo que é relacionado à view e comunicação
com o usuário.
    - `components`: Elementos que compõem uma tela, e que podem ser reutilizados. Por exemplo, um botão com um comportamento específico pode ser um componente.
    - `screens`: As telas do app, normalmente cada screen possui uma atividade.

### Bibliotecas

- Retrofit
- RxJava
- Picasso
- OpenStreetMap
- RetroLambda

## Documentação da API

A API atualmente não possui documentação.







