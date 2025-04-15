# 🛑 Central de Emergência 911 — APS de Estrutura de Dados

> **"Just a college project for the Data Structures course."**

---

## 🎯 Objetivo

Este projeto foi desenvolvido como parte da Avaliação Prática Supervisionada (APS) da disciplina **Tópicos Especiais**, com foco no uso de **filas com prioridade** para resolver problemas do mundo real. A linguagem utilizada foi **Java**, com arquitetura modular, padrão profissional e estrutura orientada a objetos.

---

## 🧠 Tema Escolhido: Central de Atendimento de Emergência (911)

O sistema simula o funcionamento de uma **central de emergência**, que recebe chamados com diferentes níveis de gravidade e os organiza de forma **prioritária**. O objetivo é garantir que situações críticas sejam atendidas antes de casos menos urgentes, mesmo que tenham chegado depois.

### Exemplo real:
- Um paciente com **parada cardíaca** deve ser atendido antes de alguém que relatou **barulho no vizinho**, mesmo que o segundo tenha ligado antes.

---

## ⚙️ Como a Fila com Prioridade foi Utilizada

A estrutura central do projeto é baseada em uma **PriorityQueue**, da biblioteca padrão do Java.

### 🔁 Funcionamento:
- Chamados são inseridos na fila com base no **nível de prioridade** (de 1 a 5).
- Quanto **menor o número**, **maior a urgência**.
- A fila é **reordenada automaticamente** a cada inserção, garantindo que o próximo atendimento seja sempre o mais urgente.

### 🔎 Exemplo de Prioridades:
| Prioridade | Descrição |
|------------|-----------|
| 1 | Parada Cardíaca / Incêndio |
| 2 | Acidente com feridos |
| 3 | Brigas / Agressão |
| 4 | Furto simples |
| 5 | Barulho, perturbação |

---

## 🧱 Justificativa da Estrutura Adotada

### 📁 Pacotes utilizados:
```
br.com.centralemergencia/
├── model/
│   ├── Chamado.java           → Representa o chamado de emergência
│   └── Prioridade.java        → Enum que define os níveis de urgência
├── service/
│   └── FilaAtendimento.java   → Gerencia a fila com prioridade
└── Main.java                  → Interface em terminal para o usuário
```

### ✅ Motivos para essa organização:
- **Separação de responsabilidades**: cada pacote tem um propósito específico.
- **Facilidade de manutenção**: alterações futuras serão localizadas e fáceis de gerenciar.
- **Boa prática de engenharia de software**: organização modular é padrão na indústria.

---

## 🖥️ Interface

O sistema é operado via **terminal**, utilizando menus interativos com entrada de dados por teclado.  
O menu permite:

1. Registrar novos chamados  
2. Visualizar a fila atual  
3. Atender chamados  
4. Encerrar o sistema

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**  
- **Maven** para gerenciamento do projeto  
- **IntelliJ IDEA** como IDE  
- **GitHub** para versionamento e colaboração

---

## 🧪 Testes Manuais Realizados

- Chamados com diferentes prioridades foram inseridos em ordem aleatória.
- A fila organizou corretamente as prioridades.
- O sistema atendeu os chamados mais urgentes primeiro.
- Interface respondeu bem a entradas inválidas e vazias.

---

## 🏁 Conclusão

Este projeto demonstra, de forma clara e prática, como o conceito de **fila com prioridade** pode ser aplicado em um contexto realista e de impacto social. A solução foi implementada com boas práticas de programação, estrutura modular e foco na clareza da lógica de atendimento.

---

> Criado com honra por Felipe Cézar  
> Unifametro — 2025  
> APS: Tópicos Especiais / Estrutura de Dados
