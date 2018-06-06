/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrgab
 */
public class Testadora {
    public static void main(String[] args){
//        System.out.println(Roteador.converteMascaraParaBinario("0.0.0.0"));
Object[][] tabelaRoteamento = Roteador.criaTabelaRoteamento("12345 1.0.0.0/255.0.0.0/127.0.0.1/1112 1.2.0.0/255.255.0.0/2.4.6.9/1112 1.2.3.0/255.255.255.0/1.2.3.1/1113".split(" "));
    for(int linha = 0; linha < tabelaRoteamento.length; linha++){
        for(int coluna = 0; coluna < 4; coluna++){
            System.out.print(tabelaRoteamento[linha][coluna] + " ");
        }
        System.out.println();
    }
    }
}
