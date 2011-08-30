package org.alienmind.alienmod;

import android.os.Bundle;


public class ExtrasActivity extends ScriptedActivity {
	public boolean onItemSelected(String itemAction, String itemDescription) {
		AlienModTool.getInstance().getTabHost().setCurrentTab(AlienModTool.TAB_CONSOLE);
		return true;
	}
	
	public void onCreate(Bundle savedInstanceState) {
		this.consoleView  = AlienModTool.getInstance().getConsoleView();		
		this.actions      = getResources().getStringArray(R.array.extra_actions_array);
		this.descriptions = getResources().getStringArray(R.array.extra_descriptions_array);
		super.onCreate(savedInstanceState);		
	}	
}