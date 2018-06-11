
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

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

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
//        System.out.println(Roteador.converteMascaraParaBinario("0.0.0.0"));
//Object[][] tabelaRoteamento = Roteador.criaTabelaRoteamento("12345 1.0.0.0/8/127.0.0.1/1112 1.2.0.0/16/2.4.6.9/1112 1.2.3.0/24/1.2.3.1/1113".split(" "));
//    for(int linha = 0; linha < tabelaRoteamento.length; linha++){
//        for(int coluna = 0; coluna < 4; coluna++){
//            System.out.print(tabelaRoteamento[linha][coluna] + " ");
//        }
//        System.out.println();
//    }
//        
        args = new String[5];
        args[0] = "000";
        args[1] = "192.168.1.0/255.255.255.0/0.0.0.0/2554";
        args[2] = "192.168.2.0/255.255.255.0/0.0.0.0/2553";
        args[3] = "192.168.3.0/255.255.255.0/255.255.255.1/2552";
        args[4] = "0.0.0.0/255.255.255.0/255.255.255.1/2553";
        
        PacoteIP pacote = new PacoteIP();
        pacote.setIpDestino(InetAddress.getByName("192.168.1.1"));
        pacote.setIpOrigem(InetAddress.getLocalHost());
        pacote.setDados("Palmeiras ganhou do Gremio em Porto Alegre por 2 a 0");
//        Roteador.roteamentoDireto(pacote);
//System.out.println(    Roteador.converteIpParaBinario("255.255.255.0") );
//    System.out.println( Roteador.extraiRede("10000000111111110000000100000001", Roteador.converteMascaraParaBinario("255.255.255.0")));

    Object[][] tabela = Roteador.criaTabelaRoteamento(args);
    System.out.println ( (String)  tabela[Roteador.descobreProximoRoteador(tabela, pacote)][3] );

    }

}
