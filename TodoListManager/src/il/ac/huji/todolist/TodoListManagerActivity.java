package il.ac.huji.todolist;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class TodoListManagerActivity extends Activity {
	
	private Resources res;
	private String[] _tasks;
	private ListView listView; 
	private ArrayAdapter<String> todoAdapter;
	private EditText edtNewItem; 
	private ArrayList<String> arrayList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo_list_manager);
		
		res = getResources();
		//tasks = res.getStringArray(R.array.tasks);
		arrayList = new ArrayList<String>();
		arrayList.add("");
		_tasks = arrayList.toArray(new String[1]);
		listView = (ListView)findViewById(R.id.lstTodoItems); 
		todoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _tasks); 
		listView.setAdapter(todoAdapter);
		
		edtNewItem = (EditText)findViewById(R.id.edtNewItem);
		
		registerForContextMenu(listView); 
	}
	
	public void onCreateContextMenu( ContextMenu menu, View v, ContextMenuInfo info) { 
		super.onCreateContextMenu(menu, v, info); 
		getMenuInflater().inflate(R.menu.context_menu, menu); 
    	//Can set the header title based on context 
	}
	public boolean onContextItemSelected(MenuItem item) { 
		AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo(); 
		 //Now, info.position is the index of the city 
		 switch (item.getItemId()) {
		
		 }
		return false;
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.todo_list_manager, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) { 
		switch (item.getItemId()) {
			case R.id.menuItemAdd : {
				String str = edtNewItem.getText().toString();
				str = str.trim();
				if(str!="") {
					Log.e("here is ",edtNewItem.getText().toString());
					arrayList = new ArrayList<String>(Arrays.asList(_tasks));
					arrayList.add(str);
					_tasks = arrayList.toArray(new String[arrayList.size()]);
					return true;
				}
				else {
					return false;
				}
			}
		} 
		return false;
	}
}
