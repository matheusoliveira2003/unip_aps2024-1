package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CSVUtil {

    public static void exportarPassageirosParaCSV(List<Passageiro> passageiros) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione o diretório para salvar o arquivo CSV");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo CSV", "csv"));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int resultado = fileChooser.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            String caminho = fileChooser.getSelectedFile().getAbsolutePath() + "/passageiros.csv";
            try (FileWriter writer = new FileWriter(caminho)) {
                writer.append("nome,sobrenome,rg,passaporte\n");
                for (Passageiro passageiro : passageiros) {
                    writer.append(passageiro.getNome()).append(",")
                            .append(passageiro.getSobrenome()).append(",")
                            .append(passageiro.getRg()).append(",")
                            .append(passageiro.getPassaporte()).append("\n");
                }
                JOptionPane.showMessageDialog(null, "Arquivo CSV exportado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao exportar arquivo CSV: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void exportarViagensParaCSV(List<Viagem> viagens) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione o diretório para salvar o arquivo CSV");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo CSV", "csv"));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int resultado = fileChooser.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            String caminho = fileChooser.getSelectedFile().getAbsolutePath() + "/viagens.csv";
            try (FileWriter writer = new FileWriter(caminho)) {
                writer.append("voo,dataDePartida,dataDeRetorno,destino,passageiros\n");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                for (Viagem viagem : viagens) {
                    writer.append(viagem.getVoo()).append(",")
                            .append(sdf.format(viagem.getDataDePartida())).append(",")
                            .append(sdf.format(viagem.getDataDeRetorno())).append(",")
                            .append(viagem.getDestino()).append(",")
                            .append(viagem.getPassageirosRGs()).append("\n");
                }
                JOptionPane.showMessageDialog(null, "Arquivo CSV exportado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao exportar arquivo CSV: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
