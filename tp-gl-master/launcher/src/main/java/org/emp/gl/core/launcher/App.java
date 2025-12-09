package org.emp.gl.core.launcher;

import org.emp.gl.Lookup;
import org.emp.gl.clients.Horloge;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.impl.DummyTimeServiceImpl;

public class App {
    public static void main(String[] args) throws InterruptedException {

        // Créer le TimerService et l'insérer dans le Lookup
        TimerService timerService = new DummyTimeServiceImpl();
        Lookup.getInstance().subscribeService("TimerService", timerService);

        // Créer des horloges qui récupéreront automatiquement le TimerService
        Horloge h1 = new Horloge("Horloge 1");
        Horloge h2 = new Horloge("Horloge 2");

        // Laisser tourner le programme
        Thread.sleep(60000); // 1 minute

        System.out.println("Fin du programme.");
    }
}
