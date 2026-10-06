
package Unit_3_Lab_Work;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderDemo {
    public static void main(String[] args) {
        try {
            String[] encodedValues = {
                "This+string+has+spaces",
                "This%2Astring%2Ahas%2Aasterisks",
                "This%25string%25has%25percent%25signs",
                "This%2Fstring%2Fhas%2Fslashes",
                "This%3Astring%3Ahas%3Acolons",
                "name%3DRam%26city%3DKathmandu"
            };

            for (String enc : encodedValues) {
                System.out.println("Encoded : " + enc);
                System.out.println("Decoded : " + URLDecoder.decode(enc, "UTF-8"));
                System.out.println();
            }

            // Encode and then decode the same string
            String original = "Java Network Programming & Sockets";
            String encoded = URLEncoder.encode(original, "UTF-8");
            String decoded = URLDecoder.decode(encoded, "UTF-8");

            System.out.println("Original : " + original);
            System.out.println("Encoded  : " + encoded);
            System.out.println("Decoded  : " + decoded);

        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Broken VM does not support UTF-8");
        }
    }
}
