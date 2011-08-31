package org.alienmind.alienmod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.widget.TextView;


public class ScriptExecuter extends Thread {
	static final String CMD_SU="/system/xbin/su";
	static final String CMD_C="-c";
	String   script      = null;
		
	public void setScript(String script) {
		this.script = script;
	}
	
	public void run() {
		String   inputLine = null;
		String[] str={CMD_SU,CMD_C,script};
		TextView consoleView  = AlienModTool.getInstance().getConsoleView();		
		
		if (script == null || consoleView == null)
			return;		
		try {
			consoleView.append("==== Starting execution: " + script + " ====\n");			
			Process p = Runtime.getRuntime().exec(str);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((inputLine = br.readLine()) != null) 
				consoleView.append(inputLine + "\n");
			int ret = p.waitFor();
			consoleView.append("== Finished, return value is " + ret + " ==\n");
		} catch (Exception e) {			
			consoleView.append(e.toString() + "\n");
		}
	}
}
