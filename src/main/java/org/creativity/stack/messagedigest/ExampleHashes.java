package org.creativity.stack.messagedigest;

import java.security.MessageDigest;

public class ExampleHashes {

    public static void main(String[] args) throws Exception {
        String [] tipo = {"MD2","MD5","SHA-1","SHA-256","SHA-384","SHA-512"};
        String cadena = "Aunque pase por el valle de sombra de muerte no temeré mal alguno, " +
                "porque tú estás conmigo tu vara y tu cayado me infunden aliento";

        for (int i = 0; i <tipo.length ; i++) {
            System.out.println(tipo[i] +": " + hash(cadena,tipo[i]));
        }
    }
    static public String hash(String texto,String tipo) throws Exception{
        MessageDigest md = MessageDigest.getInstance(tipo);
        byte[] resultado = md.digest(texto.getBytes("UTF-8"));
        StringBuffer valores = new StringBuffer();
        for (int i = 0; i < resultado.length; i++) {
            valores.append(Integer.toHexString(0xFF & resultado[i]));
        }
        return valores.toString();
    }
}
