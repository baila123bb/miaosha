/**
 * 
 */
package miaosha.controller.member;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import miaosha.command.member.memRegistCommand;
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
	
	
	@RequestMapping("/register")
	public String register(
						@ModelAttribute memRegistCommand memRegistCommand,
						HttpServletRequest request, 
						HttpServletResponse response,
			  			Model model){
		//这里就可以判断用户名是否存在之类     然后可以保存到数据库了
		
		System.out.println(memRegistCommand.getUsername());

		
		
		return "member/register";
	}
	
}
