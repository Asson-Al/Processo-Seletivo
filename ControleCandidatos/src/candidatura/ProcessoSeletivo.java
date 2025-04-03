package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = {"MARIA", "JOAO", "CLEBER", "THAIS", "TAYLER"};

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);

        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        } while (continuarTentando && tentativasRealizadas < 3);
        if (atendeu) {
            System.out.println("CONSEGUIMOS CCONTATO COM O CANDIDATO " + candidato+" NA "+tentativasRealizadas+" Tentativa");
        } else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato+" NUMERO MAXIMO DE TENTATVIAS "+tentativasRealizadas+" REALIZADAS");

    }

    //metodo auxiliar
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }


    static void imprimirSelecionados() {
        String[] candidatos = {"MARIA", "JOAO", "CLEBER", "THAIS", "TAYLER"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento.");
        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de n° " + (indice + 1) + " é o " + candidatos[indice]);
        }
        //Forma abreviada de interação for each.
        for (String candidato : candidatos) {
            System.out.println("O candidato de Selecionado foi " + candidato);
        }
    }

    static void selecaoCamdidatos() {
        String[] candidatos = {"MARIA", "JOAO", "CLEBER", "THAIS", "TAYLER", "BRUNA", "TEREZA", "JOANA", "TATIANE", "PRICILA", "LUCAS", "LEONARDO", "LUAN"};

        int candidatosSelecionados = 0;
        int cadidatosAtual = 0;
        double salarioBase = 2000.00;
        while (candidatosSelecionados < 5 && cadidatosAtual < candidatos.length) {
            String candidato = candidatos[cadidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salario " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " Foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            cadidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analizarCandidato(double salarioPretendido) {
        double salarioBase = 2000.00;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA CANDIDATO.");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA CANDIDATO COM A CONTRA PROPOSTA.");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS.");
        }
    }

}
