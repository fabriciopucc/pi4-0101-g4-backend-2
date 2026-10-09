# ADR 0001: Usar PostgreSQL como banco de dados

**Status:** aceito

**Contexto:** O QuemResolve precisa armazenar usuários, perfis de prestadores, categorias, regiões de atendimento e avaliações. Esses dados possuem relações, como avaliações vinculadas a clientes e prestadores. O backend-2 será responsável pelas demais funcionalidades do projeto e pelo acesso ao banco.

**Decisão:** Utilizar PostgreSQL como banco de dados relacional acessado pelo backend-2. Organizar os dados em tabelas com chaves primárias, chaves estrangeiras e restrições de integridade.

**Alternativas consideradas:**
- MySQL: alternativa relacional viável, não selecionada porque o grupo definiu PostgreSQL como banco do projeto.
- MongoDB: descartado nesta proposta por exigir uma abordagem diferente para controlar relações representadas diretamente por tabelas e chaves estrangeiras no modelo escolhido.

**Consequências:**
- Positivas: chaves estrangeiras poderão impedir avaliações associadas a usuários ou prestadores inexistentes; consultas SQL permitirão combinar prestadores, categorias e avaliações para apresentar resultados de pesquisa.
- Negativas: será necessário configurar e manter o banco, proteger credenciais, realizar backups e controlar alterações do esquema por migrações; consultas precisarão de índices e ajustes conforme o volume de dados aumentar.
