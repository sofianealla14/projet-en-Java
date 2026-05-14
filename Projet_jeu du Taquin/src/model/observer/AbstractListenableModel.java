package model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jules, Lucas, Eliot, Sofiane, Antonin
 * 
 */

public abstract class AbstractListenableModel implements ListenableModel{
	
	private List<ModelListener> listeners = new ArrayList<ModelListener>();
	
	/**
	 * 
	 * Ajoute un écouteur à la liste listeners. Cet écouteur est récupéré en entrée.
	 * 
	 * @param e un écouteur
	 */
	
	public void addListener(ModelListener e) {
		this.listeners.add(e);
	}
	
	/**
	 * 
	 * Retire un écouteur à la liste listeners. Cet écouteur est récupéré en entrée.
	 * 
	 * @param e un écouteur
	 * 
	 */
	
	public void removeListener(ModelListener e) {
		this.listeners.remove(e);
	}
	
	/**
	 * Appelle la fonction modelUpdated de tous les écouteurs dans la liste des listeners.
	 */
	
	public void taquinChange() {
		for(ModelListener l : this.listeners) {
			l.modelUpdated(this);
		}
	}
	
}
