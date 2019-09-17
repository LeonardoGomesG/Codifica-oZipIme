/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codification;

/**
 *
 * @author Leonardo
 */
public class HuffmanNode implements Comparable<HuffmanNode> {
    int frequency; 
    char data; 
  
    HuffmanNode left; 
    HuffmanNode right;

    public int compareTo(HuffmanNode node){
        return frequency - node.frequency;
    }
}
