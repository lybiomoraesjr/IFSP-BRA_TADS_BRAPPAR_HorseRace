package fontes;

public class Corrida extends Thread {
    private String apostador;
    private int numeroCavalo;
    private long tempoInicio;
    private long tempoFim;
    private int linha;
    private int coluna;

    public Corrida(String apostador, int numeroCavalo, int linha, int coluna) {
        this.apostador = apostador;
        this.numeroCavalo = numeroCavalo;
        this.linha = linha;
        this.coluna = coluna;
    }

    @Override
    public void run() {
        tempoInicio = System.currentTimeMillis();

        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep((long) (Math.random() * 100));
                System.out.printf("\033[%d;%dH %d", linha, coluna, numeroCavalo);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            coluna++;

        }

        tempoFim = System.currentTimeMillis();
    }

    public String getApostador() {
        return apostador;
    }

    public int getNumeroCavalo() {
        return numeroCavalo;
    }

    public long getTempoExecucao() {
        return tempoFim - tempoInicio;
    }
}
