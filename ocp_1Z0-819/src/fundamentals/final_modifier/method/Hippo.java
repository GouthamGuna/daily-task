package fundamentals.final_modifier.method;

public class Hippo extends Animal{

    /**
     *  Methods marked final cannot be overridden by a subclass.
     *  This essentially prevents any polymorphic behavior on the method call and a specific
     *  version of the method is always called.
     *<p>
     *  Remember that method can be assigned an abstraction or final modifier. An abstraction method is one
     *  that does not define a method body and can appear only onside an abstract class or interface.
     *<p>
     *  A final method is one that cannot overridden by a subclass.
     */

    @Override
     final void chew() {    // using final keyword.
        System.out.println("Using final keyword in chew method.");
    }
}
