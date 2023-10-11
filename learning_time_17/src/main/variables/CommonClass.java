package main.variables;

class Chat{

    String msg = "X";

    Chat(){
        Chat();
    }

    void Chat(){
        System.out.println("msg = " + (msg += "A"));
    }
}

class PrivateChat extends Chat{


    String msg = "Y";

    PrivateChat(){}

   /* @Override   this @override method on private chat */

    void Chat(){
        System.out.println("msg = " + (msg += "B"));
    }
}

public class CommonClass {
    public static void main(String[] args) {
        new PrivateChat();
    }
}
