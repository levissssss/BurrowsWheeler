import edu.princeton.cs.algs4.BinaryOut;
import edu.princeton.cs.algs4.BinaryStdIn;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;

public class MoveToFront {

    private static final int R = 256; // extended ASCII
    private static char[] alphabet;
    /**
     * apply move-to-front encoding, reading from standard input and writing to standard output
     */
    public static void encode(){
        BinaryOut out = new BinaryOut();
        while (!BinaryStdIn.isEmpty()){
            char in = BinaryStdIn.readChar();

        }
        out.close();
    }

    private static int indexMove(char toFind){
        int index = 0;
        for (int i=0;i<alphabet.length; i++){
            if (alphabet[i] == toFind){
                index = i;
                break;
            }
            throw new IllegalArgumentException("Character not in alphabet!");
        }
        for (int i=index; i>0; i--){
            alphabet[i] = alphabet[i - 1];
        }
        alphabet[0] = toFind;
        return index;
    }
    /**
     * apply move-to-front decoding, reading from standard input and writing to standard output
     */
    public static void decode(){throw new NotImplementedException();}

    /**
     * if args[0] is '+', apply move-to-front decoding
     * if args[0] is '-', apply move-to-front encoding
     * @param args
     */
    public static void main(String[] args){
        if (args[0].equals("+")){
            encode();
        }
        if (args[0].equals("-")){
            decode();
        }
    }

    private static void initAlphabet(){
        alphabet = new char[R];
        for (char i=0; i<R; i++){
            alphabet[i] = i;
        }
    }
}
