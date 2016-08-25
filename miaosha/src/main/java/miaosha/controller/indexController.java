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
		return "index.jsp";
	}
	
	

}
