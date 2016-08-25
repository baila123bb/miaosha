/**
 * 
 */
package miaosha.controller.member;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import miaosha.common.util.DateUtil;
import miaosha.controller.BaseController;

/** 
 * 
 * @author "BAILA" 
 * @creation 2016年8月25日 
 */
@Controller
@RequestMapping("/member")
public class RegisterController extends BaseController {
	
	@RequestMapping("/goRegister")
	public String index(HttpServletRequest request, 
						HttpServletResponse response,
			  			Model model){
		
		Date now = new Date();
		
		String st = DateUtil.toString(now);
		
		model.addAttribute("time", st);
		
		model.addAttribute("xxx", "test");
		
		return "member/register";
	}
	
}
