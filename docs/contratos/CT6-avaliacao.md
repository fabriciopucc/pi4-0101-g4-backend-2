# CT6 — Persistência de avaliação

## 1. Objetivo

Definir a estrutura de persistência das avaliações realizadas pelos clientes aos prestadores.

## 2. Responsáveis

- Emissor: Backend.
- Receptor: Banco de dados PostgreSQL.

## 3. Recurso

- Tabela: `avaliacao`.

## 4. Estrutura dos dados

| Coluna | Tipo lógico | Descrição |
|---|---|---|
| id | Identificador | Identificador da avaliação |
| cliente_id | Identificador | Identificador do cliente |
| prestador_id | Identificador | Identificador do prestador avaliado |
| nota | Inteiro | Nota atribuída, de 1 a 5 |
| comentario | Texto | Comentário opcional |
| confirmou_atendimento | Booleano | Indica se o cliente confirmou o atendimento |
| criado_em | Data/hora | Data e hora do registro |

## 5. Regras de negócio

- A nota deve estar entre 1 e 5.
- O comentário é opcional.
- A avaliação deve registrar se o atendimento foi confirmado.
- A média das avaliações é calculada pelo backend.

## 6. Erros e exceções

- Falha ao persistir uma avaliação.
- Falha ao consultar as avaliações.
- Falha de conexão com o banco de dados.

## 7. Fluxos relacionados

- E3 — Pesquisa de prestadores.
- E4 — Exibição da lista de prestadores.
- E5 — Consulta ao perfil do prestador.
- E6 — Avaliação de prestador.
