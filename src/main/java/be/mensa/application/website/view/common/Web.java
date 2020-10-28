package be.mensa.application.website.view.common;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.mensa.application.website.business.common.ApplicationInformation;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Contains all web functionality common for the whole application. Management functionality is done in <code>Management</code>
 *
 * @author Fabrizio Usai
 *
 * @see Management
 * @since 1.0.0
 *
 */
@Slf4j
@Named
@ApplicationScoped
public class Web {

	@Getter
	final String name = ApplicationInformation.BUSINESS_APPLICATION_NAME;

	@Getter
	final String technicalName = ApplicationInformation.DEVELOPMENT_APPLICATION_NAME;

//	@Getter
//	Set<Reference> references;

//
//	Example of how to use references. Here we use languages as use case.
//
//	@Getter
//	Set<Reference> languages;

	/**********************************************************************************************************************************************************
	 *
	 * Web functionality initialization
	 *
	 * The @Observer and @Initialized combination will make this application scoped bean load eagerly.
	 *
	 *********************************************************************************************************************************************************/
	public void init(@Observes @Initialized(ApplicationScoped.class) Object object) {

		log.info(" ");
		log.info("°°°°°°°°°°°°°°°° Begin loading common web functionality for " + name + " °°°°°°°°°°°°°°°°");
		log.info("                 --------------------------------------                 ");
		log.info(" ");

		log.debug("Using JSF specification: Vendor: " + FacesContext.class.getPackage().getSpecificationVendor() + " - Version: "
				+ FacesContext.class.getPackage().getSpecificationVersion());
		log.debug("Using JSF implementation: Vendor: " + FacesContext.class.getPackage().getImplementationVendor() + " - Version: "
				+ FacesContext.class.getPackage().getImplementationVersion());

		loadReferences();

		log.info(" ");
		log.info("°°°°°°°°°°°°°°°° End loading common web functionality °°°°°°°°°°°°°°°°");
		log.info("                 ------------------------------------                 ");
		log.info(" ");
	}

	/**********************************************************************************************************************************************************
	 *
	 * Common web functionality for the whole application
	 *
	 *********************************************************************************************************************************************************/

	/**
	 * Loads all application reference used by a public user and uses this as a cache.
	 */
	public void loadReferences() {

//		references = applicationInformation.loadReferences();
//
//		languages = references.stream().filter(r -> r.getCategory().getName().equals(ReferenceType.Thema.name())).sorted()
//				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	/**********************************************************************************************************************************************************
	 *
	 * Fixes - meant for temporary fixes caused by bugs in web frameworks.
	 *
	 *********************************************************************************************************************************************************/

}
