package runner;

import decrypt.Decrypter;

public class main {

    public static void main (String[] args) {

//        System.out.println("Hello World!".substring(6,12)+"Hello World".substring(12, 6));
        Decrypter decrypter = new Decrypter();
        try {
            System.out.println(decrypter.decrypt("FlVUeEVHERcBEwRsQ0ISB3VDUEETQkYlcCEUAEJSBAJ35w=="));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
