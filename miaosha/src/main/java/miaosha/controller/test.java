package miaosha.controller;

import redis.clients.jedis.Jedis;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("192.168.0.111");
	    long start = System.currentTimeMillis();
	    for (int i = 0; i < 100000; i++) {
	        String result = jedis.set("test" + i, "n" + i);
	    }
	    long end = System.currentTimeMillis();
	    System.out.println("Simple SET: " + ((end - start)/1000.0) + " seconds");
		
//		String name = jedis.get("baila");
//		System.out.println(name);
		
	    jedis.disconnect();
	}

}
