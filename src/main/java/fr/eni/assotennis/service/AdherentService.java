/* La couche �service� est d�di�e au �m�tier�.
 * C�est-�-dire appliquer des traitements dict�s par les r�gles fonctionnelles de l�application.
 *
 * Ainsi, lorsqu�une requ�te est r�ceptionn�e, la couche controller d�l�gue les traitements m�tiers � ex�cuter.
 * La couche service pourra ensuite faire appel � la couche repository.
 *
 * Cependant, la couche service est �galement un pont entre le controller et le repository. 
*/
package fr.eni.assotennis.service;

import java.util.List;
import fr.eni.assotennis.bo.Adherent;

public interface AdherentService {
	
	public Adherent addAdherent(Adherent adherent);
	
	public Adherent getAdherentById(long id);
	
	/* public Adherent getAdherentByName(String nom); */
	
	public void removeAdherentById(long idAdherent);
	
	public void updateAdherent(Adherent adherent);
	
	public void removeAdherent(Adherent adherent);
	
	public List<Adherent> getAdherents();
	
	public List<Adherent> getAdherentByName(String nom);
}