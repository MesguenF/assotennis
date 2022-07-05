package fr.eni.assotennis;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/*Nous allons utiliser un objet MockMVC.
Ce dernier cr�e une fausse version de votre application web,
et lance les m�thodes qu�il comprend, afin que la fonctionnalit� de votre app ne soit pas interrompue.
Il utilise les �l�ments de SpringBootTest et JUnit 5,
mais vous permet de cr�er une instance de l�int�gralit� de votre configuration d�application web d�di�e au test.*/

/*SpringExtension assiste JUnit pour configurer une application de test, configur� avec Spring.
Cette annotation est n�cessaire pour activer toutes les autres annotations que nous voyons dans ce code.*/

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTests {
   @Autowired
   private MockMvc mvc;
   
   @Autowired
   private WebApplicationContext context;
   
   //pour construire la fausse copie avant de lancer les tests.
   //Nous utilisons la classe MockMvcBuilders pour �valuer les codes de r�ponse sur votre app test MVC.
   //La m�thode est intitul�e setup(), et utilise webAppContextSetup() pour ajouter la couche web,
   // apply(springSecurity())  pour ensuite ajouter la cha�ne de filtres de s�curit� de Spring Security ainsi que la m�thode  build() ,
   // et cr�er une nouvelle instance de type MockMvc.
   // En bref, cette proc�dure vous permettra de cr�er une application web destin�e � effectuer des tests. 
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}
	
	//Tester le faux objet dans la couche web. 
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
	mvc.perform(get("/login")).andDo(print()).andExpect(status().isOk());
	}
	
	//Tester l�authentification de l�utilisateur avec un login correct. 
	@Test
	public void userLoginTest() throws Exception {
	   mvc.perform(formLogin("/login").user("rollandgarros").password("raquette56240@")).andExpect(authenticated());
	}
	
	//Tester la non-authentification de l�utilisateur, qui saisit un mot de passe incorrect. 
	@Test
	public void userLoginFailed() throws Exception {
	mvc.perform(formLogin("/login").user("rollandgarros").password("wrongpassword")).andExpect(unauthenticated());
	}
}