package org.ws.core;

/**
 * the factory interface.
 * @author Achilles Liu
 *
 * @param <T>
 */
public interface Factory<T> {
	T create(String type);
}
