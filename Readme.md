
# Contador de Blackjack com Imagens

Projeto Java que implementa um contador de cartas para o jogo Blackjack, com interface gr�fica em Swing e tema escuro usando FlatLaf. Este programa permite gerir v�rios baralhos, remover cartas pelo nome, e mostra as probabilidades atualizadas das cartas restantes.

---

## Funcionalidades

- Escolha do n�mero de baralhos no in�cio.
- Interface gr�fica moderna com tema escuro.
- Remo��o de cartas digitando o seu nome (ex: "A", "10", "J") com a remo��o das cartas exibidas na interface para melhor experi�ncia visual.

---

## Pr�-requisitos

- Java JDK 17+ instalado.
- [FlatLaf 3.4](https://www.formdev.com/flatlaf/) - biblioteca para tema escuro (arquivo `flatlaf-3.4.jar` inclu�do).
- As imagens das cartas devem estar na pasta `PNG-cards-1.3` no mesmo diret�rio do execut�vel.

---

## Como executar

1. Clone ou fa�a download deste reposit�rio.

2. Certifique-se que tem o arquivo `flatlaf-3.4.jar` na pasta do projeto.

3. Compile o projeto (no terminal, dentro da pasta `src`):

   ```bash
   javac -cp flatlaf-3.4.jar @sources.txt
   ```

4. Execute a aplica��o com:

   ```bash
   java -cp .;flatlaf-3.4.jar ContadorBlackjackUI
   ```

5. Ou use o script `run.bat` para compilar e executar automaticamente.

---

## Estrutura de pastas

```
Casino/
?
??? src/                       # C�digo fonte Java e imagens
?   ??? ContadorBlackjackUI.java
?   ??? Baralho.java
?   ??? Carta.java
?   ??? PNG-cards-1.3/         # Pasta com imagens das cartas
?   ??? flatlaf-3.4.jar
?
??? run.bat                    # Script para compilar e executar o projeto
```

---

## Notas

- O nome das cartas deve ser digitado conforme o esperado: "2", "3", ..., "10", "J", "Q", "K", "A".
- O programa atualiza as probabilidades ap�s cada carta removida.
- Para melhorar a experi�ncia, use um terminal que suporte UTF-8 ou execute via interface gr�fica.

---

## Autor

bernaa22 � [github.com/teuusuario](https://github.com/teuusuario)

---

## Licen�a

Este projeto est� licenciado sob a licen�a MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
