package in.dev.gmsk.reflection;

import in.dev.gmsk.model.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainClass {
    public static void main(String[] args) throws Exception{

        User user = new User("Karan Singh", 2023_27);

        Field[] userFields = user.getClass().getDeclaredFields();

        for(Field field: userFields){

            if(field.getName().equals("name")){
                field.setAccessible(true);
                field.set(user, "GMSK");
            }
        }

        System.out.println("field = " + user.getName());

        Method[] userMethods = user.getClass().getDeclaredMethods();

        for(Method method : userMethods){
            if(method.getName().equals("sayHello")){
                method.invoke(user);
            }
        }
        // System.out.println("method = " + user);

    }
}
