package fr.eni.assotennis.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*les annotations Configuration et EnableWebSecurity designent la classe SpringSecurityConfig
en tant que configuration de la cha�ne de filtres de s�curit� pour l�application Spring Boot,
et pour la cr�ation de la cha�ne. 
*/
@Configuration
@EnableWebSecurity

/*
 * extends WebSecurityConfigurerAdapter d�finit la classe SpringSecurityConfig
 * en tant que configuration Spring Security.
 */

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//M�thode pour g�rer la s�rie de r�gles d�authentification. Pour assigner les r�les d�utilisateur et d'administrateur.  
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()	//les identifiants cr��s seront stock�s dans la m�moire, plut�t que dans un jeton ou dans une base de donn�es. 
			.withUser("rollandgarros").password(passwordEncoder().encode("raquette56240@"))
			.roles("USER")
			.and()
			.withUser("chefrollandgarros").password(passwordEncoder().encode("final56240@"))
			.roles("ADMIN", "USER");
	}
	
	/*
	 * M�thode pour faire passer toutes les requ�tes HTTP � travers la cha�ne de
	 * filtres de s�curit�, et configurez le formulaire de connexion par d�faut avec
	 * la m�thode form Login();
	 */
	@Override 
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()	//m�thode authorizeRequests() pour d�finir les r�les. 
			.antMatchers("/admin").hasRole("ADMIN")		//m�thode  antMatchers()  pour d�finir l'association 
			.antMatchers("/user").hasRole("USER")		//des r�les  USER  (utilisateur) et  ADMIN  (administrateur) avec des pages. 
			.anyRequest().authenticated()	//methode anyRequest().authenticated()  pour permettre d�utiliser le formulaire pour l�authentification. 
			.and()
			.formLogin()  // formulaire Spring Security par d�faut
			.and()
			.oauth2Login();	//m�thode  oauth2login pour avoir un formulaire de connexion par d�faut
	}
	
	/* Un bean peut �tre d�clar� en annotant une m�thode avec @Bean. Cette m�thode retourne l�instance du bean.*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();	//pour encodage des mots de passe avec algorithme de hachage BCrypt
	}
}