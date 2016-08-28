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

import redis.clients.jedis.Jedis;
import miaosha.controller.BaseController;
import miaosha.manager.ChacheManager;
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
	
	@Autowired
	private ChacheManager chacheManager;
	
	@RequestMapping("/to")
	public String index(HttpServletRequest request, 
						HttpServletResponse response,
			  			Model model){
		Member m = memberManager.findMemById(1);
		System.out.println(m.getUsername());
		
		Boolean value = chacheManager.decr("baila");
		System.out.println("chache value of baila = "+value);
		
//		Jedis jedis = new Jedis("192.168.0.111");
//	    System.out.println("chache value of baila = "+jedis.get("baila"));
//	    jedis.disconnect();
		
		model.addAttribute("ifget", value);
		
		
		return "commons/chat";
	}
	
}
