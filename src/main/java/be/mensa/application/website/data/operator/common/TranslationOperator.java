package be.mensa.application.website.data.operator.common;

import javax.enterprise.context.Dependent;

import be.mensa.module.schema.common.Translation;
import be.mensa.module.schema.common.Translation_;
import ci.intern.module.database.operator.main.MainOperator;

/**
 * Operates on entities of type <code>Translation</code>
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Dependent
public class TranslationOperator extends MainOperator<Translation> {

	public Translation translate(String name) {

		conditions.add(b.equal(r.get(Translation_.name), name));

		return find();
	}
}