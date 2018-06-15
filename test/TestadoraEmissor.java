/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrgab
 */
public class TestadoraEmissor {
    public static void main(String[] args){
        
        String[] argumentos = new String[5];
        argumentos[0] = "192.168.1.6";
        argumentos[1] = "12345";
        argumentos[2] = "192.168.255.1";
        argumentos[3] = "192.168.1.0";
        argumentos[4] = "Olee Olaa Borja vem ai e o bicho vai pegar!";

        Emissor.main(argumentos);

    }
}
