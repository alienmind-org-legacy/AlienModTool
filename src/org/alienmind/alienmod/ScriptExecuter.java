package org.alienmind.alienmod;


public class ScriptExecuter {
	static final String CMD_SU="/system/xbin/su";
	static final String CMD_C="-c";	
	
	void execute(String script) throws Exception {
		String[] str={CMD_SU,CMD_C,script};				
		Process p = Runtime.getRuntime().exec(str);
		//p.getInputStream().read(b, offset, length);				
	}
}
