package org.emp.gl.core.launcher;

import org.emp.gl.Lookup;
import org.emp.gl.clients.Horloge;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.impl.DummyTimeServiceImpl;

public class App {
    public static void main(String[] args) throws InterruptedException {

        // Création du TimerService
        TimerService timerService = new DummyTimeServiceImpl();

        // Enregistrement dans le Lookup (avec la classe, pas une String)
        Lookup.getInstance().subscribeService(TimerService.class, timerService);

        // Création d'horloges
        Horloge h1 = new Horloge("Horloge 1");
        Horloge h2 = new Horloge("Horloge 2");

        // Laisser tourner le programme
        Thread.sleep(60000); // 1 minute

        System.out.println("Fin du programme.");
    }
}
