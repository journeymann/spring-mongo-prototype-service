package com.research.services.locator.repositories;

/**
 * Super class for all entity classes.
 * @author cgordon
 *
 * As a policy these methods should always return a org.bson.Document instance class.
 *
 */

public abstract class AbstractRepository{

	public abstract long getSize();
}