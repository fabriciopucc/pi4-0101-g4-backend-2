# CT2 — Persistência de usuário

## 1. Objetivo

Definir a estrutura de persistência dos usuários no banco de dados PostgreSQL.

## 2. Responsáveis

- Emissor: Backend.
- Receptor: Banco de dados PostgreSQL.

## 3. Recurso

- Tabela: `usuario`.

## 4. Estrutura dos dados

| Coluna | Tipo lógico | Descrição |
|---|---|---|
| id | Identificador | Identificador do usuário |
| nome | Texto | Nome do usuário |
| email | Texto | E-mail do usuário |
| senha_hash | Texto | Hash da senha |
| tipo | Texto | Tipo de usuário |
| criado_em | Data/hora | Data e hora do cadastro |

## 5. Regras de negócio

- O e-mail deve ser único.
- A senha deve ser armazenada como hash.
- O tipo de usuário deve corresponder aos tipos previstos pelo sistema.
- O backend é responsável por validar os dados antes de persistir o registro.

## 6. Erros e exceções

- Violação da restrição de unicidade do e-mail.
- Falha de conexão com o banco de dados.
- Falha ao persistir ou consultar os dados.

## 7. Fluxos relacionados

- E1 — Cadastro de usuário.
- E2 — Cadastro de prestador.
- E6 — Avaliação de prestador.
- E8 — Atualização do perfil do prestador.
- CT14 — Autenticação de usuário.
