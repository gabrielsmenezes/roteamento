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
        String[] argumentos = new String[2];
        argumentos[0] = "12345";
        argumentos[1] = "192.168.1.0/255.255.255.0/192.168.1.6/12346";
        
        Roteador.main(argumentos);
    }
}
