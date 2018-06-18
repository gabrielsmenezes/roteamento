
import model.Emissor;

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
               
//        String[] argumentos = new String[5];
//        argumentos[0] = "127.0.0.1";
//        argumentos[1] = "1111";
//        argumentos[2] = "1.1.1.1";
//        argumentos[3] = "10.0.0.5";
//        argumentos[4] = "Cheguei_R1?!";

//        String[] argumentos = new String[5];
//        argumentos[0] = "127.0.0.1";
//        argumentos[1] = "1111";
//        argumentos[2] = "1.1.1.1";
//        argumentos[3] = "30.1.2.10";
//        argumentos[4] = "Cheguei_R2?!";
   

//        String[] argumentos = new String[5];
//        argumentos[0] = "127.0.0.1";
//        argumentos[1] = "2222";
//        argumentos[2] = "1.1.1.1";
//        argumentos[3] = "20.0.2.1";
//        argumentos[4] = "Repassado_a_4444?!";

    
        String[] argumentos = new String[5];
        argumentos[0] = "127.0.0.1";
        argumentos[1] = "1111";
        argumentos[2] = "2.2.2.2";
        argumentos[3] = "40.0.40.1";
        argumentos[4] = "Descartado!!!";

        
        
//        String[] argumentos = new String[5];
//        argumentos[0] = "127.0.0.1";
//        argumentos[1] = "3333";
//        argumentos[2] = "2.2.2.2";
//        argumentos[3] = "10.10.10.10";
//        argumentos[4] = "TTL_excedido!!!";

        Emissor.main(argumentos);

    }
}
