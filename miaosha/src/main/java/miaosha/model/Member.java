/**
 * 
 */
package miaosha.model;

import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 * @author BAILA
 *
 * 2016年8月27日
 */
@Component
public class Member implements Serializable{

	private static final long serialVersionUID = -4030575153639302655L;
	
	private static Integer mem_status_init = 0;
	private static Integer mem_status_life = 1;
	private static Integer mem_status_disabled = 3;
	
	private int id;
	private String username;
	private String email;
	private String password;
	private String mobile;
	private Integer status;
	
	public Member(){
		this.status = Member.mem_status_init;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
	
	
	
}
