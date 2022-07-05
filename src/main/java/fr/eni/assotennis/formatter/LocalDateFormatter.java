package fr.eni.assotennis.formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component // je crée un bean pour pouvoir Autowirer mon Formatter dans ma classe : AppliConfigurer
public class LocalDateFormatter implements Formatter<LocalDate> {

	/**
	 *Comment on passe d'un format String => LocalDate 
	 */
	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {
		return LocalDate.parse(text);
	}

	/**
	 *Comment on passe d'un format LocalDate => String
	 */
	@Override
	public String print(LocalDate date, Locale locale) {
		return date.toString();
	}
}