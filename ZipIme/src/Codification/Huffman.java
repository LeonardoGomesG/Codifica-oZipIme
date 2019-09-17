/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Leonardo
 */
public class Huffman{
    
	private static Map<Character, String> charPrefixHashMap = new HashMap<>();
	static HuffmanNode root;
        
	public static HuffmanNode buildTree(Map<Character, Integer> freq) {

		PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
		Set<Character> keySet = freq.keySet();
		for (Character c : keySet) {

			HuffmanNode huffmanNode = new HuffmanNode();
			huffmanNode.data = c;
			huffmanNode.frequency = freq.get(c);
			huffmanNode.left = null;
			huffmanNode.right = null;
			priorityQueue.offer(huffmanNode);
		}
		assert priorityQueue.size() > 0;

		while (priorityQueue.size() > 1) {

			HuffmanNode x = priorityQueue.peek();
			priorityQueue.poll();

			HuffmanNode y = priorityQueue.peek();
			priorityQueue.poll();

			HuffmanNode sum = new HuffmanNode();

			sum.frequency = x.frequency + y.frequency;
			sum.data = '-';

			sum.left = x;

			sum.right = y;
			root = sum;

			priorityQueue.offer(sum);
		}

		return priorityQueue.poll();
	}


	private static void setPrefixCodes(HuffmanNode node, StringBuilder prefix) {

		if (node != null) {
			if (node.left == null && node.right == null) {
				charPrefixHashMap.put(node.data, prefix.toString());

			} else {
				prefix.append('0');
				setPrefixCodes(node.left, prefix);
				prefix.deleteCharAt(prefix.length() - 1);

				prefix.append('1');
				setPrefixCodes(node.right, prefix);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		}

	}

	public static Map<Character, Integer> codHuffman(String nome) { //retorna a arvore
		Map<Character, Integer> freq = new HashMap<>();
               
                String nomeW=nome+"_codHuffman.txt";
                Scanner ler = new Scanner(System.in);
                nome=nome+"_codCesar.txt";
                System.out.printf("\nCodificação de Huffman\n");
                StringBuilder texto = new StringBuilder();
                try {
                  FileReader arq = new FileReader(nome);
                  BufferedReader lerArq = new BufferedReader(arq);

                  String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
                 // char c;
                  while (linha != null) {        
                    texto.append(linha+"\n");
                   // System.out.printf("%s\n", linhaW.toString());
                   // arqW.append(linhaW + "\n");
                    linha = lerArq.readLine(); // lê da segunda até a última linha
                   // linhaW = new StringBuilder();
                  }
                 // arqW.close();
                  arq.close();
                } catch (IOException e) {
                    System.err.printf("Erro na abertura do arquivo: %s.\n",
                      e.getMessage());
                }
                
                String test = texto.toString();
                
		for (int i = 0; i < test.length(); i++) {
			if (!freq.containsKey(test.charAt(i))) {
				freq.put(test.charAt(i), 0);
			}
			freq.put(test.charAt(i), freq.get(test.charAt(i)) + 1);
		}

		System.out.println("Mapa de freqeuncia = " + freq);
		root = buildTree(freq);

		setPrefixCodes(root, new StringBuilder());
		System.out.println("\nMapa codificação de Huffman = " + charPrefixHashMap);
		StringBuilder s = new StringBuilder();

		for (int i = 0; i < test.length(); i++) {
			char c = test.charAt(i);
			s.append(charPrefixHashMap.get(c));
		}
                   
            try {
                 // FileReader arq = new FileReader(nome);
                 // BufferedReader lerArq = new BufferedReader(arq);
                  BufferedWriter arqW = new BufferedWriter(new FileWriter(nomeW));
                  StringBuilder linhaW = new StringBuilder();
          //        String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
                 // char c;
                        
                 //   texto.append(linha);
                   // System.out.printf("%s\n", linhaW.toString());
                    arqW.append(s.toString());
                  //  linha = lerArq.readLine(); // lê da segunda até a última linha
                   // linhaW = new StringBuilder();
         
                  arqW.close();
                 // arq.close();
                } catch (IOException e) {
                    System.err.printf("Erro na abertura do arquivo: %s.\n",
                      e.getMessage());
                }
           
            return freq;
	// return s.toString();
	}

        public static void decodHuffma( Map<Character, Integer> freq , String nome) {
             //   Scanner ler = new Scanner(System.in);
                String nomeW=nome+"_decodHuffman.txt";
                nome=nome+"_codHuffman.txt";
                System.out.printf("\nDecodificação de Huffman\n");
                StringBuilder s = new StringBuilder();
                try {
                  FileReader arq = new FileReader(nome);
                  BufferedReader lerArq = new BufferedReader(arq);

                  String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
                 // char c;
                          
                  s.append(linha);
                 // System.out.printf("%s\n", linhaW.toString());
                 // arqW.append(linhaW + "\n");
                 // linha = lerArq.readLine(); // lê da segunda até a última linha
                 // linhaW = new StringBuilder();
                 
                 // arqW.close();
                  arq.close();
                } catch (IOException e) {
                    System.err.printf("Erro na abertura do arquivo: %s.\n",
                      e.getMessage());
                }
		StringBuilder str = new StringBuilder();

		HuffmanNode temp = root;
		//System.out.println("Encoded: " + s);
		for (int i = 0; i < s.length(); i++) {
			int j = Integer.parseInt(String.valueOf(s.charAt(i)));

			if (j == 0) {
				temp = temp.left;
				if (temp.left == null && temp.right == null) {
                                        str.append(temp.data);
					temp = root;
				}
			}
			if (j == 1) {
				temp = temp.right;
				if (temp.left == null && temp.right == null) {
					str.append(temp.data);
					temp = root;
				}
			}
                }
                try {
                 // FileReader arq = new FileReader(nome);
                 // BufferedReader lerArq = new BufferedReader(arq);
                  BufferedWriter arqW = new BufferedWriter(new FileWriter(nomeW));
                  StringBuilder linhaW = new StringBuilder();
          //        String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
                 // char c;
                        
                 //   texto.append(linha);
                   // System.out.printf("%s\n", linhaW.toString());
                    arqW.append(str.toString());
                  //  linha = lerArq.readLine(); // lê da segunda até a última linha
                   // linhaW = new StringBuilder();
         
                  arqW.close();
                 // arq.close();
                } catch (IOException e) {
                    System.err.printf("Erro na abertura do arquivo: %s.\n",
                      e.getMessage());
                }
                
		System.out.println("\nTexto decodificado em huffman, ainda codificado em cesar:  " + str.toString());

	}
}   
