package org.creativity.stack.messagedigest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.util.Arrays;

public class ExampleMessageDigest {

    /*
     * La API de criptografia de java admite los siguientes algoritmos
     * de resumen de mensajes.
     * MD2
     * MD5
     * SHA-1
     * SHA-256
     * SHA-384
     * SHA-512
     */

    public static void main(String[] args) throws Exception {
        resumen();
        resumens();
        fileHash();
    }

    public static void resumen() throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        byte[] data = "0123456789".getBytes("UTF-8");
        byte[] data2 = "01234567890".getBytes("UTF-8");

        byte[] digest = messageDigest.digest(data);

        System.out.println("Tamaño del resumen : " + digest.length);
        System.out.println(Arrays.toString(digest));
        System.out.println("Son iguales ? : " + Arrays.toString(data).equals(Arrays.toString(data2)));
    }

    public static void resumens() throws Exception{
        /*Si tiene varios bloques de datos para
         * incluir en el mismo resumen de mensaje,
         * llame al update() método y termine con una llamada a digest()
         */
        byte[] data = "0123456789".getBytes("UTF-8");
        byte[] data2 = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(data);
        messageDigest.update(data2);
        byte[] digest = messageDigest.digest();

        //Convertir el byte array a HexString format
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i <digest.length ; i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        System.out.println(hexString.toString());
    }
    static public void fileHash() throws Exception{

        File path = new File("C:\\Firma.txt");
        FileReader fr = new FileReader(String.valueOf(path));
        BufferedReader br = new BufferedReader(fr);

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        //br.readLine > ingresa en el archivo solo 10 numeros
         byte[] digest = md.digest(new byte[Integer.parseInt(br.readLine())]);
        //Convertir el byte array a HexString format
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i <digest.length ; i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        System.out.println("Hash de Archivo : " + hexString.toString());
    }
}
