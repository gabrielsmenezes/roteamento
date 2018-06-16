
import Model.Roteador;

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
    public static void main(String[] args){
        String[] argumentos = new String[4];
        argumentos[0] = "1111";
        argumentos[1] = "10.0.0.0/255.0.0.0/0.0.0.0/0";
        argumentos[2] = "20.20.0.0/255.255.0.0/0.0.0.0/0";
        argumentos[3] = "30.1.2.0/255.255.255.0/127.0.0.1/2222";

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

        Roteador.main(argumentos);
    }
}
