package be.mensa.module.core;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Contains common application information.
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Slf4j
public class ApplicationInformation {

	/**********************************************************************************************************************************************************
	 *
	 * Application constant initialization
	 *
	 *********************************************************************************************************************************************************/

	private static final String MAVEN_META_INF_FOLDER_NAME = "/META-INF/maven/";

	private static final String MAVEN_POM_PROPERTIES_FILE_NAME = "/pom.properties";

	private static final String POM_PROPERTIES_LOCATION = MAVEN_META_INF_FOLDER_NAME + ApplicationConstants.DEVELOPMENT_GROUP_NAME + "/"
			+ ApplicationConstants.DEVELOPMENT_APPLICATION_NAME + MAVEN_POM_PROPERTIES_FILE_NAME;

	private static final String VERSION_ERROR = "Version could not be determinated";

	// In case no pom.properties file was generated or wrong location is configured, no pom.properties loading is done; otherwise version will be assigned later
	@Getter
	private static String version = "No pom.properties file present in folder " + POM_PROPERTIES_LOCATION;

	static {

		Optional.ofNullable(ApplicationInformation.class.getResourceAsStream(POM_PROPERTIES_LOCATION)).ifPresent(p -> {

			var properties = new Properties();

			try {

				properties.load(p);

				version = properties.getProperty("version", VERSION_ERROR);

			} catch (Exception e) {

				version = VERSION_ERROR;

				log.error("Unexpected error occured during loading process of pom.properties file in META-INF folder!", e);
			}
		});
	}

	/**********************************************************************************************************************************************************
	 *
	 * Variables
	 *
	 *********************************************************************************************************************************************************/

	@Getter
	@Setter
	private Locale defaultLocale = new Locale(ApplicationConstants.LANGUAGE, ApplicationConstants.COUNTRY);

	@Getter
	private Set<Locale> locales = Stream.of(defaultLocale, Locale.US).collect(Collectors.toSet());

	/**********************************************************************************************************************************************************
	 *
	 * Reusable application functionality
	 *
	 *********************************************************************************************************************************************************/

	/**
	 * Based on the given bundle, locale and key will find the corresponding translated message. In case parameters are provided, it will replace the given
	 * value. Usually the parameter is the one that will replace the {0} string.
	 *
	 * @param messages
	 * @param locale
	 * @param key
	 * @param replaceArgument
	 * @return
	 */
	public static String translate(String bundle, Locale locale, String key, String replaceArgument) {

		log.trace("Translating key " + key + " for bundle " + bundle + " with locale " + locale.getDisplayName() + " with argument " + replaceArgument);

		return MessageFormat.format(ResourceBundle.getBundle(bundle, locale).getString(key), replaceArgument);
	}
}