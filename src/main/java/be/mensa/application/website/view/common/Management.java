package be.mensa.application.website.view.common;

import java.util.Locale;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.log4j.Level;

import be.mensa.application.website.business.common.ApplicationInformation;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Contains specific (administrator) functionality for managing the application
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Slf4j
@Named
@ApplicationScoped
public class Management {

	ApplicationInformation applicationInformation;

	@Getter
	Set<Level> logLevels;

	@Getter
	@Setter
	Level logLevel;

	@Getter
	Set<Locale> locales;

	/**********************************************************************************************************************************************************
	 *
	 * Management initialization
	 *
	 *********************************************************************************************************************************************************/
	@PostConstruct
	public void init() {

		log.info("Start initializing management functionality");

		logLevels = applicationInformation.getLogLevels();

		logLevel = applicationInformation.getDefaultLogLevel();

		locales = applicationInformation.getLocales();

		log.info("Finish initializing management functionality");

	}
}