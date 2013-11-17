package android.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class PaulampaActivity extends Activity {
	public static boolean f_light_on = true;
	public static boolean blinkabool = false;
	public static boolean blinkakonstigbool = false;
	public static int hejhopp;
    /** Called when the activity is first created. */
	final Camera cam = Camera.open();
	Parameters p = cam.getParameters();

    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	setContentView(R.layout.main);
        
    	
    	
    	final Button f_light_konstig = (Button) findViewById(R.id.button2);
  
		 


    }
    
    public void onDestroy() {
    	super.onDestroy();
    	cam.stopPreview();
    	cam.release();
    	System.exit(0);
    }
}

