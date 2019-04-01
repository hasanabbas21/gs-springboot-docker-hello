package hello;

import java.awt.List;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
@RestController
public class Application {

	int counter = 0;
	 HashMap<String, Integer> hmap = new HashMap<String, Integer>();
	 
    @RequestMapping("/")
    public String home(HttpServletRequest request) {

        // return "** Hello Docker World - Message 02/16 - Kubernetes **";
    	
    	 InetAddress ip;
         String hostname = null;
         counter++;
         String deviceType = null;
         
         try {
             ip = InetAddress.getLocalHost();
             hostname = request.getHeader("X-FORWARDED-FOR");
             System.out.println("Your current IP address : " + ip);
             System.out.println("Your current Hostname : " + hostname);
             System.out.println("Count " + counter);
            
             
             if(request.getHeader("User-Agent").indexOf("Mobile") != -1) {
            	    deviceType = "MOBILE";
            	  } else {
            	    deviceType = "NON MOBILE";
            	  }
             
             if (hmap.containsKey(hostname)) {
                 System.out.println("Key Exists for hostname " + hostname);
            	 hmap.put(hostname, hmap.get(hostname) + 1);
             } else {
            	 System.out.println("Key Does Not Exist");
            	 hmap.put(hostname, 1);
             }
              
  
         } catch (UnknownHostException e) {
  
             e.printStackTrace();
         }

    	String html = "<!DOCTYPE html>\n" + 
    			"<html>\n" + 
    			"<head>\n" + 
    			"<style>\n" + 
    			"table {\n" + 
    			"  font-family: arial, sans-serif;\n" + 
    			"  border-collapse: collapse;\n" + 
    			"  width: 40%;\n" + 
    			"}\n" + 
    			"\n" + 
    			"td, th {\n" + 
    			"  border: 1px solid #dddddd;\n" + 
    			"  text-align: left;\n" + 
    			"  padding: 8px;\n" + 
    			"}\n" + 
    			"\n" + 
    			"tr:nth-child(even) {\n" + 
    			"  background-color: #dddddd;\n" + 
    			"}\n" + 
    			"</style>\n" + 
    			"</head>\n" + 
    			"<body>\n" + 
    			"\n" + 
    			"<h2>MEMBER ELIGIBILITY</h2>\n" + 
    			"\n" + 
    			"<table>\n" + 
    			"  <tr>\n" + 
    			"    <th>SUBSCRIBER #</th>\n" + 
    			"    <th>MTN123456789</th>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>SUBSCRIBER NAME</td>\n" + 
    			"    <td>JOHN DOE</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>PLAN NAME</td>\n" + 
    			"    <td>HMO Blue NE Deductible</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>PCP NAME</td>\n" + 
    			"    <td>DR. TED</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>CO PAY</td>\n" + 
    			"    <td>$25</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>SUBSCRIBER DOB</td>\n" + 
    			"    <td>1/1/1980</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>MAX OUT OF POCKET</td>\n" + 
    			"    <td>$2500</td>\n" + 
    			"  </tr>\n" + 
    			"</table>\n" + 
    			"\n" + 
    			"\n" + 
    			"<h2>ACCUMULATIONS</h2>\n" + 
    			"\n" + 
    			"<table>\n" + 
    			"  <tr>\n" + 
    			"    <th>SUBSCRIBER #</th>\n" + 
    			"    <th>MTN123456789</th>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>INDIVIDUAL DEDUCTIBLE MET </td>\n" + 
    			"    <td>$700</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>FAMILY DEDUCTIBLE MET</td>\n" + 
    			"    <td>$2000</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>CHIRO VISITS LEFT</td>\n" + 
    			"    <td>6/10</td>\n" + 
    			"  </tr>\n" + 
    			"</table>\n" + 
				"\n" + 
				"\n" + 
    			"<h2>ANALYTICS</h2>\n" + 
    			"\n" + 
				"<table>\n" + 
				"  <tr>\n" + 
    			"    <th>DEVICE TYPE</th>\n" + 
    			"    <th>"+ deviceType +"</th>\n" + 
    			"  </tr>\n" + 
				"  <tr>\n" + 
				"    <td>SERVICE CALL COUNTER </td>\n" + 
				"    <td>"+counter+"</td>\n" + 
				"  </tr>\n" + 
				"</table>\n" + 
    			"</body>\n" + 
    			"</html>";
       
    	return html;
    }
 
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
