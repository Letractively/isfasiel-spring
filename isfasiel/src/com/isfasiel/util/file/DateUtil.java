package com.isfasiel.util.file;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
/**
 * 
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.util.file
 * @FileName  : DateUtil.java
 * @Date         : 2011. 2. 19. 
 * Description : it is a class to make a path from date
 */
@Component
public class DateUtil {
	public String dateToPath() {
		Date dateNow = new Date ();
		 
		SimpleDateFormat dateformatYYYYMMDD = new SimpleDateFormat("yyyy/MM/dd");
		StringBuilder nowYYYYMMDD = new StringBuilder( dateformatYYYYMMDD.format( dateNow ) );
		return nowYYYYMMDD.toString();

	}
}
