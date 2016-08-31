/**
 * 
 */
package miaosha.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;
import miaosha.manager.ChacheManager;


@Service
@Transactional
public class ChacheManagerImpl implements ChacheManager {
	
	@Autowired
	private JedisPool jedisPool;
	
	
	public String testChache(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		String value  = jedis.get(key);
		jedisPool.returnBrokenResource(jedis);
		return value;
	}

	public synchronized Boolean decr(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		Long value  = jedis.decrBy(key, 1);
		System.out.println("value = "+value);
		//jedisPool.returnBrokenResource(jedis);
		jedisPool.returnResource(jedis);
		return value>=-1;
	}

	public Boolean setValue(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
