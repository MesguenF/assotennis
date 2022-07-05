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
en tant que configuration de la chaîne de filtres de sécurité pour l’application Spring Boot,
et pour la création de la chaîne. 
*/
@Configuration
@EnableWebSecurity

/*
 * extends WebSecurityConfigurerAdapter définit la classe SpringSecurityConfig
 * en tant que configuration Spring Security.
 */

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//Méthode pour gérer la série de règles d’authentification. Pour assigner les rôles d’utilisateur et d'administrateur.  
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()	//les identifiants créés seront stockés dans la mémoire, plutôt que dans un jeton ou dans une base de données. 
			.withUser("rollandgarros").password(passwordEncoder().encode("raquette56240@"))
			.roles("USER")
			.and()
			.withUser("chefrollandgarros").password(passwordEncoder().encode("final56240@"))
			.roles("ADMIN", "USER");
	}
	
	/*
	 * Méthode pour faire passer toutes les requêtes HTTP à travers la chaîne de
	 * filtres de sécurité, et configurez le formulaire de connexion par défaut avec
	 * la méthode form Login();
	 */
	@Override 
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()	//méthode authorizeRequests() pour définir les rôles. 
			.antMatchers("/admin").hasRole("ADMIN")		//méthode  antMatchers()  pour définir l'association 
			.antMatchers("/user").hasRole("USER")		//des rôles  USER  (utilisateur) et  ADMIN  (administrateur) avec des pages. 
			.anyRequest().authenticated()	//methode anyRequest().authenticated()  pour permettre d’utiliser le formulaire pour l’authentification. 
			.and()
			.formLogin()  // formulaire Spring Security par défaut
			.and()
			.oauth2Login();	//méthode  oauth2login pour avoir un formulaire de connexion par défaut
	}
	
	/* Un bean peut être déclaré en annotant une méthode avec @Bean. Cette méthode retourne l’instance du bean.*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();	//pour encodage des mots de passe avec algorithme de hachage BCrypt
	}
}