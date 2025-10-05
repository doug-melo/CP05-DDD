# CP05 - Biblioteca

**Douglas dos Santros Melo - RM556439**

Projeto de gerenciamento de **Livros, Usuários e Empréstimos** utilizando **Spring Boot**, **Thymeleaf**, **JPA** e **H2**.  

O sistema permite realizar **CRUD** em cada entidade e registrar empréstimos de livros com datas de retirada e devolução.

---

## Tecnologias utilizadas
- Java 21
- Spring Boot 3
- Thymeleaf 3
- JPA / Hibernate
- H2 Database (em memória)
- Maven
- Bootstrap (estilização básica)

---

## Funcionalidades

### Livros
- Cadastro, listagem, edição e exclusão de livros.

### Usuários
- Cadastro, listagem, edição e exclusão de usuários.

### Empréstimos
- Registro de empréstimos
- Devolução de livros
- Listagem de empréstimos ativos
- Validação de datas

### Navegação
- Tela principal com acesso rápido a livros, usuários e empréstimos.
- Botão de retorno à tela principal em todas as telas.

---

## Como executar

### Pré-requisitos
- **Java 21** instalado
- **Maven** instalado

## Acesso ao Sistema

Após executar o projeto com `mvn spring-boot:run`, você pode acessar as páginas pelo navegador:

| Página                   | URL                                    |
|---------------------------|----------------------------------------|
| **Página Principal**      | [http://localhost:8080/](http://localhost:8080/) |
| **Livros**                | [http://localhost:8080/livros](http://localhost:8080/livros) |
| **Usuários**              | [http://localhost:8080/usuarios](http://localhost:8080/usuarios) |
| **Empréstimos**           | [http://localhost:8080/emprestimos](http://localhost:8080/emprestimos) |
| **H2 Console (Banco)**    | [http://localhost:8080/h2-console](http://localhost:8080/h2-console) |

### Configuração do H2 Console

| Campo      | Valor                       |
|------------|-----------------------------|
| **JDBC URL** | `jdbc:h2:mem:biblioteca`   |
| **Usuário**  | `sa`                       |
| **Senha**    | (vazio)                    |


### Passos
1. Clone o repositório:
```bash
git clone https://github.com/doug-melo/CP05-DDD.git
cd CP05 
mvn spring-boot:run
