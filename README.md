# ♟️ Chess System
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/rtrnonato/chess-system-java/blob/main/LICENSE)

---

## 📖 Sobre o Projeto

Este projeto é uma aplicação de console que simula um jogo de xadrez, incluindo regras oficiais, movimentos de peças e casos especiais como roque, promoção de peão e captura *en passant*.

- Implementação completa do tabuleiro de xadrez 8x8.
- Suporte a todas as peças do xadrez: Rei, Rainha, Bispo, Cavalo, Torre e Peão.
- Validação de movimentos legais de acordo com as regras do xadrez.
- Tratamento de movimentos especiais:
  - Roque (pequeno e grande).
  - Promoção de peão.
  - Captura *en passant*.
- Detecção de xeque e xeque-mate.
- Alteração de turnos entre jogadores.

---

## 📂 Estrutura do Projeto

O projeto está organizado em pacotes para facilitar a manutenção:

### Pacotes Principais

- **`application`**: Contém a classe principal que inicia o jogo e a interface de console.
  - `Program`: Classe principal com o método `main` para executar o jogo.
  - `UI`: Classe responsável por exibir o tabuleiro, peças, mensagens e interações no console.

- **`boardgame`**: Lógica genérica do tabuleiro e peças.
  - `Board`: Representa o tabuleiro do jogo.
  - `Piece`: Representa uma peça genérica no tabuleiro.
  - `Position`: Representa uma posição no tabuleiro.
  
- **`chess`**: Especificidades do jogo de xadrez.
  - `ChessMatch`: Controla o fluxo da partida.
  - `ChessPiece`: Representa uma peça de xadrez.
  - `ChessPosition`: Converte posições entre coordenadas do tabuleiro e notação do xadrez.
  - `Color`: Enumeração das cores (BRANCO e PRETO).

- **`chess.pieces`**: Classes específicas das peças de xadrez.
  - `King`, `Queen`, `Bishop`, `Knight`, `Rook`, `Pawn`.

![Mobile 1](https://github.com/rtrnonato/chess-system-java/blob/main/chess-system-design.png)

---

## 🔧 Tecnologias Utilizadas

- **Linguagem de Programação**: Java
- **Paradigma**: Orientação a Objetos
- **Ferramentas**:
  - **Java Development Kit (JDK)** 8 ou superior.
  - **IDE**: IntelliJ IDEA, Eclipse, ou outra.

---

## ▶️ Como Executar o Projeto

Siga os passos abaixo para compilar e executar o jogo de xadrez:

1. **Clone o repositório**  
   Utilize o comando abaixo para clonar o projeto em sua máquina local:
   ```bash
   git clone https://github.com/seu-usuario/projeto-xadrez.git

---

## 👤 Autor

Artur Nonato de Macedo

- 💼 **LinkedIn**: https://www.linkedin.com/in/arturnonato
- 📧 **E-mail**: rtrnonato@gmail.com
- 🌐 **GitHub**: https://github.com/rtrnonato
- 🕗 **WakaTime**: https://wakatime.com/@018bca24-1de0-4f19-91a5-3a111557f794
