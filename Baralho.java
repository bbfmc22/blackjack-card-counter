import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;


public class Baralho {
    public List<Carta> cartas = new ArrayList<>();
    private Map<String, Integer> contagemValores = new HashMap<>();

    public Baralho(int n_decks) {
        inicializarBaralho(n_decks);
    }

    private void inicializarBaralho(int n_decks) {
        for (int i = 0; i < n_decks; i++) {
            for (int naipe = 0; naipe < 4; naipe++) {
                for (Carta carta : Carta.values()) {
                    cartas.add(carta);
                    contagemValores.put(carta.name(), contagemValores.getOrDefault(carta.name(), 0) + 1);
                }
            }
        }
    }

    public int getCartasDisponiveis() {
        return cartas.size();
    }

    public void imprimirContagemValores() {
        for (Entry<String, Integer> entrada : contagemValores.entrySet()) {
            System.out.println("Valor " + entrada.getKey() + ": " + entrada.getValue() + " cartas restantes");
        }
    }

    public boolean removerCarta(String nomeCarta) {
        Iterator<Carta> iterator = cartas.iterator();
        while (iterator.hasNext()) {
            Carta carta = iterator.next();
            if (carta.name().equalsIgnoreCase(nomeCarta) && contagemValores.get(nomeCarta) > 0) {
                iterator.remove();
                contagemValores.put(nomeCarta, contagemValores.get(nomeCarta) - 1);
                return true;
            }
        }
        System.out.println("Carta n o dispon vel ou inv lida.");
        return false;
    }

    public Map<String, Double> calcularPercentagens() {
        int totalCartas = getCartasDisponiveis();
        int menorQueSete = 0;
        int entreSeteENove = 0;
        int dezEAces = 0;

        for (Carta carta : cartas) {
            int valor = carta.getValor();
            if (valor < 7) {
                menorQueSete++;
            } else if (valor >= 7 && valor <= 9) {
                entreSeteENove++;
            } else {
                dezEAces++;
            }
        }

        Map<String, Double> percentagens = new HashMap<>();
        percentagens.put("menorQueSete", 100.0 * menorQueSete / totalCartas);
        percentagens.put("entreSeteENove", 100.0 * entreSeteENove / totalCartas);
        percentagens.put("dezEAces", 100.0 * dezEAces / totalCartas);

        return percentagens;
    }

    public int getValorCarta(String nomeCarta) {
        String nomeMapeado = mapearEntradaParaCarta(nomeCarta);
        for (Carta carta : Carta.values()) {
            if (carta.name().equalsIgnoreCase(nomeMapeado)) {
                return carta.getValor();
            }
        }
        return 0;
    }

    String mapearEntradaParaCarta(String entrada) {
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
