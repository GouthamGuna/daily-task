package in.dev.gmsk.model;

public class User {

    private final String name;
    private long USER_ID;

    public User(String name, long USER_ID) {
        this.name = name;
        this.USER_ID = USER_ID;
    }

    public String getName() {
        return name;
    }

    public long getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(long USER_ID) {
        this.USER_ID = USER_ID;
    }

    public void sayHello(){
        System.out.println("Hello!");
    }

    private void privateChat(){
        System.out.println("Hello this is private Chat. How did you call this");
    }

    private static void thisPrivateStaticMethod(){
        System.out.println("I'm private and static.");
    }

    public static void thisPublicStaticMethod(){
        System.out.println("I'm public and static.");
    }
}
