/**
 * 
 */
package it.academy.ivan.command;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ivan
 *
 */
public interface ActionCommand {

	String execute(HttpServletRequest request);
	
}
