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
import fr.eni.assotennis.bo.Badge;

public interface BadgeService {
	
	public Badge addBadge(Badge badge);
	
	public Badge getBadge(long id);
	
	public void removeBadge(long id);
	
	public Badge updateBadge(long id);
	
	public List<Badge> getBadges();

}