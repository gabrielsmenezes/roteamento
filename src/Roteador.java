
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mrgab
 */
public class Roteador {

    public static void main(String[] args) {
        try {
            int porta = Integer.parseInt(args[0]);
            Object[] tabelaRoteamento = criaTabelaRoteamento(args);
            byte[] buffer = new byte[2048];
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
            DatagramSocket socket = new DatagramSocket(porta);
            while (true) {
                socket.receive(pacote);
                ByteArrayInputStream b = new ByteArrayInputStream(buffer);
                ObjectInputStream o = new ObjectInputStream(b);
                PacoteIP pacoteIP = (PacoteIP) o.readObject();
                decrementaTLL(pacoteIP);
                if (verificaTLL(pacoteIP)) {

                }// fim ife
                else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// fim main

    private static void decrementaTLL(PacoteIP pacoteIP) {
        short tll = (short) (pacoteIP.getTLL() - 1);
        pacoteIP.setTLL(tll);
    }

    private static boolean verificaTLL(PacoteIP pacoteIP) {
        return pacoteIP.getTLL() > 0;
    }

    public static String converteMascaraParaBinario(String separar) {
//        System.out.println(separar);
        String[] mascara = separar.split("\\.");
//        for(String i : mascara) System.out.println(i);
        String novaMascara = "";
        for (int j = 0; j < mascara.length; j++) {
            Integer inteiro = new Integer((mascara[j]));
//            System.out.println(inteiro);
            if(Integer.toBinaryString(inteiro).equals("0")){
//                System.out.println("Entroooooooooou");
                novaMascara = novaMascara + "00000000";
                continue;
            }
            novaMascara = novaMascara + Integer.toBinaryString(inteiro);
        }
        return novaMascara;
    }// testada e funcionando

    public static Object[][] criaTabelaRoteamento(String[] args) {//testada e funcionando
        Object[][] tabelaRoteamento = null;
        try {
            tabelaRoteamento = new Object[args.length - 1][4];
            for (int i = 0; i < args.length - 1; i++) {
                String[] separar = args[i + 1].split("\\/");
                tabelaRoteamento[i][0] = InetAddress.getByName(separar[0]);
                tabelaRoteamento[i][1] = converteMascaraParaBinario(separar[1]);
                tabelaRoteamento[i][2] = InetAddress.getByName(separar[2]);
                tabelaRoteamento[i][3] = separar[3];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tabelaRoteamento;
    }
}// fim class
