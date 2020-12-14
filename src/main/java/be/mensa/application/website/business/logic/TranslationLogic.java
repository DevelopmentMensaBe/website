package be.mensa.application.website.business.logic;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import be.mensa.application.website.data.operator.common.TranslationOperator;
import be.mensa.application.website.data.schema.fixed.Language;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * Contains logic for translating any kind of text.
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Slf4j
@Startup
@Singleton
@Path("translation")
@Api(tags = { "translation" })
public class TranslationLogic {

	@Inject
	Instance<TranslationOperator> translationOperator;

	@GET
	@Path("{language}/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String translateRequest(@PathParam(value = "name") String name, @PathParam(value = "language") String language) {

		return translate(name, Language.valueOf(language));
	}

	/**
	 * Gets the translated text for the given name and language
	 *
	 * @param name
	 * @param language
	 * @return translated text
	 */
	public String translate(String name, Language language) {

		log.info(name);

		var translation = translationOperator.get().translate(name);

		return switch (language) {
		case english -> translation.getEnglish();
		case dutch -> translation.getNederlands();
		case french -> translation.getFrancais();
		case german -> translation.getDeutsch();
		};
	}

}