package main.general;

class ICDOuter{
    int i =100;

    static void classMethod(){
        final int l = 200;
        class LocalInStaticContext {
            //int k = i;  // Compile-time error
            int m = l;  // OK

            void delete(){
                System.out.println( "m = " + m );
            }
        }

        LocalInStaticContext local = new LocalInStaticContext();
        local.delete();
    }

    void foo() {
        class Local {  // A local class
            int j = i;

            void delete(){
                System.out.println( "j = " + j );
            }
        }

        Local local = new Local();
        local.delete();
    }
}
public class InnerClassDeclarations {
    public static void main(String[] args) {

        ICDOuter icdOuter = new ICDOuter();
        icdOuter.foo();

        ICDOuter.classMethod();
    }
}
