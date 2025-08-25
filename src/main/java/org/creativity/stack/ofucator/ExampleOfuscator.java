package org.creativity.stack.ofucator;

public class ExampleOfuscator {

    public static void main(String[] args) {
        System.out.println(ofuscarValor("4737028975776827",4));
    }

    public static String ofuscarValor(String cadena, int limite){
        StringBuilder base = new StringBuilder();
        int strSize = cadena.length();
        for (int i = 0; i < strSize-limite; i++) {
            base.append(Character.toString ((char) 8226));
        }
        base.append(cadena.substring(strSize-limite));
        return base.toString();
    }
}
