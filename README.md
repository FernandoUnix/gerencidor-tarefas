# Criando APIs com Java 17 usando Spring Boot e AWS

**Curso Avançado de Desenvolvimento com Java 17, Spring Boot e AWS**

**Link do Curso:** [Criando APIs com Java 17 usando Spring Boot e AWS](https://www.udemy.com/course/criando-apis-com-java-17-usando-spring-boot-e-aws)

---

## Descrição

Você está pronto para dar um passo à frente na sua jornada como desenvolvedor de software? Este curso é a sua oportunidade de dominar tecnologias essenciais para a criação de aplicativos modernos e escaláveis. Seja você um iniciante ou um programador experiente, este curso abrangente irá aprimorar suas habilidades e prepará-lo para enfrentar desafios do mundo real.

---

## O que você aprenderá

- **Configuração de ambiente**: Passo a passo para configurar todo o ambiente necessário para o desenvolvimento de APIs.
- **Criação de Diagramas UML**: Como criar diagramas para projetar soluções e arquiteturas de sistemas.
- **Construção de APIs Avançadas com Spring Boot**: Técnicas para criar APIs robustas e escaláveis.
- **Controle de versão com GitHub**: Como versionar o código fonte e colaborar com GitHub.
- **Trabalhando com Amazon RDS PostgreSQL**: Integração com banco de dados PostgreSQL usando RDS da AWS.
- **Segurança de APIs com Spring Security**: Proteção das APIs contra acessos não autorizados.
- **Automatização de testes com Postman**: Como testar suas APIs de forma automatizada.
- **Autenticação e Autorização**: Implementação de autenticação e autorização utilizando Spring Security.
- **Implantação na AWS Elastic Beanstalk**: Como implantar a API Spring Boot na nuvem utilizando o AWS Elastic Beanstalk.

---

## Requisitos

- **Conhecimento básico de programação**: É desejável que os participantes tenham familiaridade com conceitos básicos de programação, como variáveis, estruturas condicionais (if/else), loops e funções.
- **Noções básicas de lógica de programação**: Ter uma compreensão sólida de lógica de programação é essencial para a resolução de problemas e a construção de algoritmos.
- **Conhecimento básico de Java**: Familiaridade com a linguagem Java, especialmente nas versões mais recentes (Java 17).

---

## Como executar o projeto

1. **Instalar o Docker**:  
   O Docker é necessário para executar o banco de dados PostgreSQL.  
   [Instale o Docker](https://docs.docker.com/desktop/).

2. **Executar banco de dados PostgreSQL**:  
   Navegue até a pasta `/postgreSQL` e execute o comando abaixo no terminal para iniciar o banco de dados:
   ```bash
   docker-compose up

3. **Abrir o projeto no IntelliJ`**:

Abra o projeto com IntelliJ e verifique se a versão do Java está correta - Java 17.

4. **Instalar e ativar o plugin Lombok no IntelliJ`**:

Instale e ative no IntelliJ o plugin do Lombok  
   Abra o IntelliJ, vá para **Configurações** e busque por **Plugins**. Depois, busque por **Lombok** e instale o plugin.

5. **Executar a classe main`**:

Execute a classe `main` do projeto `GerenciadorTarefasApplication` localizada em `com.gerenciador.tarefas`

6. **Testar a API**:

 Faça um teste simples e acesse a seguinte URL no seu navegador:  
   [http://localhost:8080/teste-api](http://localhost:8080/teste-api)  
   Isso deve retornar uma mensagem de "Sucesso". Se você ver essa mensagem, tudo está funcionando bem.

---

## Postman Collection

A collection do Postman está localizada na pasta raiz do projeto com o nome **gerenciador-tarefas.postman_collection.json**.  
**OBS**: Não se esqueça de criar a variável global `{{LOCALHOST}}` ou substituir `{{LOCALHOST}}` por `localhost:8080` no seu ambiente.

---

# Endpoints da API de Gerenciamento de Tarefas

## 1. **Teste API**
- **Método**: `GET`
- **URL**: `/teste-api`

## 2. **Teste Bem-Vindo**
- **Método**: `GET`
- **URL**: `/teste-api-bem-vindo?nome={{nome}}`

## 3. **Usuários**

### 3.1 **Cadastrar Usuário**
- **Método**: `POST`
- **URL**: `/usuarios`
- **Corpo**:
  ```json
  {
    "username": "amaro",
    "password": "12345",
    "roles": [{ "nome": "ADMINISTRADOR" }]
  }
  ```

### 3.2 **Obter Usuários**
- **Método**: `GET`
- **URL**: `/usuarios`

### 3.3 **Atualizar Usuário**
- **Método**: `PUT`
- **URL**: `/usuarios`
- **Corpo**:
  ```json
  {
    "id": 1,
    "username": "fernando.amaro",
    "password": "123456789"
  }
  ```

### 3.4 **Excluir Usuário**
- **Método**: `DELETE`
- **URL**: `/usuarios`
- **Corpo**:
  ```json
  { "id": 1 }
  ```

## 4. **Login**

### 4.1 **Efetuar Login**
- **Método**: `POST`
- **URL**: `/login`
- **Corpo**:
  ```json
  {
    "username": "admin",
    "password": "123456"
  }
  ```

## 5. **Tarefas**

### 5.1 **Criar Tarefa**
- **Método**: `POST`
- **URL**: `/gerenciador-tarefas`
- **Corpo**:
  ```json
  {
    "titulo": "Primeira Tarefa",
    "descricao": "Descrição da tarefa",
    "criadorId": 1,
    "quantidadeHorasEstimadas": 2
  }
  ```

### 5.2 **Obter Tarefas**
- **Método**: `GET`
- **URL**: `/gerenciador-tarefas?page=0&size=3`

### 5.3 **Atualizar Tarefa**
- **Método**: `PUT`
- **URL**: `/gerenciador-tarefas/{id}`
- **Corpo**:
  ```json
  {
    "titulo": "Tarefa Atualizada",
    "descricao": "Descrição atualizada",
    "status": "PROGRESSO",
    "responsavelId": 1,
    "quantidadeHorasEstimadas": 2,
    "quantidadeHorasRealizada": null
  }
  ```

### 5.4 **Excluir Tarefa**
- **Método**: `DELETE`
- **URL**: `/gerenciador-tarefas/{id}`
