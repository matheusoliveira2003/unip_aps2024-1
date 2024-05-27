package classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Viagem {
    private String voo;
    private Date dataDePartida;
    private Date dataDeRetorno;
    private String destino;
    private List<Passageiro> passageiros;

    public Viagem(String voo, Date dataDePartida, Date dataDeRetorno, String destino, List<Passageiro> passageiros) {
        this.voo = voo;
        this.dataDePartida = dataDePartida;
        this.dataDeRetorno = dataDeRetorno;
        this.destino = destino;
        this.passageiros = passageiros;
    }

    public String getVoo() {
        return voo;
    }

    public Date getDataDePartida() {
        return dataDePartida;
    }

    public Date getDataDeRetorno() {
        return dataDeRetorno;
    }

    public String getDestino() {
        return destino;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public String getPassageirosRGs() {
        return passageiros.stream()
                .map(Passageiro::getRg)
                .collect(Collectors.joining(";"));
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Voo: " + voo + ", Data de Partida: " + sdf.format(dataDePartida) +
                ", Data de Retorno: " + sdf.format(dataDeRetorno) + ", Destino: " + destino +
                ", Passageiros: " + getPassageirosRGs();
    }
}
