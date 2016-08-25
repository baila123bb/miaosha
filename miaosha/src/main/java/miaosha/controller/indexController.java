/**
 * 
 */
package miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * 
 * @author "BAILA" 
 * @creation 2016年8月25日 
 */

@Controller
public class indexController extends BaseController {
	
	@RequestMapping("/")
	public String index(){
		System.out.println("spring mvc work");
		System.out.println("test merge");
		System.out.println("test develop merge to master");
		return "index.jsp";
	}
	
	

}
