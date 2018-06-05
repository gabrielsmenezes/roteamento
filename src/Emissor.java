
import java.io.ByteArrayOutputStream;
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
public class Emissor {

    public static void main(String[] args) {
        try {
            InetAddress ipDefault = InetAddress.getByName(args[0]);
            int portaDefault = Integer.parseInt(args[1]);
            InetAddress ipOrigem = InetAddress.getByName(args[2]);
            InetAddress ipDestino = InetAddress.getByName(args[3]);
            String dados = args[4];
            PacoteIP pacote = criaPacote(ipDestino, ipOrigem, dados);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PacoteIP criaPacote(InetAddress ipDestino, InetAddress ipOrigem, Object dados) {
        PacoteIP pacote = new PacoteIP();
        pacote.setIpDestino(ipDestino);
        pacote.setIpOrigem(ipOrigem);
        pacote.setDados(dados);
        return pacote;
    }

    public static void enviaPacote(PacoteIP pacote, InetAddress ipDefault, int porta) {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(b);
            o.flush();
            o.writeObject(pacote);
            DatagramPacket pacoteUDP = new DatagramPacket(b.toByteArray(), b.toByteArray().length, ipDefault, porta);
            DatagramSocket socket = new DatagramSocket();
            socket.send(pacoteUDP);
            socket.close();
            pacoteUDP = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
