package by.htp.selen.Utility;

/**
 * Created by user on 04.04.17.
 */
public class ParseToNumber {
    private static final char prev = '\u0030';
    private static final char next = '\u0039';
    private static final char dot = '\u002E';
    private static final char comma = '\u002C';

    public static double parseAlltoDouble (String string){

        char [] metaList = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i<metaList.length; i++) {
            char c = metaList[i];
            if (c >= prev && c <= next || c == comma){
                if (c == comma){
                    c = dot;
                }
                stringBuilder.append(c);
            }
        }
        double x = Double.parseDouble(stringBuilder.toString().trim());
        return x;
    }

    public static int parseAlltoInt (String string){

        char [] metaList = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i<metaList.length; i++) {
            char c = metaList[i];
            if (c <= next && c >= prev || c == comma){
                if (c == comma){
                    c = dot;
                }
                stringBuilder.append(c);
            }
        }
        int resulit = Integer.parseInt(stringBuilder.toString().trim());
        return resulit;
    }
}
