package in.gmsk.int_primitive_type;

public class AddDigits {

    public static int addDigits(int num){

        while(num >= 10){
            int temp = 0;
            while(num > 0){
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }

        return num;
    }

    public static void main(String[] args) {
        int num = 15;
        System.out.println(addDigits(num));
    }
}
