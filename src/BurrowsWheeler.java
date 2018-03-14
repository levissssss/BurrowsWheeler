import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
    /**
     * apply Burrows-Wheeler transform, reading from standard input and writing to standard output
     */
    public static void transform(){
        String text = BinaryStdIn.readString();
        CircularSuffixArray suffixArray = new CircularSuffixArray(text);
        int original = 0;
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<suffixArray.length(); i++){
            int index = suffixArray.index(i);
            if (index == 0){
                original = i;
                builder.append(text.charAt(suffixArray.length() - 1));
            } else {
                builder.append(text.charAt(index - 1));
            }
        }
        BinaryStdOut.write(original);
        BinaryStdOut.write(builder.toString());
        BinaryStdOut.close();
    }

    /**
     * apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
     */
    public static void inverseTransform(){

    }

    /**
     * if args[0] is '-', apply Burrows-Wheeler transform
     * if args[0] is '+', apply Burrows-Wheeler inverse transform
     * @param args
     */
    public static void main(String[] args){
        if (args[0].equals("-")){
            transform();
        }else if (args[0].equals("+")){
            inverseTransform();
        }
    }
}
