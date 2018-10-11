package org.tfga.baseUrl;

import static java.lang.String.format;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;


public class BaseUrl {

	public String baseURL(HttpServletRequest request) throws MalformedURLException {
	    
	    String requestUrl = request.getRequestURL().toString(); // includes the server path
	    
	    // Let's remove it
	    URL url = new URL(requestUrl);
	    
        return String.format("%s://%s%s" , url.getProtocol()
	                                     , url.getHost()
	                                     , getPortStr(url)
	                                     );
    }

    String getPortStr(URL url) {
        
        int port = url.getPort();
	    
	    return port == -1 ? ""
                          : format(":%d", port)
  	                      ;
    }
}
