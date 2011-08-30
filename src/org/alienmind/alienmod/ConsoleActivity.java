package org.alienmind.alienmod;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ConsoleActivity extends Activity {
	TextView consoleTextView = null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        consoleTextView = new TextView(this);
        consoleTextView.setText("");
        setContentView(consoleTextView);
        AlienModTool.getInstance().setConsoleView(consoleTextView);
        AlienModTool.getInstance().getTabHost().setCurrentTab(AlienModTool.TAB_ACTIONS);        
    }    
}