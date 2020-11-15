package be.mensa.application.website.view.configuration;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

/**
 * Configuration file to ensure extensionless url's with Rewrite framework from ocpsoft
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@RewriteConfiguration
public class ExtensionlessConfiguration extends HttpConfigurationProvider {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.ocpsoft.common.pattern.Weighted#priority()
	 */
	@Override
	public int priority() {
		return 10;
	}

	/*
	 * Pattern added to only check for characters. We need this, because we have to add Google SEO files in the root location which are not xhtml files.
	 *
	 * (non-Javadoc)
	 *
	 * @see org.ocpsoft.rewrite.config.ConfigurationProvider#getConfiguration(java.lang.Object)
	 */
	@Override
	public Configuration getConfiguration(final ServletContext context) {
		return ConfigurationBuilder.begin().addRule(Join.path("/{param}").to("/{param}.html")).where("param").matches("[A-Za-z]+")
				.addRule(Join.path("/member/").to("/member/member.html")).addRule(Join.path("/member/{param}").to("/member/{param}.html"))
				.addRule(Join.path("/").to("/index.html"));
	}
}