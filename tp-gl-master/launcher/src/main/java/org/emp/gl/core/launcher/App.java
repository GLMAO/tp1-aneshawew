package org.emp.gl.core.launcher;

import org.emp.gl.clients.HorlogeGUI;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.impl.DummyTimeServiceImpl;

public class App {
    public static void main(String[] args) {
        TimerService timerService = new DummyTimeServiceImpl();

        // Lancer l’horloge graphique
        new HorlogeGUI(timerService);

        // Laisser tourner le programme
        try {
            Thread.sleep(60000); // 1 minute
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Fin du programme.");
    }
}
