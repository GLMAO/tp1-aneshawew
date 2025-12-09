package org.emp.gl.clients;

import org.emp.gl.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.beans.PropertyChangeEvent;

public class Horloge implements TimerChangeListener {

    private final String nom;
    private final TimerService timerService;

    public Horloge(String nom) {
        this.nom = nom;
        // Récupération du TimerService depuis le Lookup
        this.timerService = (TimerService) Lookup.getInstance().getService("TimerService");
        timerService.addTimeChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) {
            System.out.printf("[%s] Heure actuelle : %02d:%02d:%02d%n",
                    nom,
                    timerService.getHeures(),
                    timerService.getMinutes(),
                    timerService.getSecondes());
        }
    }

    public void stop() {
        timerService.removeTimeChangeListener(this);
    }
}
