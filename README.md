# Sistema de Biblioteca

Bem vindo(a)! Este é um sistema de gerenciamento de biblioteca desenvolvido em Java utilizando Swing para a interface gráfica e PostgreSQL como banco de dados. O sistema permite que o usuário busque e liste leitores, livros, empréstimos e multas.

## Funcionalidades

- **Buscar Leitores**: Permite buscar leitores pelo CPF.
- **Buscar Livros**: Permite buscar livros pelo ID.
- **Buscar Empréstimos**: Permite buscar empréstimos pelo ID.
- **Buscar Multas**: Permite buscar multas pelo ID.
- **Listar Leitores**: Exibe uma lista de todos os leitores cadastrados.
- **Listar Livros**: Exibe uma lista de todos os livros cadastrados.
- **Listar Empréstimos**: Exibe uma lista de todos os empréstimos realizados.
- **Listar Multas**: Exibe uma lista de todas as multas registradas.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para o desenvolvimento.
- **Java Swing**: Biblioteca para a construção da interface gráfica.
- **PostgreSQL**: Sistema de gerenciamento de banco de dados relacional utilizado para armazenar os dados.
- **JDBC**: API para conectar e executar consultas no banco de dados PostgreSQL.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

```plaintext
SistemaBiblioteca
└── src
    └── main
        └── java
            ├── controller
            │   ├── EmprestimoController.java
            │   ├── LeitorController.java
            │   └── LivroController.java
            │
            ├── dao
            │   ├── DatabaseConnection.java
            │   ├── EmprestimoDAO.java
            │   ├── LeitorDAO.java
            │   ├── LivroDAO.java
            │   └── MultaDAO.java
            │
            ├── model
            │   ├── Emprestimo.java
            │   ├── Leitor.java
            │   ├── Livro.java
            │   └── Multa.java
            │
            ├── service
            │   ├── EmprestimoService.java
            │   ├── LeitorService.java
            │   ├── LivroService.java
            │   └── MultaService.java
            │
            └── view
                ├── GerenciadorDeTelas.java
                ├── TelaBuscar.java
                ├── TelaBuscarEmprestimo.java
                ├── TelaBuscarLeitor.java
                ├── TelaBuscarLivro.java
                ├── TelaBuscarMulta.java
                ├── TelaFuncoes.java
                ├── TelaInicial.java
                ├── TelaListagem.java
                ├── TelaListarEmprestimos.java
                ├── TelaListarLeitores.java
                ├── TelaListarLivros.java
                └── TelaListarMultas.java
```

## Melhorias Futuras

Este projeto está em constante evolução e há várias melhorias que podem ser implementadas para torná-lo ainda mais robusto e funcional. Aqui estão algumas sugestões de melhorias futuras:

1. **Validação de Dados**:
   - Implementar validações mais robustas para entradas de usuários, como CPF, e-mails e outros campos, para garantir que os dados inseridos sejam válidos e consistentes.

2. **Interface Gráfica Melhorada**:
   - Melhorar a interface gráfica com um design mais moderno e responsivo, utilizando bibliotecas de UI como JavaFX ou frameworks de design.

3. **Funcionalidade de Adição, Edição e Exclusão**:
   - Adicionar funcionalidades para adicionar, editar e excluir leitores, livros, empréstimos e multas, permitindo uma gestão mais completa dos dados.

4. **Testes Automatizados**:
   - Implementar testes automatizados (unitários e de integração) para garantir a qualidade do código e facilitar a manutenção.

5. **Integração com APIs Externas**:
   - Integrar o sistema com APIs externas para buscar informações sobre livros, como sinopses, capas e avaliações, melhorando a experiência do usuário.

6. **Melhorias de Performance**:
   - Analisar e otimizar o desempenho do sistema, especialmente em operações que envolvem consultas ao banco de dados.
   
---

🖤 **Obrigada por visitar este repositório!**
