import edu.princeton.cs.algs4.BinaryOut;
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
            BinaryStdOut.write(indexMove(in));
        }
        BinaryStdOut.flush();
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
    /**
     * apply move-to-front decoding, reading from standard input and writing to standard output
     */
    public static void decode(){
        BinaryOut out = new BinaryOut();
        while (!BinaryStdIn.isEmpty()){
            int in = BinaryStdIn.readChar();
            out.write(indexMove((char) in));
        }
        out.close();
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
