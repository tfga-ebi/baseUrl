package org.tfga.baseUrl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;


public class BaseUrlTest {

	@Test
    public void baseUrl() throws Exception {
	    
	    BaseUrl subject = new BaseUrl();
	    
        /*	    
            Portal Dev          https://dev.api.portal.tsi.ebi.ac.uk
            Portal Master       https://api.portal.tsi.ebi.ac.uk
            Local Deployment    http://localhost:8080
            
            With server path    https://api.portal.tsi.ebi.ac.uk/deployments/TSI000000000000001/stopme
            
         */
	    
	    assertEquals( "http://localhost:8080"               , subject.baseURL(mockRequest("localhost", 8080)) );
	    assertEquals( "http://dev.api.portal.tsi.ebi.ac.uk" , subject.baseURL(mockRequest("dev.api.portal.tsi.ebi.ac.uk")) );
	    assertEquals( "http://api.portal.tsi.ebi.ac.uk"     , subject.baseURL(mockRequest("api.portal.tsi.ebi.ac.uk", -1, "/deployments/TSI000000000000001/stopme")) );
    }

	MockHttpServletRequest mockRequest(String host)            {  return mockRequest(host, -1);	          }
	MockHttpServletRequest mockRequest(String host, int port)  {  return mockRequest(host, port, null);   }
	
    MockHttpServletRequest mockRequest(String host, int port, String path) {
        
        MockHttpServletRequest request = new MockHttpServletRequest();
        
        if (path != null)
            request.setRequestURI(path);
	    
//	    request.setLocalPort(8080);
//	    request.setRemotePort(8080);
        
        if (port != -1)
            request.setServerPort(port);
	    
//	    request.setProtocol("https");
	    
//	    request.setRemoteHost("remoteHost");
//	    request.setLocalName("remoteHost");
	    request.setServerName(host);
	    
        return request;
    }
}
