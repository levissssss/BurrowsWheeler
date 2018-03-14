import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    private static final int R = 256; // extended ASCII
    private static char[] alphabet;
    /**
     * apply move-to-front encoding, reading from standard input and writing to standard output
     */
    public static void encode(){
        while (!BinaryStdIn.isEmpty()){
            char in = BinaryStdIn.readChar();
            BinaryStdOut.write(indexMove(in), 8);
        }
        BinaryStdOut.close();
    }

    private static int indexMove(char toFind){
        int index = -1;
        for (int i=0;i<alphabet.length; i++){
            if (alphabet[i] == toFind){
                index = i;
                break;
            }
        }
        if (index == -1){
            throw new IllegalArgumentException("Character not in alphabet!");
        }
        System.arraycopy(alphabet, 0, alphabet, 1, index);
        alphabet[0] = toFind;
        return index;
    }

    private static int indexMove(int toFind){
        if (toFind < 0  || toFind > R){
            throw new IllegalArgumentException("Character not in alphabet!");
        }
        int index;
        index = alphabet[toFind];
        System.arraycopy(alphabet, 0, alphabet, 1, toFind);
        alphabet[0] = (char) index;
        return index;
    }
    /**
     * apply move-to-front decoding, reading from standard input and writing to standard output
     */
    public static void decode(){
        while (!BinaryStdIn.isEmpty()){
            int in = BinaryStdIn.readChar();
            BinaryStdOut.write(indexMove(in));
        }
        BinaryStdOut.close();
    }

    /**
     * if args[0] is '+', apply move-to-front decoding
     * if args[0] is '-', apply move-to-front encoding
     * @param args
     */
    public static void main(String[] args){
        initAlphabet();
        if (args[0].equals("-")){
            encode();
        }else if (args[0].equals("+")){
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
