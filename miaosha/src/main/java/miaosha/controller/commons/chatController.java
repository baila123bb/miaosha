/**
 * 
 */
package miaosha.controller.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import miaosha.controller.BaseController;

/** 
 * 
 * @author "BAILA" 
 * @creation 2016年8月25日 
 * test master
 */
@Controller
@RequestMapping("/chat")
public class chatController extends BaseController {
	
	@RequestMapping("/to")
	public String index(HttpServletRequest request, 
						HttpServletResponse response,
			  			Model model){
	
		return "commons/chat";
	}
	
}
