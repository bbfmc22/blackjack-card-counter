import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        iniciarJogo();
    }

    private static void iniciarJogo() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Para o algoritmo funcionar deve comecar este programa e pedir ao dealer para recomecar o deck, e perguntar com quantos decks vai jogar!\nBoa sorte!");
            System.out.print("Com quantos decks vai jogar? ");
            int n_decks = sc.nextInt();
            sc.nextLine();

            Baralho baralho = new Baralho(n_decks);

            boolean continuar = true;
            while (continuar && baralho.getCartasDisponiveis() > 0) {
                System.out.println("Digite 'SHOW' para exibir a contagem de cartas, 'PLAY' para jogar, 'FIM' para terminar ou 'NOVO JOGO' para comecar de novo:");
                String operacao = sc.nextLine().toUpperCase();

                switch (operacao) {
                    case "SHOW":
                        baralho.imprimirContagemValores();
                        break;
                    case "PLAY":
                        jogarRodada(sc, baralho);
                        break;
                    case "FIM":
                        continuar = false;
                        break;
                    case "NOVO JOGO":
                        iniciarJogo();
                        return;
                    default:
                        System.out.println("Operacao desconhecida: " + operacao);
                        break;
                }
            }
        }
    }

    private static void jogarRodada(Scanner sc, Baralho baralho) {
        boolean pedindoJogador = true;
        while (baralho.getCartasDisponiveis() > 0) {
            String quem = pedindoJogador ? "jogador" : "dealer";
            String resposta = pedirCarta(quem, sc, baralho);

            if (resposta.equals("FIM")) {
                break;
        }
    }
    }

    private static String pedirCarta(String quem, Scanner sc, Baralho baralho) {
        String carta;
        while (true) {
            Map<String, Double> porcentagens = baralho.calcularPercentagens();
            System.out.printf("Percentagens <7: %.2f%%, 7-9: %.2f%%, >=10: %.2f%%\n", porcentagens.get("menorQueSete"), porcentagens.get("entreSeteENove"), porcentagens.get("dezEAces"));
            System.out.println(""+ quem + ": ");
            carta = sc.nextLine().toUpperCase();
            String nomeCarta = mapearEntradaParaCarta(carta);

            if (carta.equals("FIM") || carta.equals("DEALER") || carta.equals("JOGADOR")) {
                return carta;
            } else if (nomeCarta != null && baralho.removerCarta(nomeCarta)) {
                break;
            } else {
                System.out.println("Entrada invalida ou carta nao disponivel. Tente novamente.");
            }
        }
        return carta;
    }

    private static String mapearEntradaParaCarta(String entrada) {
        switch (entrada) {
            case "2": return "DOIS";
            case "3": return "TRES";
            case "4": return "QUATRO";
            case "5": return "CINCO";
            case "6": return "SEIS";
            case "7": return "SETE";
            case "8": return "OITO";
            case "9": return "NOVE";
            case "10": return "DEZ";
            case "J": return "VALETE";
            case "Q": return "DAMA";
            case "K": return "REI";
            case "A": return "AS";
            default: return entrada;
        }
    }
}
