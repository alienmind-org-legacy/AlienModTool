package org.alienmind.alienmod;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

public class AlienModTool extends TabActivity {
	TextView   consoleView = null;
	
	public static final int TAB_ACTIONS = 0;
	public static final int TAB_UV = 1;
	public static final int TAB_EXTRA = 2;
	public static final int TAB_CONSOLE = 3;	
	
	/// Singleton //////////////////////////////////////////
    private static AlienModTool INSTANCE = null;     

    private synchronized static void setInstance(AlienModTool theInstance) {
        if (INSTANCE == null) { 
            INSTANCE = theInstance;
        }
    }
    public static AlienModTool getInstance() {
        return INSTANCE;
    }	
	public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
	}
	////////////////////////////////////////////////////////
		
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
	    // So we an get it later
	    AlienModTool.setInstance(this);
	    
	    Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    // Actions tab
	    intent = new Intent().setClass(this, ActionsActivity.class);	    
	    spec = tabHost.newTabSpec("actions").setIndicator("Actions",
	                      res.getDrawable(R.drawable.ic_tab_actions))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    // UV tab
	    intent = new Intent().setClass(this, UVActivity.class);
	    spec = tabHost.newTabSpec("uv").setIndicator("UV Settings",
	                      res.getDrawable(R.drawable.ic_tab_uv))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    // Extras tab
	    intent = new Intent().setClass(this, ExtrasActivity.class);
	    spec = tabHost.newTabSpec("extras").setIndicator("Extras",
	                      res.getDrawable(R.drawable.ic_tab_extras))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    // Console tab
	    intent = new Intent().setClass(this, ConsoleActivity.class);
	    spec = tabHost.newTabSpec("console").setIndicator("Console",
	                      res.getDrawable(R.drawable.ic_tab_console))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    	    
	    tabHost.setCurrentTab(TAB_CONSOLE);
	}

	public void setConsoleView(TextView textView) {
		consoleView = textView;		
	}

	public TextView getConsoleView() {
		return consoleView;
	}
}