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
import java.util.Scanner;

/**
 *
 * @author Leonardo
 */
public class Cesar{
    
    public void codCesar(int n, String nome){
        String nomeW=nome+"_codCesar.txt";
        n=n%26;
        Scanner ler = new Scanner(System.in);
        nome=nome+".txt";
        System.out.printf("Conteúdo Codificado em Cesar:\n");
        try {
          FileReader arq = new FileReader(nome);
          BufferedReader lerArq = new BufferedReader(arq);
          
          BufferedWriter arqW = new BufferedWriter(new FileWriter(nomeW));
          String linha = lerArq.readLine(); // lê a primeira linha
    // a variável "linha" recebe o valor "null" quando o processo
    // de repetição atingir o final do arquivo texto
          StringBuilder linhaW = new StringBuilder();
          char c;
          while (linha != null) {        
            for(int i=0;i<linha.length();i++){  
              if(linha.charAt(i)>='a' && linha.charAt(i)<='z'){
                  linhaW=linhaW.append((char)((( (int)(linha.charAt(i)-'a')+ n)%26)+(int)('a')));
              }
              else if(linha.charAt(i)>='A' && linha.charAt(i)<='Z'){
                  linhaW=linhaW.append((char)((( (int)(linha.charAt(i)-'A')+ n)%26)+(int)('A')));
              }
              else linhaW=linhaW.append(linha.charAt(i));
            }
            System.out.printf("%s\n", linhaW);
            arqW.append(linhaW + "\n");
            linha = lerArq.readLine(); // lê da segunda até a última linha
            linhaW = new StringBuilder();
          }
          arqW.close();
          arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
              e.getMessage());
        }
    }
    
    public void decodCesar(int n,String nome){
        n=n%26;
        n=26-n;
        String nomeW=nome+"_decodCesar.txt";
        Scanner ler = new Scanner(System.in);
        nome=nome+"_decodHuffman.txt";
        System.out.printf("Conteúdo decodificado final do arquivo:\n");
        try {
          FileReader arq = new FileReader(nome);
          BufferedReader lerArq = new BufferedReader(arq);

          BufferedWriter arqW = new BufferedWriter(new FileWriter(nomeW));
          String linha = lerArq.readLine(); // lê a primeira linha
    // a variável "linha" recebe o valor "null" quando o processo
    // de repetição atingir o final do arquivo texto
          StringBuilder linhaW = new StringBuilder();
          char c;
          while (linha != null) {        
            for(int i=0;i<linha.length();i++){  
              if(linha.charAt(i)>='a' && linha.charAt(i)<='z'){
                  linhaW=linhaW.append( (char)((( (int)(linha.charAt(i)-'a')+ n)%26)+(int)('a')));
              }
              else if(linha.charAt(i)>='A' && linha.charAt(i)<='Z'){
                  linhaW=linhaW.append((char)((( (int)(linha.charAt(i)-'A')+ n)%26)+(int)('A')));
              }
              else linhaW=linhaW.append(linha.charAt(i));
            }
            System.out.printf("%s\n", linhaW.toString());
            arqW.append(linhaW + "\n");
            linha = lerArq.readLine(); // lê da segunda até a última linha
            linhaW = new StringBuilder();
          }
          arqW.close();
          arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
              e.getMessage());
        }
    }
}
    
