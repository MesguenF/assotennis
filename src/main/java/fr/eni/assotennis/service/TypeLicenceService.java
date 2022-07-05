/* La couche “service” est dédiée au “métier”.
 * C’est-à-dire appliquer des traitements dictés par les règles fonctionnelles de l’application.
 *
 * Ainsi, lorsqu’une requête est réceptionnée, la couche controller délègue les traitements métiers à exécuter.
 * La couche service pourra ensuite faire appel à la couche repository.
 *
 * Cependant, la couche service est également un pont entre le controller et le repository. 
*/
package fr.eni.assotennis.service;

import java.util.List;
import fr.eni.assotennis.bo.TypeLicence;

public interface TypeLicenceService {
	
	public TypeLicence getTypeLicence(long id);
	
	public List<TypeLicence> getTypeLicences();
}