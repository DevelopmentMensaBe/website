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
		translationOperator.add(new Translation("label.common.navigation.page.home", "Welcome", "Welkom", "Bienvenue", "Wilkommen"));
		translationOperator.add(new Translation("label.common.navigation.page.test", "IQ Test", "IQ Test", "Test IQ", "IQ Test"));
		translationOperator.add(new Translation("label.common.navigation.page.events", "Events", "Activiteiten", "Evénements", "Veranstaltungen"));
		translationOperator.add(new Translation("label.common.navigation.page.profile", "My Profile", "Mijn profiel", "Mon Profil", "Mein Profil"));

		translationOperator.add(new Translation("label.common.navigation.language.english", "English", "Engels", "Anglais", "Englisch"));
		translationOperator.add(new Translation("label.common.navigation.language.dutch", "Dutch", "Nederlands", "Néerlandais", "Niederländisch"));
		translationOperator.add(new Translation("label.common.navigation.language.french", "French", "Frans", "Français", "Französisch"));
		translationOperator.add(new Translation("label.common.navigation.language.german", "German", "Duits", "Allemand", "Deutsch"));

		translationOperator.add(new Translation("label.common.navigation.profile.login", "Login", "Aanmelden", "Connecter", "Einloggen"));
		translationOperator.add(new Translation("label.common.navigation.profile.logout", "Logout", "Afmelden", "Déconnecter", "Ausloggen"));
		translationOperator.add(new Translation("label.common.navigation.profile.edit", "Edit", "Aanpassen", "Adapter", "Anpassen"));

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

		var contentMemberMessageEnglish = "Hello member of Mensa with user name {0} and member id {1}. <br /><br /><br /> This new website uses 2020 web technologies like Vue 3 and PrimeVue 3 ";
		var contentMemberMessageDutch = "Hallo lid van Mensa met gebruikersnaam {0} en lid id {1}. <br /><br /><br /> Deze nieuwe website gebruikt 2020 web technologieën zoals Vue 3 en  PrimeVue 3 ";
		var contentMemberMessageFrench = "Bonjour membre de Mensa avec le nom d'utilisateur {0} et l'identifiant de membre {1}. <br /><br /><br /> Ce nouveau site web utilise les technologies web 2020 comme Vue 3 et PrimeVue 3 ";
		var contentMemberMessageGerman = "Hallo Mitglied von Mensa mit Benutzername {0} und Mitglieds-ID {1}. <br /><br /><br /> Diese neue Website verwendet 2020-Webtechnologien wie Vue 3 und PrimeVue 3 ";
		translationOperator.add(new Translation("content.member.message", contentMemberMessageEnglish, contentMemberMessageDutch, contentMemberMessageFrench,
				contentMemberMessageGerman));

		// Content - events page
		translationOperator.add(new Translation("content.events.documentTitle", "Events", "Activiteiten", "'Evénements", "Veranstaltungen"));
		translationOperator.add(new Translation("content.events.title", "Events", "Activiteiten", "'Evénements", "Veranstaltungen"));

		// Content - profile page
		translationOperator.add(new Translation("content.profile.documentTitle", "My Profile", "Mijn Profiel", "Mon Profil", "Mein Profil"));
		translationOperator.add(new Translation("content.profile.title", "My Profile", "Mijn Profiel", "Mon Profil", "Mein Profil"));
	}
}