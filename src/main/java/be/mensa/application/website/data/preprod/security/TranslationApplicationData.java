package be.mensa.application.website.data.preprod.security;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import be.mensa.application.website.data.operator.common.TranslationOperator;
import be.mensa.module.core.enums.EmailType;
import be.mensa.module.core.enums.WebsiteLanguage;
import be.mensa.module.schema.common.Translation;

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

	enum Page {
		home, test, authentication, member, profile, events
	}

	static final String LABEL_COMMON_NAVIGATION_PAGE = "label.common.navigation.page.";
	static final String LABEL_COMMON_NAVIGATION_LANGUAGE = "label.common.navigation.language.";
	static final String LABEL_COMMON_NAVIGATION_PROFILE = "label.common.navigation.profile.";
	static final String LABEL_COMMON_ACTION = "label.common.action.";

	static final String LABEL_DOCUMENT_TITLE = "label.document.title.";

	static final String LABEL_PAGE_AUTHENTICATION_FORM = "label.page.authentication.form.";

	static final String LABEL_PAGE_PROFILE_FORM = "label.page.profile.form.";

	static final String CONTENT_TITLE = "content.title.";

	static final String REFERENCE_EMAIL_TYPE = "reference.email.type.";

	/**
	 * Generates the application data...
	 */
	public void generateData() {

		// Label - common

		// navigation
		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_PAGE + Page.home, "Welcome", "Welkom", "Bienvenue", "Wilkommen"));
		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_PAGE + Page.test, "IQ Test", "IQ Test", "Test IQ", "IQ Test"));
		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_PAGE + Page.authentication, "Login", "Aanmelden", "Connecter", "Einloggen"));
		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_PAGE + Page.member, "Members", "Leden", "Membres", "Mitglieden"));
		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_PAGE + Page.profile, "My Profile", "Mijn profiel", "Mon Profil", "Mein Profil"));
		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_PAGE + Page.events, "Events", "Activiteiten", "Evénements", "Veranstaltungen"));

		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_LANGUAGE + WebsiteLanguage.english, "English", "Engels", "Anglais", "Englisch"));
		translationOperator
				.add(new Translation(LABEL_COMMON_NAVIGATION_LANGUAGE + WebsiteLanguage.dutch, "Dutch", "Nederlands", "Néerlandais", "Niederländisch"));
		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_LANGUAGE + WebsiteLanguage.french, "French", "Frans", "Français", "Französisch"));
		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_LANGUAGE + WebsiteLanguage.german, "German", "Duits", "Allemand", "Deutsch"));

		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_PROFILE + "login", "Login", "Aanmelden", "Connecter", "Einloggen"));
		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_PROFILE + "logout", "Logout", "Afmelden", "Déconnecter", "Ausloggen"));
		translationOperator.add(new Translation(LABEL_COMMON_NAVIGATION_PROFILE + "edit", "Edit", "Aanpassen", "Adapter", "Anpassen"));

		// actions
		translationOperator.add(new Translation(LABEL_COMMON_ACTION + "save", "Save", "Bewaren", "Sauvegarder", "Bewahren"));
		translationOperator.add(new Translation(LABEL_COMMON_ACTION + "submit", "Submit", "Verzenden", "Soumettre", "Einreichen"));

		// Label - welcome Page
		translationOperator.add(new Translation(LABEL_DOCUMENT_TITLE + Page.home, "Welcome", "Welkom", "Bienvenu", "Wilkommen"));

		// Label - test Page
		translationOperator.add(new Translation(LABEL_DOCUMENT_TITLE + Page.test, "IQ Test", "IQ Test", "Test IQ", "IQ Test"));

		// Label - authentication Page
		translationOperator.add(new Translation(LABEL_DOCUMENT_TITLE + Page.authentication, "Login", "Aanmelden", "Connecter", "Einloggen"));
		translationOperator.add(new Translation(LABEL_PAGE_AUTHENTICATION_FORM + "username", "User Name", "Gebruikersnaam", "Nom D'Utilisateur", "Nutzername"));
		translationOperator.add(new Translation(LABEL_PAGE_AUTHENTICATION_FORM + "password", "Password", "Wachtwoord", "Mot De Passe", "Passwort"));
		var authenticationFailedEnglish = "Login failed. Have you entered the correct password?";
		var authenticationFailedDutch = "Aanmelden mislukt. Heb je zeker het juiste wachtwoord ingevoerd?";
		var authenticationFailedFrench = "Échec de la connexion. Avez-vous entré le mot de passe correct?";
		var authenticationFailedGerman = "Login fehlgeschlagen. Haben Sie das richtige Passwort eingegeben?";
		translationOperator.add(new Translation(LABEL_PAGE_AUTHENTICATION_FORM + "failed", authenticationFailedEnglish, authenticationFailedDutch,
				authenticationFailedFrench, authenticationFailedGerman));
		translationOperator.add(new Translation(LABEL_PAGE_AUTHENTICATION_FORM + "again", "Again", "Opnieuw proberen", "Réessayer", "Nochmal Versuchen"));

		// Label - member Page
		translationOperator.add(new Translation(LABEL_DOCUMENT_TITLE + Page.member, "Members", "Leden", "Membres", "Mitglieden"));
		translationOperator.add(new Translation("label.events.button.subscribe", "Subscribe", "Abonneren", "Souscrire", "Abonnieren"));

		// Label - profile Page
		translationOperator.add(new Translation(LABEL_DOCUMENT_TITLE + Page.profile, "My Profile", "Mijn Profiel", "Mon Profil", "Mein Profil"));
		translationOperator.add(new Translation(LABEL_PAGE_PROFILE_FORM + "firstName", "First Name", "Voornaam", "Prénom", "Vorname"));
		translationOperator.add(new Translation(LABEL_PAGE_PROFILE_FORM + "lastName", "Last Name", "Achternaam", "Nom De Famille", "Nachname"));
		translationOperator.add(new Translation(LABEL_PAGE_PROFILE_FORM + "birthDate", "Birth Date", "Geboortedatum", "Date De Naissance", "Geburtsdatum"));
		translationOperator.add(new Translation(LABEL_PAGE_PROFILE_FORM + "street", "Street", "Straat", "Rue", "Straße"));
		translationOperator.add(new Translation(LABEL_PAGE_PROFILE_FORM + "number", "Number", "Nummer", "Numéro", "Nummer"));
		translationOperator.add(new Translation(LABEL_PAGE_PROFILE_FORM + "zip", "Zip Code", "Postcode", "Code Postal", "Postleitzahl"));
		translationOperator.add(new Translation(LABEL_PAGE_PROFILE_FORM + "city", "City", "Gemeente", "Ville", "Stadt"));
		translationOperator.add(new Translation(LABEL_PAGE_PROFILE_FORM + "username", "Username", "Gebruikersnaam", "Nom D'Utilisateur", "Nutzername"));
		translationOperator.add(new Translation(LABEL_PAGE_PROFILE_FORM + "role", "Role", "Rol", "Rôle", "Rolle"));
		translationOperator.add(new Translation(LABEL_PAGE_PROFILE_FORM + "language", "Language", "Taal", "Langue", "Sprache"));

		// Label - events Page
		translationOperator.add(new Translation(LABEL_DOCUMENT_TITLE + Page.events, "Events", "Activiteiten", "'Evénements", "Veranstaltungen"));

		// Content - home Page
		translationOperator.add(new Translation(CONTENT_TITLE + Page.home, "Welcome at <em><span class=\"text-secondary\">Mensa</span></em>",
				"Welkom bij <em><span class=\"text-secondary\">Mensa</span></em>", "Bienvenu chez <em><span class=\"text-secondary\">Mensa</span></em>",
				"Wilkommen bei <em><span class=\"text-secondary\">Mensa</span></em>"));
		translationOperator.add(new Translation("content.welcome.message", "Welcome to Mensa Belgium", "Welkom bij Mensa België",
				"Bienvenu chez Mensa Belgique", "Wilkommen bei Mensa Belgien"));

		// Content - test Page
		translationOperator.add(new Translation(CONTENT_TITLE + Page.test, "IQ Test", "IQ Test", "Test IQ", "IQ Test"));

		// Content - authentication Page
		translationOperator.add(new Translation(CONTENT_TITLE + Page.authentication, "Login", "Aanmelden", "Connecter", "Einloggen"));

		// Content - member Page
		translationOperator.add(new Translation(CONTENT_TITLE + Page.member, "Members", "Leden", "Membres", "Mitglieden"));

		var contentMemberMessageEnglish = "Hello member of Mensa with user name {0}. <br /><br /> This new website uses 2020 web technologies like Vue 3 and PrimeVue 3 ";
		var contentMemberMessageDutch = "Hallo lid van Mensa met gebruikersnaam {0}. <br /><br /> Deze nieuwe website gebruikt 2020 web technologieën zoals Vue 3 en  PrimeVue 3 ";
		var contentMemberMessageFrench = "Bonjour membre de Mensa avec le nom d''utilisateur {0}. <br /><br /> Ce nouveau site web utilise les technologies web 2020 comme Vue 3 et PrimeVue 3 ";
		var contentMemberMessageGerman = "Hallo Mitglied von Mensa mit Benutzername {0}. <br /><br /> Diese neue Website verwendet 2020-Webtechnologien wie Vue 3 und PrimeVue 3 ";
		translationOperator.add(new Translation("content.member.message", contentMemberMessageEnglish, contentMemberMessageDutch, contentMemberMessageFrench,
				contentMemberMessageGerman));

		// Content - profile Page
		translationOperator.add(new Translation(CONTENT_TITLE + Page.profile, "My Profile", "Mijn Profiel", "Mon Profil", "Mein Profil"));

		// Content - events Page
		translationOperator.add(new Translation(CONTENT_TITLE + Page.events, "Events", "Activiteiten", "'Evénements", "Veranstaltungen"));

		// Reference - email type
		translationOperator.add(new Translation(REFERENCE_EMAIL_TYPE + EmailType.personal, "Personal", "Persoonlijk", "'Personel", "Persönlich"));
		translationOperator.add(new Translation(REFERENCE_EMAIL_TYPE + EmailType.work, "Work", "Werk", "Travail", "Arbeit"));

	}
}