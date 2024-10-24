package exercise;

// BEGIN
public class ReversedSequence implements java.lang.CharSequence{
    private String seq;

    public ReversedSequence(String seq) {
        this.seq = new StringBuilder(seq).reverse().toString();
    }

    @java.lang.Override
    public java.lang.String toString() {
        return seq;
    }

    public int length() {
        return seq.length();
    }

    public char charAt(int index) {
        return seq.charAt(index);
    }

    public String subSequence(int from, int to) {
        return seq.substring(from, to);
    }

}
// END
