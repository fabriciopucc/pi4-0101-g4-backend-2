# CT4 — Persistência de perfil de prestador

## 1. Objetivo

Definir a estrutura de persistência dos perfis profissionais no banco de dados PostgreSQL.

## 2. Responsáveis

- Emissor: Backend.
- Receptor: Banco de dados PostgreSQL.

## 3. Recurso

- Tabela: `perfil_prestador`.

## 4. Estrutura dos dados

| Coluna | Tipo lógico | Descrição |
|---|---|---|
| id | Identificador | Identificador do perfil |
| usuario_id | Identificador | Identificador do usuário associado |
| nome_profissional | Texto | Nome profissional |
| descricao | Texto | Descrição do prestador |
| categorias | Lista ou estrutura equivalente | Categorias de serviços |
| servicos | Lista ou estrutura equivalente | Serviços oferecidos |
| regiao_atendimento | Lista ou estrutura equivalente | Regiões atendidas |
| valor_referencia | Decimal | Preço de referência |
| tipo_contato | Texto | Tipo de contato |
| contato_valor | Texto | Valor ou endereço do contato |
| latitude | Decimal | Latitude, quando disponível |
| longitude | Decimal | Longitude, quando disponível |
| raio_km | Decimal | Raio de atendimento, quando disponível |
| atualizado_em | Data/hora | Data e hora da atualização |

## 5. Regras de negócio

- O campo `usuario_id` deve ser único.
- Os dados do perfil devem estar associados a um usuário.
- Os campos opcionais devem respeitar a definição da especificação.
- O backend deve validar os dados antes de persistir as alterações.

## 6. Erros e exceções

- Violação da restrição de unicidade de `usuario_id`.
- Falha de conexão com o banco de dados.
- Falha ao cadastrar, consultar ou atualizar o perfil.

## 7. Fluxos relacionados

- E2 — Cadastro de prestador.
- E3 — Pesquisa de prestadores.
- E4 — Exibição da lista de prestadores.
- E5 — Consulta ao perfil do prestador.
- E7 — Contato com prestador.
- E8 — Atualização do perfil do prestador.
- E10 — Comunicação em tempo real.
