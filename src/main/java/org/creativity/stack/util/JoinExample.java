package org.creativity.stack.util;

public class JoinExample {

    public static void main(String[] args) {
        //delimitador es "$" y los elementos son "perro", "gato", "pato", "conejo"
        String resultado = String.join(" $ ","perro","gato","pato","conejo");
        System.out.println(resultado);

        joinMap(" -> ","Hansel","Israel","Jerusalem","Jah");
    }

    public static void joinMap(String delimiter,CharSequence... str){
        System.out.println(String.join(delimiter,str));
    }
}
