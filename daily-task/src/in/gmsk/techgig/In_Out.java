package in.gmsk.techgig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class In_Out {
    public static void main(String[] args) {

        String str1;

        try {
            BufferedReader obj = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            do {
                str1 = obj.readLine();
            } while (!str1.equals("Strong"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
