package edu.unr.cse.paintmobile3d;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	final Context context = this;

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

			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
 
			// set title
			alertDialogBuilder.setTitle("Save drawing");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("Do you want to save the current screen?")
				.setCancelable(false)
				.setNegativeButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						//Does nothing for now
						dialog.cancel();
					}
				  })
				.setPositiveButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});
 
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();
	      break;
	    case R.id.item2:
	    	FragmentTransaction ft = getFragmentManager().beginTransaction();
	    	DialogFragment newFragment = new ColorsDialog();
	        newFragment.show(ft, "missiles");
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
