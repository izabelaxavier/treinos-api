# Treinos API

API REST desenvolvida em Java com Spring Boot para gerenciamento de exercícios físicos, utilizando MySQL para persistência dos dados.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Spring Security
- Bean Validation
- Postman

## Funcionalidades

- Cadastro de exercícios.
- Consulta de todos os exercícios.
- Consulta de exercício por ID.
- Atualização de exercícios.
- Exclusão de exercícios.
- Validação dos campos obrigatórios.
- Tratamento global de erros e recursos não encontrados.
- Autenticação HTTP Basic nas operações de criação, atualização e exclusão.
- Configuração de CORS para permitir requisições de uma origem local.

## Modelo de dados

Cada exercício possui os seguintes campos:

| Campo | Descrição |
|---|---|
| `id` | Identificador do exercício |
| `nome` | Nome do exercício, obrigatório |
| `grupoMuscular` | Grupo muscular trabalhado, obrigatório |
| `descricao` | Descrição do exercício |
| `fotoUrl` | URL da imagem do exercício |
| `videoUrl` | URL do vídeo demonstrativo |

## Pré-requisitos

- Java Development Kit (JDK) 17.
- MySQL instalado e em execução.
- Git para clonar o repositório.
- Postman ou ferramenta equivalente para testar os endpoints.

O projeto inclui o Maven Wrapper (`mvnw`, `mvnw.cmd` e a pasta `.mvn`), permitindo executar o Maven sem precisar instalá-lo separadamente.

## Configuração do banco de dados

### 1. Crie o banco de dados

Com o MySQL em execução, conecte-se ao servidor e execute:

```sql
CREATE DATABASE treinos_api;
```

### 2. Configure as variáveis de ambiente

A aplicação utiliza as seguintes variáveis de ambiente:

| Variável | Finalidade |
|---|---|
| `DB_PASSWORD` | Senha do usuário MySQL utilizado pela aplicação |
| `SECURITY_USERNAME` | Usuário para autenticação HTTP Basic |
| `SECURITY_PASSWORD` | Senha para autenticação HTTP Basic |

O arquivo `src/main/resources/application.properties` contém a configuração de conexão com o banco de dados:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/treinos_api
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
```

A aplicação utiliza o usuário `root` do MySQL por padrão. Caso utilize outro usuário, ajuste a propriedade `spring.datasource.username`.

O Hibernate está configurado para atualizar automaticamente o esquema das tabelas durante a execução. O banco `treinos_api` precisa existir antes de iniciar a aplicação.

As credenciais HTTP Basic são configuradas por meio das variáveis `SECURITY_USERNAME` e `SECURITY_PASSWORD`. O usuário de autenticação é mantido em memória, e sua senha é codificada com BCrypt.

**Importante:** não publique senhas reais no repositório.

## Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/izabelaxavier/treinos-api.git
cd treinos-api
```

### 2. Configure as variáveis de ambiente

No Windows, abra o PowerShell na raiz do projeto e configure as variáveis para a sessão atual, substituindo os valores pelos seus:

```powershell
$env:DB_PASSWORD="SUA_SENHA_MYSQL"
$env:SECURITY_USERNAME="SEU_USUARIO_API"
$env:SECURITY_PASSWORD="SUA_SENHA_API"
```

Essas configurações são temporárias e ficam disponíveis no terminal atual.

No Linux ou macOS, configure as variáveis equivalentes no terminal antes de iniciar a aplicação.

### 3. Inicie a aplicação

No Windows, execute:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS, execute:

```bash
./mvnw spring-boot:run
```

A primeira execução pode demorar enquanto o Maven baixa as dependências necessárias.

### 4. Acesse a API

Por padrão, a aplicação estará disponível em:

`http://localhost:8080`

## Endpoints

| Método | Endpoint | Descrição | Autenticação |
|---|---|---|---|
| GET | `/exercicios` | Lista todos os exercícios | Não |
| GET | `/exercicios/{id}` | Busca um exercício por ID | Não |
| POST | `/exercicios` | Cadastra um exercício | Sim |
| PUT | `/exercicios/{id}` | Atualiza um exercício | Sim |
| DELETE | `/exercicios/{id}` | Exclui um exercício | Sim |

### Autenticação

Os endpoints de criação, atualização e exclusão exigem autenticação HTTP Basic.

No Postman:

1. Selecione a requisição desejada.
2. Acesse a aba **Authorization**.
3. Selecione o tipo **Basic Auth**.
4. Informe o usuário e a senha definidos nas variáveis de ambiente.
5. Envie a requisição.

As consultas GET são públicas conforme a configuração atual do Spring Security.

## Validação e tratamento de erros

A API valida os campos obrigatórios e trata erros relacionados a dados inválidos e recursos não encontrados.

Principais códigos HTTP utilizados:

| Código | Significado |
|---|---|
| `200 OK` | Consulta ou atualização realizada com sucesso |
| `201 Created` | Exercício criado |
| `204 No Content` | Exercício excluído |
| `400 Bad Request` | Dados inválidos |
| `401 Unauthorized` | Autenticação ausente ou inválida |
| `404 Not Found` | Exercício não encontrado |

Os códigos retornados podem variar conforme a operação e o tratamento implementado no código.

## CORS

A configuração atual permite requisições originadas de:

`http://localhost:3000`

Os métodos permitidos são GET, POST, PUT, PATCH, DELETE e OPTIONS. Os cabeçalhos autorizados são `Authorization` e `Content-Type`.

A origem permitida pode ser ajustada conforme as necessidades de um frontend.

## Testes

Os endpoints podem ser testados manualmente pelo Postman ou por ferramenta equivalente.

Os testes descritos para o projeto incluem consultas, criação, atualização, exclusão, validação de campos obrigatórios, autenticação e tratamento de recursos inexistentes.

## Autor

**Izabela Xavier**

Projeto acadêmico desenvolvido para a disciplina de Arquitetura e Desenvolvimento de APIs.