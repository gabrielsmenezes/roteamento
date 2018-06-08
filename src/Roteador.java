
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            if (Integer.toBinaryString(inteiro).equals("0")) {
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
                if (ehNumeroPonto(separar[1])) {
                    tabelaRoteamento[i][1] = converteMascaraParaBinario(separar[1]);
                } else {
                    tabelaRoteamento[i][1] = converteMascaraParaBinarioCIDR(separar[1]);
                }
                tabelaRoteamento[i][2] = InetAddress.getByName(separar[2]);
                tabelaRoteamento[i][3] = separar[3];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tabelaRoteamento;
    }

    private static boolean ehNumeroPonto(String string) {
        return string.contains(".");
    }

    private static String converteMascaraParaBinarioCIDR(String string) {
        if (string.length() == 3) {
            string = string.substring(1, 2);
        }
        String binario = "";
        int numero = Integer.parseInt(string);
        for (int i = 0; i < 32; i++) {
            if (numero-- > 0) {
                binario = binario + "1";
            } else {
                binario = binario + "0";
            }
        }
        return binario;
    }// fim converteMascaraParaBinarioCIDR

    public static void encaminha(InetAddress proxSalto, String interfaceDeSaida, PacoteIP pacote) {//testado e funcionando
        try {
            int porta = Integer.parseInt(interfaceDeSaida);
            System.out.println("Endereco de destino:" + pacote.getIpDestino() + " , proximo salto: " + proxSalto + " pela interface: " + interfaceDeSaida);
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(b);
            o.flush();
            o.writeObject(pacote);
            DatagramPacket pacoteUDP = new DatagramPacket(b.toByteArray(), b.toByteArray().length, proxSalto, porta);
            DatagramSocket socket = new DatagramSocket();
            socket.send(pacoteUDP);
            socket.close();
            pacoteUDP = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void roteamentoDireto(PacoteIP pacote){ // testada e funcionando
        System.out.println("O pacote chegou ao destino");
        System.out.println("A mensagem eh: " + pacote.getDados());
        System.out.println("IP destino: " + pacote.getIpDestino());
        System.out.println("IP origem: " + pacote.getIpOrigem());
    }
}// fim class
