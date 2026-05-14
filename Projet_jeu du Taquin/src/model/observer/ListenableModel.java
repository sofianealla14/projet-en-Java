package model.observer;

/**
 * 
 * Interface squelette pour les classes écoutables.
 * 
 * @author Jules, Lucas, Eliot, Sofiane, Antonin
 *
 */

public interface ListenableModel {
	void addListener(ModelListener e);
	void removeListener(ModelListener e);
	void taquinChange();
}
