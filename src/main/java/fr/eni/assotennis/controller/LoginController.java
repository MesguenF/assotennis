package fr.eni.assotennis.controller;

import java.security.Principal;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*@Service
@RestController*/

/* @Controller permet de déclarer un bean Web, c'est à  dire de la couche présentation.*/
@Controller

/*@Service permet de déclarer un bean de service, c’est à dire de la couche métier.*/
@Service

@RequestMapping("/")
public class LoginController {

	/*
	 * @RolesAllowed({"USER","ADMIN"})
	 * 
	 * @RequestMapping("/admin") public String getAdmin() { return "page-accueil"; }
	 */

	/* @RolesAllowed("USER") */
	/*
	 * @RequestMapping("/") public String getUser() {
	 * 
	 * return "page-accueil";
	 * 
	 * }
	 */

	@GetMapping("/user")
	public String homeUser() {
		return "page-accueil";
	}
	
	@GetMapping("/admin")
	public String homeAdmin() {
		return "page-accueil";
	}
	
	

	/*
	 * @RequestMapping("/*") public String getGithub() { return
	 * "Welcome Github user!"; return "page-accueil"; }
	 */
	
	/*
	 * Spring Security fournit des fonctionnalités de connexion et de déconnexion
	 * que nous pouvons utiliser dans notre application.
	 */
	//pour se deconnecter de l'application
	@RequestMapping(value="/logout", method=RequestMethod.GET)  
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
		if (auth != null){      
			new SecurityContextLogoutHandler().logout(request, response, auth);  
		}  
		return "redirect:/";  
	}  
	
	//partie de code pour récupèrer des informations du user GitHub - PAS VRAIMENT BESOIN
	private final OAuth2AuthorizedClientService authorizedClientService;

	public LoginController(OAuth2AuthorizedClientService authorizedClientService) {
		this.authorizedClientService = authorizedClientService;
	}

	public String getUserInfo(Principal user) {
		StringBuffer userInfo = new StringBuffer();
		if (user instanceof UsernamePasswordAuthenticationToken) {
			userInfo.append(getUsernamePasswordLoginInfo(user));
		} else if (user instanceof OAuth2AuthenticationToken) {
			userInfo.append(getOauth2LoginInfo(user));
		}
		return userInfo.toString();
	}

	private StringBuffer getUsernamePasswordLoginInfo(Principal user) {
		StringBuffer usernameInfo = new StringBuffer();

		UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken) user);
		if (token.isAuthenticated()) {
			User u = (User) token.getPrincipal();
			usernameInfo.append("Welcome, " + u.getUsername());
		} else {
			usernameInfo.append("NA");
		}
		return usernameInfo;
	}

	private StringBuffer getOauth2LoginInfo(Principal user) {

		StringBuffer protectedInfo = new StringBuffer();

		OAuth2AuthenticationToken authToken = ((OAuth2AuthenticationToken) user);
		OAuth2AuthorizedClient authClient = this.authorizedClientService
				.loadAuthorizedClient(authToken.getAuthorizedClientRegistrationId(), authToken.getName());
		if (authToken.isAuthenticated()) {

			Map<String, Object> userAttributes = ((DefaultOAuth2User) authToken.getPrincipal()).getAttributes();

			String userToken = authClient.getAccessToken().getTokenValue();
			protectedInfo.append("Welcome, " + userAttributes.get("name") + "<br><br>");
			protectedInfo.append("e-mail: " + userAttributes.get("email") + "<br><br>");
			protectedInfo.append("Access Token: " + userToken + "<br><br>");
		} else {
			protectedInfo.append("NA");
		}
		return protectedInfo;
	}
	
}