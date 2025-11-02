package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;

public class Horloge implements TimerChangeListener {

    private final String name;
    private final TimerService timerService;

    public Horloge(String name, TimerService timerService) {
        this.name = name;
        this.timerService = timerService;

        // inscription comme observateur 
        timerService.addTimeChangeListener(this);

        System.out.println("Horloge " + name + " initialized!");
    }

    public void afficherHeure() {
        if (timerService != null) {
            System.out.println(name + " affiche " +
                    timerService.getHeures() + ":" +
                    timerService.getMinutes() + ":" +
                    timerService.getSecondes());
        }
    }

    // appelé par le TimerService à chaque changement
    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        // On peut filtrer selon prop si besoin (dixième / seconde / minute / heure)
        // Ici on affiche à chaque notification
        afficherHeure();
    }

    // méthode utilitaire pour se désinscrire si besoin
    public void stopObserving() {
        timerService.removeTimeChangeListener(this);
    }
}

