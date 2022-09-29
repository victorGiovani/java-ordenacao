package prova1avestruturadedados;

import java.util.Random;
import java.util.Scanner;

/**
 * O Projeto foi realizado pela equipe:
 * 1 - Matrícula e Nome do Aluno 01
 * 2 - Matrícula e Nome do Aluno 02
 * 3 - Matrícula e Nome do Aluno 03
 * 
 * Turma: (2MA, 2MB, 2MC, 2MD, 2NA, 2NB ou 2NC)
 * Disciplina: Estrutura de Dados
 * Professor: José Mário Souza
 */
public class Prova1AVEstruturaDeDados {
    public static void main(String[] args) {
        int vet[] = new int[20];
        int vetAux[] = new int[vet.length];
        Random aleatorio = new Random();
        for (int i = 0; i < vet.length; i++) {
            vet[i] = aleatorio.nextInt(1000);
        }
        System.out.println("### Lista Desordenada ###");
        for (int val : vet) {
            System.out.print(val + "-");
        }
        System.out.println("");
        Scanner leia = new Scanner(System.in);
        int opc = 0;
        while (opc != 4) {
            System.out.println("");
            System.out.println("# Vamos Ordenar? #");
            System.out.println("1 - Por Troca");
            System.out.println("2 - Por Selação");
            System.out.println("3 - Por Inserção");
            System.out.println("4 - Sair");
            System.out.println("");
            System.out.print("Informe a opção desejada: ");
            opc = leia.nextInt();
            switch (opc) {
                case 1:
                    vetAux = vet;
                    ordenarPorTroca(vetAux);
                    break;
                case 2:
                    vetAux = vet;
                    ordenarPorSelecao(vetAux);
                    break;
                case 3:
                    vetAux = vet;
                    ordenarPorInsercao(vetAux);
                    break;
                case 4:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void ordenarPorTroca(int vetAux[]) {
        int tro = 0; // Variável para contar a quantidade de Trocas desse método
        int com = 0; // Variável para contar a quantidade de Comparações desse método
        System.out.println("### Ordenação por Troca ###");
        int index = 1;
        boolean controle;

        for (int i = 0; i < vetAux.length; ++i) {
            controle = true;
            for (int j = 0; j < (vetAux.length - 1); ++j) {
                if (vetAux[j] > vetAux[j + 1]) {
                    index = vetAux[j];
                    vetAux[j] = vetAux[j + 1];
                    vetAux[j + 1] = index;
                    controle = false;
                    tro++;
                }
                com++;
            }
            if (controle) {
                break;
            }
        }
        listarComplexiade(tro, com);
        listarVetorOrdenado(vetAux);
    }

    private static int buscaMaior(int vetAux[]) {
        int maior = 0;
        int indexMaior = 0;
        for(int index = 0; index < vetAux.length; ++index) {
            if(vetAux[index] != 1000000000 && vetAux[index] > maior) {
                maior = vetAux[index];
                indexMaior = index;
            }
        }
        return indexMaior;
    }
    private static int buscaMenor(int vetAux[]) {
        int menor = vetAux[0];
        int indexMenor = 0;
        
        for(int index = 0; index < vetAux.length; ++index) {
            if(vetAux[index] != 1000000000 && vetAux[index] < menor) {
                menor = vetAux[index];
                indexMenor = index;
            }
        }
        return indexMenor;
    }

    private static void ordenarPorSelecao(int vetAux[]) {
        int tro = 0; // Variável para contar a quantidade de Trocas desse método
        int com = 0; // Variável para contar a quantidade de Comparações desse método
        int vetCopia[] = new int[vetAux.length];
        vetCopia = vetAux.clone();
        System.out.println("### Ordenação por Seleção ###");
                        // if((vetCopia.length / 2 ) % 2 == 0) {index < ( vetCopia.length / 2 )} else {index < ( vetCopia.length / 2 ) + 1}
        for(int index = 0; (vetCopia.length / 2 ) % 2 == 0 ? index < ( vetCopia.length / 2 ) : index < ( vetCopia.length / 2 ) + 1; ++index) {

            int maior = buscaMaior(vetCopia);
            int menor = buscaMenor(vetCopia);
            com++;

            int atual = vetCopia[maior];
            int prox = vetCopia[menor];

            vetCopia[maior] = 1000000000;
            vetCopia[menor] = 1000000000;

            vetAux[vetCopia.length -  index - 1 ] = atual;
            vetAux[index] = prox; 
            tro++;
        }
        
        listarComplexiade(tro, com);
        listarVetorOrdenado(vetAux);
    }

    private static void ordenarPorInsercao(int vetAux[]) {
        int tro = 0; // Variável para contar a quantidade de Trocas desse método
        int com = 0; // Variável para contar a quantidade de Comparações desse método
        System.out.println("### Ordenação por Inserção ###");
        // criar aqui a lógica da Ordenação por Inserção
        listarComplexiade(tro, com);
        listarVetorOrdenado(vetAux);
    }

    private static void listarVetorOrdenado(int vetAux[]) {
        System.out.println("### Lista Ordenada ###");
        for (int val : vetAux) {
            System.out.print(val + "-");
        }
        System.out.println("");
    }

    private static void listarComplexiade(int tro, int com) {
        System.out.println("### Complexidade ###");
        System.out.println("Comparações: " + com);
        System.out.println("Trocas: " + tro);
    }

}
