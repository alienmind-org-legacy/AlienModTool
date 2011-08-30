package org.alienmind.alienmod;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public abstract class ScriptedActivity extends ListActivity {

	// These members must be initialited on children onCreate() methods
	String[]       actions = null;
	String[]       descriptions = null;
	TextView       consoleView = null;
	
	// Execution environment
	ScriptExecuter sce = null;

	public ScriptedActivity() {
		super();
	}
	
	public boolean onItemSelected(String itemAction, String itemDescription) {
		// Override on children
		// Return false is action aborted
		return true;
	}
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		sce          = new ScriptExecuter();
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, descriptions));
	
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
	
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				String action      = actions[position];
				String description = ((TextView) view).getText().toString();
				
				// Allow children to inhibit execution / switch to console / whatever
				if (!onItemSelected(action, description)) {
			      return;
				}				
				
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
						Toast.LENGTH_SHORT).show();				
				try {
					sce.execute(action, consoleView);
				} catch (Exception e) {
					AlienModTool.getInstance().getConsoleView().append(e.getStackTrace().toString() + "\n");
				}								
			}
		});
	}

}