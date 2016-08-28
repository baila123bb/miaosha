/**
 * 
 */
package miaosha.controller.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import miaosha.controller.BaseController;
import miaosha.manager.MemberManager;
import miaosha.model.Member;

/** 
 * 
 * @author "BAILA" 
 * @creation 2016年8月25日 
 * test master
 */
@Controller
@RequestMapping("/chat")
public class chatController extends BaseController {
	
	@Autowired
	private MemberManager memberManager;
	
	@RequestMapping("/to")
	public String index(HttpServletRequest request, 
						HttpServletResponse response,
			  			Model model){
		Member m = memberManager.findMemById(1);
		System.out.println(m.getUsername());
		
		return "commons/chat";
	}
	
}
