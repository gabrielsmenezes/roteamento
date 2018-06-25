package test;


import java.util.Scanner;
import model.Roteador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mrgab
 */
public class TestadoraRoteador {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String[] argumentos;
        System.out.println("Digite quantos roteadores voce ira iniciar:");
        int numeroRoteadores = ler.nextInt();
        while (--numeroRoteadores >= 0) {
            System.out.println("Digite o numero de linhas da sua tabela de roteamento");
            int numeroDeLinhas = ler.nextInt();
            argumentos = new String[numeroDeLinhas + 1];
            System.out.println("Digite o numero da porta em que o roteador ira escutar");
            argumentos[0] = ler.next();
            ler = new Scanner(System.in);
            for (int i = 1; i <= numeroDeLinhas; i++) {
                System.out.println("Digite a linha correspondente a tabela de roteamento (rede-destino/mascara/gateway/interface) ");

                argumentos[i] = ler.next();
                ler = new Scanner(System.in);
            }// fim for
//            for (String a : argumentos) {
//                System.out.println(a);
//            }

            new Roteador(argumentos).start();

        }// fim while
//argumentos[0] = "1111";
//argumentos[1] = "10.0.0.0/255.0.0.0/0.0.0.0/0";
//argumentos[2] = "20.20.0.0/255.255.0.0/0.0.0.0/0";
//argumentos[3] = "30.1.2.0/255.255.255.0/127.0.0.1/2222";

//String[] argumentos = new String[5];
//argumentos[0] = "2222";
//argumentos[1] = "10.0.0.0/255.0.0.0/127.0.0.1/3333";
//argumentos[2] = "20.20.0.0/255.255.0.0/0.0.0.0/0";
//argumentos[3] = "0.0.0.0/0.0.0.0/127.0.0.1/3333";
//argumentos[4] ="30.1.2.0/255.255.255.0/0.0.0.0/0";
//String[] argumentos = new String[5];
//argumentos[0] = "3333";
//argumentos[1] = "10.0.0.0/255.0.0.0/127.0.0.1/2222";
//argumentos[2] = "20.20.0.0/255.255.0.0/127.0.0.1/2222";
//argumentos[3] = "30.1.2.0/255.255.255.0/0.0.0.0/0";
//argumentos[4] = "0.0.0.0/0.0.0.0/127.0.0.1/4444";
    }
}
