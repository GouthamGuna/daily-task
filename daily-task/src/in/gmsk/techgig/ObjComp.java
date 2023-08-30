package in.gmsk.techgig;

public class ObjComp {
    public static void main(String[] args) {
        int result = 0;
        ObjComp objComp = new ObjComp();
        Object o = objComp;

        if(o == objComp){
            result = 1;
        }

        if(o != objComp){
            result = result + 1;
        }

        if(o.equals(objComp)){
            result = result + 100;
        }

        if(objComp.equals(o)){
            result = result + 1000;
        }

        System.out.println("result = " + result);
    }
}
