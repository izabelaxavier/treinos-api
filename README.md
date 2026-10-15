# Treinos API

API REST desenvolvida em **Java 17 com Spring Boot** para gerenciamento de exercícios físicos, treinos e registros de desempenho. O projeto utiliza **MySQL** para persistência, **Spring Data JPA/Hibernate** como ORM e **Spring Security** para proteger as operações de escrita do recurso de exercícios.

> Projeto acadêmico das disciplinas de Arquitetura e Desenvolvimento de APIs.

## Integrantes

- **Izabela Xavier de Jesus** — RU 5315281
- **João Gabriel Costa Fernando** — RU 5327853

## Visão geral

A API disponibiliza recursos HTTP para:

- cadastrar, consultar, atualizar e excluir exercícios;
- cadastrar e consultar treinos;
- associar exercícios a treinos;
- registrar a execução de exercícios, incluindo data, séries, repetições e carga;
- validar os campos obrigatórios do exercício;
- tratar recursos inexistentes com respostas HTTP adequadas;
- proteger operações de criação, atualização e exclusão de exercícios com HTTP Basic;
- aceitar requisições CORS provenientes de um frontend local em `http://localhost:3000`.

## Tecnologias

| Tecnologia | Uso no projeto |
|---|---|
| Java 17 | Linguagem de programação |
| Spring Boot 4.1.1 | Inicialização e configuração da aplicação |
| Spring Web MVC | Controllers e endpoints HTTP |
| Spring Data JPA | Abstração de persistência e repositórios |
| Hibernate | Implementação do ORM/JPA |
| MySQL | Banco de dados relacional |
| Spring Security | HTTP Basic, autorização e CORS |
| Bean Validation | Validação de campos obrigatórios |
| Maven Wrapper | Execução do Maven sem instalação global |
| Postman | Testes manuais dos endpoints |

## Pré-requisitos

Antes de iniciar, instale ou tenha disponível:

- JDK 17 ou superior;
- MySQL em execução;
- Git;
- Postman ou outro cliente HTTP, caso queira reproduzir os testes manuais.

O projeto inclui o **Maven Wrapper** (`mvnw`, `mvnw.cmd` e `.mvn`), portanto não é necessário instalar o Maven separadamente.

## Clonagem

```bash
git clone https://github.com/izabelaxavier/treinos-api.git
cd treinos-api
```

## Configuração do banco de dados

Crie o banco antes de iniciar a aplicação:

```sql
CREATE DATABASE treinos_api;
```

Por padrão, a aplicação se conecta ao MySQL local com:

- host: `localhost`;
- porta: `3306`;
- banco: `treinos_api`;
- usuário: `root`.

O usuário pode ser alterado diretamente em `src/main/resources/application.properties` caso necessário. A senha não deve ser gravada no arquivo: ela é lida pela variável `DB_PASSWORD`.

## Variáveis de ambiente

A aplicação precisa das três variáveis abaixo para iniciar:

| Variável | Obrigatória | Finalidade |
|---|---:|---|
| `DB_PASSWORD` | Sim | Senha do usuário MySQL configurado na aplicação |
| `SECURITY_USERNAME` | Sim | Usuário da autenticação HTTP Basic |
| `SECURITY_PASSWORD` | Sim | Senha da autenticação HTTP Basic |

As credenciais de autenticação são mantidas em memória durante a execução e a senha é codificada com BCrypt. Não publique valores reais no GitHub.

### Linux ou macOS

Configure as variáveis na mesma sessão do terminal em que a aplicação será iniciada:

```bash
export DB_PASSWORD="SUA_SENHA_MYSQL"
export SECURITY_USERNAME="SEU_USUARIO_API"
export SECURITY_PASSWORD="SUA_SENHA_API"
```

### Windows PowerShell

```powershell
$env:DB_PASSWORD="SUA_SENHA_MYSQL"
$env:SECURITY_USERNAME="SEU_USUARIO_API"
$env:SECURITY_PASSWORD="SUA_SENHA_API"
```

### IDE

Ao executar pela IDE, adicione as três variáveis no campo **Environment variables** da configuração de execução do Spring Boot. A aplicação não deve ser iniciada antes que elas estejam definidas.

## Execução

### Linux ou macOS

```bash
./mvnw spring-boot:run
```

### Windows PowerShell

```powershell
.\mvnw.cmd spring-boot:run
```

Depois da inicialização, a API estará disponível em:

```text
http://localhost:8080
```

Na primeira execução, o Maven pode baixar as dependências. O Hibernate está configurado com `spring.jpa.hibernate.ddl-auto=update`, portanto cria ou atualiza as tabelas conforme as entidades do projeto. O banco `treinos_api` precisa existir previamente.

## Organização do projeto

```text
src/
├── main/
│   ├── java/com/izabelaxavier/treinosapi/
│   │   ├── config/          # Segurança, autenticação e CORS
│   │   ├── controller/      # Endpoints HTTP
│   │   ├── dto/             # Objetos de entrada das requisições
│   │   ├── exception/       # Exceções e tratamento global de erros
│   │   ├── model/           # Entidades JPA
│   │   ├── repository/      # Interfaces Spring Data JPA
│   │   └── service/         # Regras de negócio
│   └── resources/
│       └── application.properties
└── test/                    # Testes automatizados do projeto
```

O fluxo principal segue a separação em camadas:

```text
Cliente HTTP → Controller → Service → Repository → MySQL
```

## Endpoints

### Exercícios

Este é o recurso principal do CRUD. As consultas são públicas; as operações de escrita exigem HTTP Basic.

| Método | Endpoint | Descrição | Autenticação |
|---|---|---|---|
| `GET` | `/exercicios` | Lista todos os exercícios | Não |
| `GET` | `/exercicios/{id}` | Consulta um exercício por ID | Não |
| `POST` | `/exercicios` | Cria um exercício | Sim |
| `PUT` | `/exercicios/{id}` | Atualiza um exercício | Sim |
| `DELETE` | `/exercicios/{id}` | Exclui um exercício | Sim |

### Treinos

| Método | Endpoint | Descrição | Autenticação |
|---|---|---|---|
| `GET` | `/treinos` | Lista os treinos | Não |
| `POST` | `/treinos` | Cria um treino | Não |

### Relação entre treinos e exercícios

| Método | Endpoint | Descrição | Autenticação |
|---|---|---|---|
| `GET` | `/treino-exercicios` | Lista as associações | Não |
| `POST` | `/treino-exercicios` | Associa um exercício a um treino | Não |
| `DELETE` | `/treino-exercicios/{id}` | Exclui uma associação | Não |

### Registros de treino

| Método | Endpoint | Descrição | Autenticação |
|---|---|---|---|
| `GET` | `/registros-treino` | Lista os registros de treino | Não |
| `POST` | `/registros-treino` | Cria um registro de treino | Não |

## Modelos e exemplos de requisição

### Exercício

Campos disponíveis:

| Campo | Tipo | Obrigatório | Descrição |
|---|---|---:|---|
| `id` | `Long` | Gerado | Identificador do exercício |
| `nome` | `String` | Sim | Nome do exercício |
| `grupoMuscular` | `String` | Sim | Grupo muscular trabalhado |
| `descricao` | `String` | Não | Descrição complementar |
| `fotoUrl` | `String` | Não | URL de uma imagem |
| `videoUrl` | `String` | Não | URL de um vídeo demonstrativo |

Exemplo de criação:

```json
{
  "nome": "Supino reto",
  "grupoMuscular": "Peito",
  "descricao": "Exercício realizado com barra e banco horizontal",
  "fotoUrl": "https://exemplo.com/supino.jpg",
  "videoUrl": "https://exemplo.com/supino"
}
```

Exemplo com `curl` — consulta pública:

```bash
curl http://localhost:8080/exercicios
```

Exemplo com `curl` — criação protegida:

```bash
curl -X POST http://localhost:8080/exercicios \
  -u "$SECURITY_USERNAME:$SECURITY_PASSWORD" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Supino reto",
    "grupoMuscular": "Peito",
    "descricao": "Exercício para peitoral"
  }'
```

Exemplo de atualização:

```bash
curl -X PUT http://localhost:8080/exercicios/1 \
  -u "$SECURITY_USERNAME:$SECURITY_PASSWORD" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Supino reto atualizado",
    "grupoMuscular": "Peito",
    "descricao": "Descrição atualizada"
  }'
```

Exemplo de exclusão:

```bash
curl -X DELETE http://localhost:8080/exercicios/1 \
  -u "$SECURITY_USERNAME:$SECURITY_PASSWORD"
```

## Autenticação e autorização

A aplicação utiliza **HTTP Basic** por meio do Spring Security:

1. defina `SECURITY_USERNAME` e `SECURITY_PASSWORD` no ambiente;
2. inicie a aplicação;
3. no Postman, abra a aba **Authorization**;
4. selecione **Basic Auth**;
5. informe o usuário e a senha configurados;
6. envie a requisição protegida.

As seguintes operações são protegidas:

- `POST /exercicios/**`;
- `PUT /exercicios/**`;
- `DELETE /exercicios/**`.

As demais rotas são permitidas pela configuração atual do projeto.

## Validação e tratamento de erros

Os campos `nome` e `grupoMuscular` do exercício utilizam `@NotBlank`. Quando algum deles é enviado vazio, a API retorna `400 Bad Request` com a indicação do campo inválido.

Quando um exercício não é encontrado, o serviço lança `RecursoNaoEncontradoException`, tratada globalmente como `404 Not Found`.

Principais respostas:

| Status | Significado |
|---:|---|
| `200 OK` | Consulta ou atualização concluída |
| `201 Created` | Exercício criado |
| `204 No Content` | Exercício excluído |
| `400 Bad Request` | Dados inválidos ou campos obrigatórios ausentes |
| `401 Unauthorized` | Autenticação ausente ou inválida |
| `404 Not Found` | Recurso não encontrado |

## CORS

A configuração atual permite a origem:

```text
http://localhost:3000
```

Métodos permitidos:

```text
GET, POST, PUT, PATCH, DELETE, OPTIONS
```

Cabeçalhos permitidos:

```text
Authorization, Content-Type
```

Para utilizar um frontend em outra origem, atualize `setAllowedOrigins` na classe `SecurityConfig` antes de executar a aplicação.

## Testes

Os testes manuais foram realizados com Postman e contemplam:

- listagem de exercícios;
- consulta por ID;
- consulta de recurso inexistente;
- criação autenticada;
- tentativa de criação sem autenticação;
- validação de nome vazio;
- validação de grupo muscular vazio;
- atualização autenticada;
- tentativa de atualização sem autenticação;
- atualização de ID inexistente;
- exclusão autenticada;
- tentativa de exclusão sem autenticação;
- confirmação após exclusão;
- requisição `OPTIONS` para CORS.

Para executar os testes automatizados disponíveis no projeto:

```bash
./mvnw test
```

## Segurança e boas práticas

- não versione senhas, tokens ou arquivos `.env` com credenciais reais;
- configure as variáveis de ambiente antes de iniciar a aplicação;
- utilize um usuário MySQL com permissões mínimas em ambientes não acadêmicos;
- em produção, considere substituir o usuário em memória por autenticação persistida ou tokens;
- restrinja as origens CORS ao domínio real do frontend.

## Repositório

O código-fonte está disponível em:

<https://github.com/izabelaxavier/treinos-api>

## Licença

Este projeto foi desenvolvido para fins acadêmicos.
