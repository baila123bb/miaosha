/**
 * 
 */
package miaosha.manager;

/**
 * @author BAILA
 *
 * 2016年8月28日
 * 	缓存
 */
public interface ChacheManager {
	
	public String testChache(String key);
	
	public Boolean decr(String key);
	
	public Boolean setValue(String key,Object value);
	
}
