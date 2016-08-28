/**
 * 
 */
package miaosha.manager;

import miaosha.model.Member;

/**
 * @author BAILA
 *
 * 2016年8月28日
 */
public interface MemberManager {
	
	/**
	 * 根据id获取member
	 * @param id
	 * @return
	 */
	public Member findMemById(int id);
	
	
}
