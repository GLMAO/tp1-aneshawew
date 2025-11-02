package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.impl.DummyTimeServiceImpl;
import org.emp.gl.clients.CompteARebours;
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
        //new Horloge("Num 1", timerService);
        //new Horloge("Num 2", timerService);
        //new Horloge("Num 3", timerService);

        // Test d’un compte à rebours de 5 secondes
        new CompteARebours("Rebours 1", 5, timerService);

        // Test de plusieurs comptes à rebours aléatoires
        for (int i = 1; i <= 5; i++) {
            int randomValue = 10 + (int)(Math.random() * 6); // entre 10 et 15
            new CompteARebours("Rebours " + i, randomValue, timerService);
        }


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

