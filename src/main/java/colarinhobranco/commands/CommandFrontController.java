/**
 * 
 */
package colarinhobranco.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Delano Jr
 *
 */
public interface CommandFrontController {

	public void dispatcher(HttpServletRequest request, HttpServletResponse response);
}
