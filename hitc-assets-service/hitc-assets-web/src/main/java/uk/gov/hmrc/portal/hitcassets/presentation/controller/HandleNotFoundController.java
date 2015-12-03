/**
 * 
 */
package uk.gov.hmrc.portal.hitcassets.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.gov.hmrc.portal.framework.log.PortalLogger;

/**
 * @author cg0631
 *
 */
@Controller
public class HandleNotFoundController
{
  
  /** Logger for class */
  private static final PortalLogger logger = PortalLogger.newInstance( HandleNotFoundController.class );
  
  @RequestMapping(value = { "/handleNotFound" }, method = RequestMethod.GET)
  public String handleNotFound(HttpServletRequest request, HttpServletResponse response)
  {
    String originalUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
    
    logger.warn("Resource not found", originalUri);
    
    response.setStatus(HttpStatus.NOT_FOUND.value());
    
    return null;
  }
}
