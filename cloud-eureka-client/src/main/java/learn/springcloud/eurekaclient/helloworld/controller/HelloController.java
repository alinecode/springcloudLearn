package learn.springcloud.eurekaclient.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {
    //private Logger logger = Logger.getLogger("HelloController");

    @RequestMapping(path = "/hello2")
    public String index(){
      //  logger.info("this is "+request.getRequestURI());
    	
//    	int i = 1/0;
//    	System.err.println(i);
    	
        return "HelloWorld666";
    }
}
