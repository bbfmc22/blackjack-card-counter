import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class ContadorBlackjackUI extends JFrame {
    private Baralho baralho;
    private JTextArea logArea;
    private JTextField cartaInput;
    private JLabel contadorLabel;
    private JLabel percentagensLabel;
    private JLabel cartaImagemLabel; // Para mostrar a imagem da carta

    public ContadorBlackjackUI() {
        super("Contador de Blackjack com Imagens");

        // Perguntar numero de baralhos
        String input = JOptionPane.showInputDialog(this, "Com quantos baralhos quer jogar?", "Numero de baralhos", JOptionPane.QUESTION_MESSAGE);
        int numBaralhos = 1;
        try {
            numBaralhos = Integer.parseInt(input);
            if (numBaralhos < 1) numBaralhos = 1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Entrada invalida! Usando 1 baralho.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

        baralho = new Baralho(numBaralhos);

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout(10,10));

        cartaInput = new JTextField();
        cartaInput.addActionListener(e -> removerCarta());
        add(cartaInput, BorderLayout.NORTH);

        logArea = new JTextArea(10, 30);
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane, BorderLayout.CENTER);

        // Label para mostrar a imagem da carta removida
        cartaImagemLabel = new JLabel();
        cartaImagemLabel.setHorizontalAlignment(JLabel.CENTER);
        cartaImagemLabel.setPreferredSize(new Dimension(150, 220));
        add(cartaImagemLabel, BorderLayout.WEST);

// Painel inferior com contador e percentagens
        JPanel bottomPanel = new JPanel(new GridLayout(2,1));
        contadorLabel = new JLabel("Cartas restantes: " + baralho.getCartasDisponiveis());
        contadorLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Aumenta o tamanho do texto aqui

        percentagensLabel = new JLabel("Probabilidades: calculando...");
        percentagensLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Aumenta o tamanho do texto aqui

        bottomPanel.add(contadorLabel);
        bottomPanel.add(percentagensLabel);
        add(bottomPanel, BorderLayout.SOUTH);


        JButton removerBtn = new JButton("Remover Carta");
        removerBtn.addActionListener(e -> removerCarta());
        add(removerBtn, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        atualizarPercentagens();
    }

    private void removerCarta() {
        String entrada = cartaInput.getText().trim().toUpperCase();
        if (entrada.isEmpty()) return;

        String nomeMapeado = mapearEntradaParaCarta(entrada);

        boolean sucesso = baralho.removerCarta(nomeMapeado);
        if (sucesso) {
            logArea.append("Carta removida: " + nomeMapeado + "\n");
            mostrarImagemCarta(nomeMapeado);
        } else {
            logArea.append("Carta invalida ou esgotada: " + entrada + "\n");
            cartaImagemLabel.setIcon(null);
        }

        contadorLabel.setText("Cartas restantes: " + baralho.getCartasDisponiveis());
        atualizarPercentagens();

        cartaInput.setText("");
        cartaInput.requestFocus();
    }

    private void mostrarImagemCarta(String nomeCarta) {
        // Aqui tens de criar a logica para mapear o nome da carta para o ficheiro da imagem

        // Exemplo muito simples para as cartas de clubs (podes adaptar para todos os naipes)
        // Supomos que as imagens estao em "PNG-cards-1.3/" dentro do classpath ou em disco
        String nomeArquivo = null;
        switch (nomeCarta) {
            case "DOIS": nomeArquivo = "2_of_clubs.png"; break;
            case "TRES": nomeArquivo = "3_of_clubs.png"; break;
            case "QUATRO": nomeArquivo = "4_of_clubs.png"; break;
            case "CINCO": nomeArquivo = "5_of_clubs.png"; break;
            case "SEIS": nomeArquivo = "6_of_clubs.png"; break;
            case "SETE": nomeArquivo = "7_of_clubs.png"; break;
            case "OITO": nomeArquivo = "8_of_clubs.png"; break;
            case "NOVE": nomeArquivo = "9_of_clubs.png"; break;
            case "DEZ": nomeArquivo = "10_of_clubs.png"; break;
            case "VALETE": nomeArquivo = "jack_of_clubs2.png"; break;
            case "DAMA": nomeArquivo = "queen_of_clubs2.png"; break;
            case "REI": nomeArquivo = "king_of_clubs2.png"; break;
            case "AS": nomeArquivo = "ace_of_clubs.png"; break;
            default: nomeArquivo = null; break;
        }

        if (nomeArquivo != null) {
            ImageIcon icon = new ImageIcon("PNG-cards-1.3/" + nomeArquivo);
            // Redimensionar imagem para caber no label
            Image img = icon.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH);
            cartaImagemLabel.setIcon(new ImageIcon(img));
        } else {
            cartaImagemLabel.setIcon(null);
        }
    }

    private void atualizarPercentagens() {
        Map<String, Double> pct = baralho.calcularPercentagens();
        percentagensLabel.setText(String.format(
                "Probabilidades: <7: %.2f%% | 7-9: %.2f%% | >=10: %.2f%%",
                pct.getOrDefault("menorQueSete", 0.0),
                pct.getOrDefault("entreSeteENove", 0.0),
                pct.getOrDefault("dezEAces", 0.0)
        ));
    }

    private String mapearEntradaParaCarta(String entrada) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ContadorBlackjackUI());
    }
}
