package de.novatec.rest.clinic.exception;

/**
 * Exception for when attempting to create a resource which already exists.
 */
public class ResourceAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistsException() {
        super();
    }

}
