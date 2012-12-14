package edu.unr.cse.paintmobile3d;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }
    
	  @Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.item1:
	    	//Pop-up menu for save, load, clear, share links
	      break;
	    case R.id.item2:
	        //Color picker
	      break;
	    case R.id.item3:
	      startActivity(new Intent(this, SettingsActivity.class));
	      break;

	    default:
	      break;
	    }

	    return true;
	  }
    
}
