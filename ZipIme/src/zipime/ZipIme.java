/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipime;


import Codification.Cesar;
import static Codification.Huffman.codHuffman;
import static Codification.Huffman.decodHuffma;
//import static Codification.Huffman.codHuffman;
import Codification.HuffmanNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author Leonardo
 */
public class ZipIme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Character, Integer> freq = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.printf("Shift da Codificação Cesar: ");
        n = scan.nextInt();
        scan.nextLine();
        System.out.printf("\nNome do Arquivo a ser codificado(sem a extensão .txt): ");
        String nome = scan.nextLine();
        Cesar c = new Cesar();
        c.codCesar(n,nome);
        codHuffman(nome);
        decodHuffma(freq,nome);
        c.decodCesar(n,nome);
        
        
    }
//        Scanner ler = new Scanner(System.in);
//        System.out.printf("Informe o nome do arquivo .txt a ser codificado: ");
//        String nome = ler.nextLine();
//        nome=nome+".txt";
//        System.out.printf("Conteúdo inicial do arquivo:\n");
//      try {
//      FileReader arq = new FileReader(nome);
//      BufferedReader lerArq = new BufferedReader(arq);
// 
//      String linha = lerArq.readLine(); // lê a primeira linha
//// a variável "linha" recebe o valor "null" quando o processo
//// de repetição atingir o final do arquivo texto
//      while (linha != null) {
//        System.out.printf("%s\n", linha);
// 
//        linha = lerArq.readLine(); // lê da segunda até a última linha
//      }
// 
//      arq.close();
//    } catch (IOException e) {
//        System.err.printf("Erro na abertura do arquivo: %s.\n",
//          e.getMessage());
//    }
//        
//        
//    }

    private static void decodHuffman(HuffmanNode tree, String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
