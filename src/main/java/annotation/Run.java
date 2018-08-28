package annotation;

import com.google.gson.Gson;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//  https://www.youtube.com/watch?v=9BbxPd3GPeU&list=PL6jg6AGdCNaWgDwiPjmlIvkr8s2OdDH2P&index=1
//  https://www.youtube.com/watch?annotation_id=annotation_3466168611&feature=iv&index=2&list=SP6jg6AGdCNaWgDwiPjmlIvkr8s2OdDH2P&src_vid=9BbxPd3GPeU&v=y8gkmqFvybs

public class Run {
    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
//        inspectService(SimpleService.class);
//        inspectService(LazyService.class);
//        inspectService(String.class);
        loadService("annotation.SimpleService");
        loadService("annotation.LazyService");


    }
    static void loadService(String className)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        //Class[] paramTypes = new Class[]{String.class, int.class};
        //Method method = c.getMethod("methodName", paramTypes);
        //Object[] args = new Object[] {new String("aa"), new Integer(10)};

        Map<String, Object> store = new HashMap<>();

        Class<?> clazz = Class.forName(className);
        if (clazz.isAnnotationPresent(Service.class)){
            Object serviceObj = clazz.newInstance();
            Service ann = clazz.getAnnotation(Service.class);
            store.put(ann.name(), serviceObj);

            Class<?> obj = serviceObj.getClass();
            Method[] methods = obj.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Init.class)) {
                    method.invoke(serviceObj);
                }

            }
        }


        Gson gson = new Gson();
        //System.out.println(gson.toJson(store));
    }

    static void inspectService(Class<?> service) {

//        if (service.isAnnotationPresent(Service.class)) {
//            Service ann = service.getAnnotation(Service.class);
//            System.out.println(service.getSimpleName() + "has. \n\tprop1 =  "+ann.name() + "\n\tprop2 " + ann.lazyloading());
//        } else {
//            System.out.println("Not found in " + service.getSimpleName() );
//        }
//
//        System.out.println(service.getSimpleName() +" class contains methods:\n\t" + Arrays.toString(service.getMethods()).replace(",", "\n")
//        );
//------------------------------
//        service.isAnnotationPresent(Service.class);
//        service.isAnnotationPresent(Init.class);
//
//        service.getAnnotation(Service.class);
//        service.getAnnotation(Init.class);
//
//        service.getAnnotations();
//        service.getDeclaredAnnotations();
    }
}
