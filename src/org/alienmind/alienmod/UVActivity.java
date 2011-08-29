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

public class UVActivity extends ListActivity {
	String[] actions;
	String[] descriptions;
	ScriptExecuter sce = null;
	
    public void onCreate(Bundle savedInstanceState) {
    	/*
        super.onCreate(savedInstanceState);
        TextView textview = new TextView(this);
        textview.setText("This is the UV tab");
        setContentView(textview);    
        */
		super.onCreate(savedInstanceState);

		sce          = new ScriptExecuter();
		actions      = getResources().getStringArray(R.array.uv_actions_array);
		descriptions = getResources().getStringArray(R.array.uv_descriptions_array);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, descriptions));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
						Toast.LENGTH_SHORT).show();
				
				try {
					sce.execute(actions[position]);
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(), e.getStackTrace().toString(), Toast.LENGTH_LONG).show();
				} 
				
			}
		});
    }
}