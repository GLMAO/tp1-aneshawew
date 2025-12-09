package org.emp.gl;
import java.util.HashMap;
import java.util.Map;

public class Lookup {

    private static Lookup instance = new Lookup();
    private static Object LOCK = new Object();

    // .. code permettant d assurer la fonctionnalite Singleton
    Map < String , Object > services = new HashMap < >() ;

    public void subscribeService ( String service , Object instance ) {
        // TODO
        services.put(service, instance);
        //Done
    }
    public Object getService ( String service ) {
        // TODO
        return services.get(service);
        //Done
    }

    public static Lookup getInstance() {
        if (instance == null) {       
            synchronized (LOCK) {     
                if (instance == null) { 
                    instance = new Lookup();
                }
            }
        }
        return instance;
    }
}