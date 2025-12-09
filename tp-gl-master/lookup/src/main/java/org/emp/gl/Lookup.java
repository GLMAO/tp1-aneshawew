package org.emp.gl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Lookup {

    private static volatile Lookup instance;
    private static final Object LOCK = new Object();

    // Map typée par Class
    private Map<Class<?>, Object> services = new ConcurrentHashMap<>();

    private Lookup() {}

    // Enregistrement d'un service
    public <T> void subscribeService(Class<? super T> serviceClass, T instance) {
        if (serviceClass == null || instance == null) {
            throw new IllegalArgumentException("Service class and instance cannot be null");
        }
        if (!serviceClass.isInstance(instance)) {
            throw new IllegalArgumentException("Instance does not match the service class");
        }
        services.put(serviceClass, instance);
    }

    // Récupération d'un service
    public <T> T getService(Class<T> serviceClass) {
        Object instance = services.get(serviceClass);
        if (instance == null) {
            throw new IllegalStateException("No service registered for: " + serviceClass.getName());
        }
        return serviceClass.cast(instance);
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
