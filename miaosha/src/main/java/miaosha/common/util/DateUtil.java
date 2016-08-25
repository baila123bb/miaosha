/**
 * 
 */
package miaosha.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * 
 * @author "BAILA" 
 * @creation 2016年8月25日 
 */
public class DateUtil {
	public static SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String toString(Date date){
		return simple.format(date);
	}

	
}
