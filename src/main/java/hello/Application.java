package hello;

import java.io.PrintWriter;

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
    	
    	String out = "<html><body><h1>Hello Everyone - have a nice day !!</h1><h1>Initial Changes for the dev ops project </h1></body></html>";
       
    	return out;
    }

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
