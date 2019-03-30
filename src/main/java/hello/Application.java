package hello;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {

        // return "** Hello Docker World - Message 02/16 - Kubernetes **";
    	
    	 InetAddress ip;
         String hostname = null;
         try {
             ip = InetAddress.getLocalHost();
             hostname = ip.getHostName();
             System.out.println("Your current IP address : " + ip);
             System.out.println("Your current Hostname : " + hostname);
  
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
    			"    <td>SUBSCRIBER NAME</th>\n" + 
    			"    <td>JOHN DOE</th>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>PLAN NAME</th>\n" + 
    			"    <td>HMO Blue NE Deductible</th>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>PCP NAME</td>\n" + 
    			"    <td>DR. Mark</td>\n" + 
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
    			"    <td>INDIVIDUAL DEDUCTIBLE MET </th>\n" + 
    			"    <td>$700</th>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>FAMILY DEDUCTIBLE MET</th>\n" + 
    			"    <td>$2000</th>\n" + 
    			"  </tr>\n" + 
    			"  <tr>\n" + 
    			"    <td>CHIRO VISITS LEFT</td>\n" + 
    			"    <td>6/10</td>\n" + 
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
