package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.impl.DummyTimeServiceImpl;
 
 /**
 * Hello world!
 *
 */

public class App {

    public static void main(String[] args) {
        testDuTimeService();
    }

    private static void testDuTimeService() {
        // Créer le TimerService (il démarre dans le constructeur)
        TimerService timerService = new DummyTimeServiceImpl();

        // Injecter le service dans les horloges (elles s'inscrivent automatiquement)
        new Horloge("Num 1", timerService);
        new Horloge("Num 2", timerService);
        new Horloge("Num 3", timerService);

        // laisser l'application tourner (sinon JVM peut se terminer si tout est daemon)
        try {
            Thread.sleep(15000); // afficher pendant 15s
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Fin du main.");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

