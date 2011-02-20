package com.isfasiel.util.file;

import java.io.File;
import org.springframework.stereotype.Component;

/**
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.util.file
 * @FileName  : DirUtil.java
 * @Date         : 2011. 2. 19. 
 * Description : It is a utility class for a directory.
 */
@Component
public class DirUtil {
	
	long dirId = -1;
	String phyName = null;
	String dirType = null;
	
	public long getDirId() {
		return dirId;
	}

	public void setDirId(long dirId) {
		this.dirId = dirId;
	}

	public String getPhyPath() {
		return phyName;
	}

	public void setPhyName(String phyName) {
		this.phyName = phyName;
	}

	public String getDirType() {
		return dirType;
	}

	public void setDirType(String dirType) {
		this.dirType = dirType;
	}

	public boolean mkDir(String dirName) {
		boolean state = true;
		try {
			File dir = new File(dirName);
			if( !dir.exists() ) {
				state = dir.mkdirs();
			} else {
				state = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			state = false;
		}
		return state;
	}
	
	public boolean rmDir(File dir) {
		boolean state = true;
		try {
			if( !dir.exists() ) {
				return false;
			}
			File[] files = dir.listFiles();
			
			for(File file : files) {
				if( file.isDirectory() ) {
					rmDir(file);
				} else {
					file.delete();
				}
			}
			dir.delete();
		} catch (Exception e) {
			e.printStackTrace();
			state = false;
		}
		return state;
	}
	
	public boolean rmDir(String dirName) {
		boolean state = true;
		try {
			File dir = new File(dirName);
			return rmDir(dir);
		} catch (Exception e ) {
			e.printStackTrace();
			state = false;
		}
		return state;
	}
	
	public boolean mvDir(String dirName, String newDirName) {
		boolean state = true;
		dirName = dirName.replaceAll("\\\\", "/");
		newDirName = newDirName.replaceAll("\\\\", "/");
		try {
			File dir = new File(dirName);
			File newDir = new File(newDirName);
			if(!dir.exists() || newDir.exists() ) {
				return false;
			}
			dir.renameTo(newDir);
		} catch (Exception e ) {
			e.printStackTrace();
			state = false;
		}
		return state;
	}
	
}
