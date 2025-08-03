
# Contador de Blackjack com Imagens

Projeto Java que implementa um contador de cartas para o jogo Blackjack, com interface gráfica em Swing e tema escuro usando FlatLaf. Este programa permite gerir vários baralhos, remover cartas pelo nome, e mostra as probabilidades atualizadas das cartas restantes.

---

## Funcionalidades

- Escolha do número de baralhos no início.
- Interface gráfica moderna com tema escuro.
- Remoção de cartas digitando o seu nome (ex: "A", "10", "J") com a remoção das cartas exibidas na interface para melhor experiência visual.

---

![1](https://github.com/bbfmc22/blackjack-card-counter/blob/main/BJGUI.png)

## Pré-requisitos

- Java JDK 17+ instalado.
- [FlatLaf 3.4](https://www.formdev.com/flatlaf/) - biblioteca para tema escuro (arquivo `flatlaf-3.4.jar` incluído).
- As imagens das cartas devem estar na pasta `PNG-cards-1.3` no mesmo diretório do executável.

---

## Como executar

1. Clone ou faça download deste repositório.

2. Certifique-se que tem o arquivo `flatlaf-3.4.jar` na pasta do projeto.

3. Compile o projeto (no terminal, dentro da pasta `src`):

   ```bash
   javac -cp flatlaf-3.4.jar @sources.txt
   ```

4. Execute a aplicação com:

   ```bash
   java -cp .;flatlaf-3.4.jar ContadorBlackjackUI
   ```

5. Ou use o script `run.bat` para compilar e executar automaticamente.

---

## Estrutura de pastas

```
Casino/
|
||| src/                       # Código fonte Java e imagens
|   ||| ContadorBlackjackUI.java
|   ||| Baralho.java
|   ||| Carta.java
|   ||| PNG-cards-1.3/         # Pasta com imagens das cartas
|   ||| flatlaf-3.4.jar
|
||| run.bat                    # Script para compilar e executar o projeto
```

---

## Notas

- O nome das cartas deve ser digitado conforme o esperado: "2", "3", ..., "10", "J", "Q", "K", "A".
- O programa atualiza as probabilidades após cada carta removida.
- Para melhorar a experiência, use um terminal que suporte UTF-8 ou execute via interface gráfica.

---

## Autor

bernaa22 — [github.com/teuusuario](https://github.com/teuusuario)

