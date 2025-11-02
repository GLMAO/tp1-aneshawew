package org.emp.gl.timer.service;

import java.beans.PropertyChangeListener;

/**
 * Interface de notification de changement de temps.
 * Hérite de PropertyChangeListener pour être compatible
 * avec PropertyChangeSupport (thread-safe).
 */
public interface TimerChangeListener extends PropertyChangeListener {

    String DIXEME_DE_SECONDE_PROP = "dixième";
    String SECONDE_PROP = "seconde";
    String MINUTE_PROP = "minute";
    String HEURE_PROP = "heure";

}
