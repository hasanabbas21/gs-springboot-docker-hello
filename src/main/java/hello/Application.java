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
            	    deviceType = "WEB";
            	  }
             
             if (hmap.containsKey(hostname)) {
                 System.out.println("Key Exists for hostname " + hostname);
            	 hmap.put(hostname, hmap.get(hostname) + 1);
             } else {
            	 System.out.println("Key Does Not Exist for ");
            	 hmap.put(hostname, 1);
             }
              
  
         } catch (UnknownHostException e) {
  
             e.printStackTrace();
         }
    	
    	String s2 = "<!DOCTYPE html>\n" + 
    			"<html>\n" + 
    			"<head>\n" + 
  
    			"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
    			"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" + 
    			"<style>\n" + 
    			"table {\n" + 
    			"  font-family: arial, sans-serif;\n" + 
    			"  border-collapse: collapse;\n" + 
    			"  width: 95%;\n" + 
    			"}\n" + 
    			"\n" + 
    			"td, th {\n" + 
    			"  border: 1px solid #dddddd;\n" + 
    			"  text-align: left;\n" + 
    			"  padding: 8px;\n" + 
    			"}\n" + 
    			" th {\n" + 
    			"  background-color: #917535;\n" + 
    			"}\n" + 
    			"\n" + 
    			"tr:nth-child(even) {\n" + 
    			"  background-color: #dddddd;\n" + 
    			"}\n" + 
    			"body {\n" + 
    			"  font-family: Arial, Helvetica, sans-serif;\n" + 
    			"}\n" + 
    			"\n" + 
    			".mobile-container {\n" + 
    			"  max-width: 480px;\n" + 
    			"  margin: auto;\n" + 
    			"  background-color: #107896;\n" + 
    			"  overflow: auto;\n" + 
    			"  color: white;\n" + 
    			"  border-radius: 10px;\n" + 
    			"  padding-bottom: 25px;\n" +
    			"}\n" + 
    			"\n" + 
    			".topnav {\n" + 
    			"  overflow: hidden;\n" + 
    			"  background-color: #333;\n" + 
    			"  position: relative;\n" + 
    			"}\n" + 
    			"\n" + 
    			".topnav #myLinks {\n" + 
    			"  display: none;\n" + 
    			"}\n" + 
    			"\n" + 
    			".topnav a {\n" + 
    			"  color: white;\n" + 
    			"  padding: 14px 16px;\n" + 
    			"  text-decoration: none;\n" + 
    			"  font-size: 17px;\n" + 
    			"  display: block;\n" + 
    			"}\n" + 
    			"\n" + 
    			".topnav a.icon {\n" + 
    			"  background: black;\n" + 
    			"  display: block;\n" + 
    			"  position: absolute;\n" + 
    			"  right: 0;\n" + 
    			"  top: 0;\n" + 
    			"}\n" + 
    			"\n" + 
    			".topnav a:hover {\n" + 
    			"  background-color: #ddd;\n" + 
    			"  color: black;\n" + 
    			"}\n" + 
    			"\n" + 
    			".active {\n" + 
    			"  background-color: #4CAF50;\n" + 
    			"  color: white;\n" + 
    			"}\n" + 
    			"</style>\n" + 
    			"</head>\n" + 
    			"<body>\n" + 
    			"\n" + 
    			"<!-- Simulate a smartphone / tablet -->\n" + 
    			"<div class=\"mobile-container\">\n" + 
    			"\n" + 
    			"<!-- Top Navigation Menu -->\n" + 
    			"<div class=\"topnav\">\n" + 
    			"  <a href=\"#home\" class=\"active\"><b>ETEDX - BLUE CROSS BLUE SHIELD OF MA</b></a>\n" + 
    			"  <div id=\"myLinks\">\n" + 
    			"    <a href=\"#about\">About</a>\n" + 
    			"  </div>\n" + 
    			"  <a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\n" + 
    			"    <i class=\"fa fa-bars\"></i>\n" + 
    			"  </a>\n" + 
    			"</div>\n" + 
    			"\n" + 
    			"<div style=\"padding-left:16px\">\n" + 
    			"  <h2>PLAN SEARCH API - v2</h2>\n" + 
    			"  <p>This api returns a list of plans that are active as of date and a list of canceled plans in the last 2 years</p>\n" + 
    			"<table>\n" + 
    			"  <tr>\n" + 
    			"    <th>PLAN NAME</th>\n" + 
    			"    <th>PLAN TYPE</th>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>HMO Blue NE Premier Value with Coin</td>\n" + 
    			"    <td>MEDICAL</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>HMO Blue NE Options Deductible</td>\n" + 
    			"    <td>MEDICAL</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>HMO Blue New England Enhanced Value</td>\n" + 
    			"    <td>MEDICAL</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>HMO Blue Select Deductible</td>\n" + 
    			"    <td>MEDICAL</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>Preferred Blue PPO Options Deductible</td>\n" + 
    			"    <td>MEDICAL</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>Dental Blue Pediatric Essential Benefits</td>\n" + 
    			"    <td>DENTAL</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>Dental Blue Pediatric Essential Benefits</td>\n" + 
    			"    <td>DENTAL</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>Dental Blue Pediatric + Adult 2</td>\n" + 
    			"    <td>DENTAL</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>Dental Blue Pediatric + Adult Preventive</td>\n" + 
    			"    <td>DENTAL</td>\n" + 
    			"  </tr>\n" + 
    			"</table>\n" + 
    			"\n" + 
    			"\n" + 
    			"<h2>CANCELED PLANS</h2>\n" + 
    			"\n" + 
				"<table>\n" + 
    			"  <tr>\n" + 
    			"    <th>PLAN NAME</th>\n" + 
    			"    <th>CANCEL DATE</th>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>Blue Choice Plan 2 Value Plus</td>\n" + 
    			"    <td>2018-12-31</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>HMO Blue Enhanced Value</td>\n" + 
    			"    <td>2018-12-31</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>PPO Student Health Plan</td>\n" + 
    			"    <td>2017-05-31</td>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>Network Blue Premier Value</td>\n" + 
    			"    <td>2018-12-31</td>\n" + 
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
				"    <td>NUMBER OF REQUESTS</td>\n" + 
				"    <td>"+counter+"</td>\n" + 
				"  </tr>\n" + 
    			"\n" + 
    			"\n" + 
    			"</div>\n" + 
    			"\n" + 
    			"<!-- End smartphone / tablet look -->\n" + 
    			"</div>\n" + 
    			"\n" + 
    			"<script>\n" + 
    			"function myFunction() {\n" + 
    			"  var x = document.getElementById(\"myLinks\");\n" + 
    			"  if (x.style.display === \"block\") {\n" + 
    			"    x.style.display = \"none\";\n" + 
    			"  } else {\n" + 
    			"    x.style.display = \"block\";\n" + 
    			"  }\n" + 
    			"}\n" + 
    			"</script>\n" + 
    			"\n" + 
    			"</body>\n" + 
    			"</html>";
       
    	return s2;
    }
 
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
