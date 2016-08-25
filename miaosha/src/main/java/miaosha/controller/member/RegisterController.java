/**
 * 
 */
package miaosha.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String index(){
		System.out.println("go to regist");
		return "member/register";
	}
	
}
