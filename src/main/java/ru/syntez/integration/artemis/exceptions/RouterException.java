package ru.syntez.integration.artemis.exceptions;

/**
 * Wrapper over RuntimeException. Includes additional options for formatting message text.
 *
 * @author Skyhunter
 * @date 04.02.2021
 */
public class RouterException extends RuntimeException {

    public RouterException(String message) {
	    super(message);
    }
   
}
