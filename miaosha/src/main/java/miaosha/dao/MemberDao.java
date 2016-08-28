/**
 * 
 */
package miaosha.dao;

import org.springframework.stereotype.Repository;

import miaosha.model.Member;


/**
 * @author BAILA
 *
 * 2016年8月28日
 */

@Repository
public interface MemberDao {
	Member getMemberById(int id);
}
