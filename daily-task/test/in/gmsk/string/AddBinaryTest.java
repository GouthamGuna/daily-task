package in.gmsk.string;

import org.junit.jupiter.api.Test;

class AddBinaryTest {
    @Test
    void addBinary() {

        AddBinary instance = new AddBinary();
        String args1 = "11", args2 = "1";
        System.out.println("Output : " + instance.addBinary(args1, args2));
    }

}