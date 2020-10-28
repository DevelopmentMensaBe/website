package be.mensa.application.website.business.common;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;

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
	 * Application constants
	 *
	 *********************************************************************************************************************************************************/
	public static final String BUSINESS_APPLICATION_NAME = "Mensa België website";

	public static final String DEVELOPMENT_APPLICATION_NAME = "website";

	public static final String DEVELOPMENT_GROUP_NAME = "be.mensa.application";

	/**********************************************************************************************************************************************************
	 *
	 * Application constant initialization
	 *
	 *********************************************************************************************************************************************************/
	private static final String POM_PROPERTIES_LOCATION = "/META-INF/maven/" + DEVELOPMENT_GROUP_NAME + "/" + DEVELOPMENT_APPLICATION_NAME + "/pom.properties";

	private static final String VERSION_ERROR = "Version could not be determinated";

	// In case no pom.properties file was generated or wrong location is configured, no pom.properties loading is done; otherwise version will be assigned later
	@Getter(onMethod_ = { @PermitAll })
	private static String version = "No pom.properties file present in folder " + POM_PROPERTIES_LOCATION;

	static {

		Optional.ofNullable(ApplicationInformation.class.getResourceAsStream(POM_PROPERTIES_LOCATION)).ifPresent(p -> {

			var properties = new Properties();

			try {

				properties.load(p);

				version = properties.getProperty("version", VERSION_ERROR);

			} catch (Exception e) {

				version = VERSION_ERROR;

				log.error("Unexpected error occured during loading process of pom.properties file in META-INF folder!");
			}
		});
	}

	/**********************************************************************************************************************************************************
	 *
	 * Variables
	 *
	 *********************************************************************************************************************************************************/

	@Getter(onMethod_ = { @RolesAllowed("admin") })
	@Setter(onMethod_ = { @RolesAllowed("admin") })
	private Level defaultLogLevel = LogManager.getRootLogger().getLevel();

	@Getter(onMethod_ = { @RolesAllowed("admin") })
	private Set<Level> logLevels = new LinkedHashSet<>(
			Arrays.asList(Level.OFF, Level.FATAL, Level.ERROR, Level.WARN, Level.INFO, Level.DEBUG, Level.TRACE, Level.ALL));

	@Getter(onMethod_ = { @PermitAll })
	@Setter(onMethod_ = { @RolesAllowed("admin") })
	private Locale defaultLocale = new Locale("nl", "BE");

	@Getter(onMethod_ = { @RolesAllowed("admin") })
	private Set<Locale> locales = Stream.of(defaultLocale, Locale.US).collect(Collectors.toSet());

	/**********************************************************************************************************************************************************
	 *
	 * Initiate common application functionality
	 *
	 *********************************************************************************************************************************************************/
	@PostConstruct
	public void init() {

		log.info("");
		log.info("°°°°°°°°°°°°°°°° Begin loading common application functionality °°°°°°°°°°°°°°°°");
		log.info("");

		log.info("");
		log.info("°°°°°°°°°°°°°°°° End loading common application functionality °°°°°°°°°°°°°°°°");
		log.info("");
	}

	/**********************************************************************************************************************************************************
	 *
	 * Reusable application functionality
	 *
	 *********************************************************************************************************************************************************/

	/**
	 * Based on the given bundle, locale and key will find the corresponding translated message. In case replaceArgument is provided, it will replace the given
	 * value. Usually the replaceArgument is the one that will replace the {0} string.
	 *
	 * Accessible by all kind of users.
	 *
	 * @param messages
	 * @param locale
	 * @param key
	 * @param replaceArgument
	 * @return
	 */
	@PermitAll
	public static String translate(String bundle, Locale locale, String key, String replaceArgument) {

		log.trace("Translating key " + key + " for bundle " + bundle + " with locale " + locale.getDisplayName() + " with argument " + replaceArgument);

		return MessageFormat.format(ResourceBundle.getBundle(bundle, locale).getString(key), replaceArgument);
	}

	/**********************************************************************************************************************************************************
	 *
	 * Data operators
	 *
	 *********************************************************************************************************************************************************/

}