package be.mensa.application.website.data.preprod.main;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.mensa.application.website.data.preprod.security.SecurityApplicationData;
import lombok.extern.slf4j.Slf4j;

/**
 * Enabled on server startup for adding test data.
 *
 * NOT FOR USE IN PRODUCTION!
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Slf4j
@Startup
@Singleton
public class ApplicationData {

	@PersistenceContext
	EntityManager em;

	@Inject
	SecurityApplicationData securityApplicationData;

	/**
	 * Starts inserting test data based on different use cases and different deployment environments
	 */
	@PostConstruct
	public void init() {

		var schemaGeneration = em.getEntityManagerFactory().getProperties().get("javax.persistence.schema-generation.database.action").toString();

		log.info("schema generation: " + schemaGeneration);

		var persistenceUnit = em.getEntityManagerFactory().getProperties().get("hibernate.ejb.persistenceUnitName").toString();

		log.info("persistence unit: " + persistenceUnit);

		if (!schemaGeneration.equals("none")) {

			if (persistenceUnit.contains("local")) {

				log.info("generate security data");
				securityApplicationData.generateData();
			}
		}

	}
}
