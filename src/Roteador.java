
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
            Object[][] tabelaRoteamento = criaTabelaRoteamento(args);
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

    public static Object[][] criaTabelaRoteamento(String[] args) {//testada e funcionando
        Object[][] tabelaRoteamento = null;
        try {
            tabelaRoteamento = new Object[args.length - 1][4];
            for (int i = 0; i < args.length - 1; i++) {
                String[] separar = args[i + 1].split("\\/");
                tabelaRoteamento[i][0] = InetAddress.getByName(separar[0]);
                if (ehNumeroPonto(separar[1])) {
                    tabelaRoteamento[i][1] = converteIpParaBinario(separar[1]);
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

    private static String converteMascaraParaBinarioCIDR(String string) throws Exception {
        if (string.length() == 3) {
            string = string.substring(1, 2);
        }
        String binario = "";
        int numero = Integer.parseInt(string);
        if(numero > 32 || numero < 0) throw new Exception("O valor da mascara deve ser entre 0 e 32");
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
    public static int descobreProximoRoteador(Object[][] tabelaRoteamento, PacoteIP pacote){
        String ipDestinoBinario = converteIpParaBinario( pacote.getIpDestino().getHostAddress() );
        String redeDestino;
        String redeTabela;
        int[] maiorMascara = new int[2];
        maiorMascara[0] = 0; // armazena o indice da maior mascara que deu match
        maiorMascara[1] = -1; // armazena o tamanho da mascara
        for(int i = 0; i < tabelaRoteamento.length;i++){
            redeDestino = extraiRede(ipDestinoBinario, (String) tabelaRoteamento[i][1]);
            InetAddress endereco = (InetAddress) tabelaRoteamento[i][0];
            redeTabela = endereco.getHostAddress();
            redeTabela = converteIpParaBinario(redeTabela);
            redeTabela = extraiRede(redeTabela, (String) tabelaRoteamento[i][1]);
            if(redeDestino.equals(redeTabela) && maiorMascara[1] < extraiRede((String) tabelaRoteamento[i][1], (String) tabelaRoteamento[i][1]).length()){
                maiorMascara[0] = i;
                maiorMascara[1] = extraiRede((String) tabelaRoteamento[i][1], (String) tabelaRoteamento[i][1]).length();
            } 
        }
        
        if (maiorMascara[1] == -1) // entao tem que ir pela rota default
            return tabelaRoteamento.length - 1;
        return maiorMascara[1];
    }
    public static String extraiRede(String ip, String mascara){ /// testada e funcionando
        String saida = "";
        for(int i = 0; mascara.charAt(i) != '0' && i < 32 ;i++){
            saida = saida + ip.charAt(i);
        }
        return saida;
    }
    
    
    
    public static String converteIpParaBinario(String iP) {// testada e funcionando
        String[] ip = iP.split("\\.");
        String novaIp = "";
        for (int j = 0; j < ip.length; j++) {
            Integer inteiro = new Integer((ip[j]));
            String meio = Integer.toBinaryString(inteiro);
            while(meio.length() != 8)
                meio = "0" + meio;
            
            novaIp = novaIp + meio;
        }
        return novaIp;
    }// testada e funcionando
    
    
}// fim class
