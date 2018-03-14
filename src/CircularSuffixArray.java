import java.util.Arrays;
import java.util.Comparator;

public class CircularSuffixArray {

    char[] string;
    Integer[] suffixes;
    /**
     * circular suffix array of s
     * @param s
     */
    public CircularSuffixArray(String s){
        string = s.toCharArray();
        buildSuffixes();
        sortSuffixes();
    }

    private void sortSuffixes() {
        Arrays.sort(suffixes, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                for (int offset = 0; offset<length(); offset++){
                    int compare = string[(o1 + offset) % length()] - string[(o2 + offset) % length()];
                    if (compare != 0){
                        return compare;
                    }
                }
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
    }

    private void buildSuffixes() {
        suffixes = new Integer[length()];
        for (int i=0; i<string.length; i++){
            suffixes[i] = i;
        }
    }

    /**
     *
     * @return length of s
     */
    public int length(){
        return string.length;
    }

    /**
     *
     * @param i
     * @return index of ith sorted suffix
     */
    public int index(int i){
        return suffixes[i];
    }

    /**
     * unit testing (required)
     * @param args
     */
    public static void main(String[] args){
        String text = "ABRACADABRA!";
        CircularSuffixArray suffixArray = new CircularSuffixArray(text);
        System.out.println("length:" + suffixArray.length());
        System.out.println("Sorted suffixes: ");
        for (int i = 0; i < suffixArray.length(); i++) {
            System.out.println(suffixArray.index(i));
        }
    }
}
