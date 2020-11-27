package be.mensa.application.website.data.preprod.security;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import be.mensa.application.website.data.operator.common.TranslationOperator;
import be.mensa.application.website.data.schema.dynamic.common.Translation;

/**
 * Generates translation data
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Dependent
public class TranslationApplicationData {

	@Inject
	TranslationOperator translationOperator;

	/**
	 * Generates the application data...
	 */
	public void generateData() {

		// Labels - common

		// Navigation
		translationOperator.add(new Translation("label.common.profile.login", "Login", "Aanmelden", "Connecter", "Einloggen"));
		translationOperator.add(new Translation("label.common.profile.logout", "Logout", "Afmelden", "Déconnecter", "Ausloggen"));
		translationOperator.add(new Translation("label.common.profile.edit", "Edit", "Aanpassen", "Adapter", "Anpassen"));

		translationOperator.add(new Translation("label.common.save", "Save", "Bewaren", "Sauvegarder", "Bewahren"));

		// Labels - event page
		translationOperator.add(new Translation("label.events.button.subscribe", "Subscribe", "Abonneren", "Souscrire", "Abonnieren"));

		// Content - welcome page
		translationOperator.add(new Translation("content.welcome.documentTitle", "Welcome", "Welkom", "Bienvenu", "Wilkommen"));
		translationOperator.add(new Translation("content.welcome.title", "Welcome at <em><span class=\"text-secondary\">Mensa</span></em>",
				"Welkom bij <em><span class=\"text-secondary\">Mensa</span></em>", "Bienvenu chez <em><span class=\"text-secondary\">Mensa</span></em>",
				"Wilkommen bei <em><span class=\"text-secondary\">Mensa</span></em>"));
		translationOperator.add(new Translation("content.welcome.message", "Welcome to Mensa Belgium", "Welkom bij Mensa België",
				"Bienvenu chez Mensa Belgique", "Wilkommen bei Mensa Belgien"));

		// Content - test page
		translationOperator.add(new Translation("content.test.documentTitle", "IQ Test", "IQ Test", "Test IQ", "IQ Test"));
		translationOperator.add(new Translation("content.test.title", "IQ Test", "IQ Test", "Test IQ", "IQ Test"));

		// Content - member page
		translationOperator.add(new Translation("content.member.documentTitle", "Members", "Leden", "Membres", "Mitglieden"));
		translationOperator.add(new Translation("content.member.title", "Members", "Leden", "Membres", "Mitglieden"));

		// Content - events page
		translationOperator.add(new Translation("content.events.documentTitle", "Events", "Activiteiten", "'Evénements", "Veranstaltungen"));
		translationOperator.add(new Translation("content.events.title", "Events", "Activiteiten", "'Evénements", "Veranstaltungen"));

		// Content - profile page
		translationOperator.add(new Translation("content.profile.documentTitle", "My Profile", "Mijn Profiel", "Mon Profil", "Mein Profil"));
		translationOperator.add(new Translation("content.profile.title", "My Profile", "Mijn Profiel", "Mon Profil", "Mein Profil"));
	}
}