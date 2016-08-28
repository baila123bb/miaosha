/**
 * 
 */
package miaosha.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import miaosha.dao.MemberDao;
import miaosha.manager.MemberManager;
import miaosha.model.Member;

/**
 * @author BAILA
 *
 * 2016年8月28日
 */
@Transactional
@Service
public class MemberManagerImpl implements MemberManager {

	@Autowired
	private MemberDao memberDao;

	public Member findMemById(int id) {
		// TODO Auto-generated method stub
		Member member = memberDao.getMemberById(1);
		
		System.out.println(member.getUsername());
		
		return member;
		
	}
	
	

}
