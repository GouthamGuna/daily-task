package in.gmsk.string;

public class AddBinary {

    public String addBinary(String args1, String args2){

        StringBuilder result = new StringBuilder();

        int carry = 0,
        i = args1.length() -1,
        j = args2.length() -1;

        while(i >= 0 || j >= 0){

            int sum = carry;

            if(i >= 0){
                sum += args1.charAt(i--) - '0';
            }

            if(j >= 0){
                sum += args2.charAt(j--) - '0';
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        if(0 != carry){
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
