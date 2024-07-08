package fontes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número total de cavalos: ");
        int numeroCavalos = scanner.nextInt();

        List<Corrida> corridas = new ArrayList<>();

        for (int i = 0; i < numeroCavalos; i++) {
            int numeroCavalo = i + 1;

            System.out.print("Digite o nome do apostador do cavalo " + (numeroCavalo) + ": ");
            String apostador = scanner.next();

            corridas.add(new Corrida(apostador, numeroCavalo, 10 + i, 10));
        }

        scanner.close();

        System.out.println("Iniciando a corrida...\n");

        for (Corrida corrida : corridas) {
            corrida.start();
        }

        for (Corrida corrida : corridas) {
            try {
                corrida.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n\nCorrida finalizada!\n");

        Corrida vencedor = null;
        long menorTempo = Long.MAX_VALUE;
        for (Corrida corrida : corridas) {
            long tempoCorrida = corrida.getTempoExecucao();
            if (tempoCorrida < menorTempo) {
                menorTempo = tempoCorrida;
                vencedor = corrida;
            }
        }

        System.out.println("O vencedor é: " + vencedor.getApostador() + " com o cavalo " + vencedor.getNumeroCavalo());
    }
}
