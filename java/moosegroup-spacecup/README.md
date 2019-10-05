# MooseGroup-SpaceCup
Projeto SpaceCup - Desenvolvimento de software para obtenção de dados durante lançamento de foguetes.

## Tabelas Banco de Dados
### LANCAMENTOS
| KEY | NULL | TYPE |
| --- | --- | --- |
| ID_LANCAMENTO | NOT NULL | NUMBER |
| ID_GRUPO | NOT NULL | NUMBER |
| ALTITUDE_MAXIMA | NOT NULL | NUMBER(6,2) |
| VELOCIDADE_MAXIMA | NOT NULL | NUMBER(6,2) |
| TEMPO_PROPULSAO | NOT NULL | NUMBER(6,2) |
| PICO_ACELERACAO | NOT NULL | NUMBER(6,2) |
| ACELERACAO_MEDIA | NOT NULL | NUMBER(6,2) |
| TEMPO_APOGEU_DESCIDA | NOT NULL | NUMBER(6,2) |
| TEMPO_EJECAO | NOT NULL | NUMBER(6,2) |
| ALTITUDE_EJECAO | NOT NULL | NUMBER(6,2) |
| TAXA_DESCIDA | NOT NULL | NUMBER(6,2) |
| DURACAO_VOO | NOT NULL | NUMBER(6,2) |
| DATA_LANCAMENTO | NOT NULL | DATE |       
| DISTANCIA_ALVO | NOT NULL | NUMBER(6,2) |
| ANGULO_LANCAMENTO | NOT NULL | NUMBER(6,2) |
| VELOCIDADE_VENTO | NOT NULL | NUMBER(6,2) |

### INTEGRANTE
| KEY | NULL | TYPE |
| --- | --- | --- |
| ID_INTEGRANTE | NOT NULL | NUMBER |
| NOME | NOT NULL | VARCHAR2(100)|
| RM | NOT NULL | VARCHAR2(6) |   
| ID_GRUPO | NOT NULL | NUMBER |