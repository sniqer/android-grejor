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
import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;

import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Button;
import android.widget.PlaySound;
import android.widget.Toast;
import android.app.Activity;
import android.app.R;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Spinner;



public class PaulampaActivity extends Activity {
	public static boolean f_light_on = true;
	public static boolean blinkabool = false;
	public static boolean blinkakonstigbool = false;
	public static int hejhopp;
	int freqchanger = 0;
	String soundOptions = "Normal";
	int tuneLength = 1000;
	int soundArrLength = 2000;
	int sleep_time = 175;
	boolean hold_sleep_time = false;
	String spinnervalue; 
	
	
	
	boolean c1hold = false;
	boolean d1hold = false;
	boolean e1hold = false;
	boolean f1hold = false;
	boolean g1hold = false;
	boolean a1hold = false;
	boolean h1hold = false;
	boolean c1shhold = false;
	boolean d1shhold = false;
	boolean f1shhold = false;
	boolean g1shhold = false;
	boolean a1shhold = false;

	boolean c2hold = false;
	boolean d2hold = false;
	boolean e2hold = false;
	boolean f2hold = false;
	boolean g2hold = false;
	boolean a2hold = false;
	boolean h2hold = false;
	boolean c2shhold = false;
	boolean d2shhold = false;
	boolean f2shhold = false;
	boolean g2shhold = false;
	boolean a2shhold = false;
	
	boolean c3hold = false;
	boolean d3hold = false;
	boolean e3hold = false;
	boolean f3hold = false;
	boolean g3hold = false;
	boolean a3hold = false;
	boolean h3hold = false;
	boolean c3shhold = false;
	boolean d3shhold = false;
	boolean f3shhold = false;
	boolean g3shhold = false;
	boolean a3shhold = false;
	
	final int ctune = 262;
	final int dtune = 293;
	final int etune = 330;
	final int ftune = 349;
	final int gtune = 392;
	final int atune = 440;
	final int htune = 494;
	final int cshtune = 277;
	final int dshtune = 311;
	final int fshtune = 370;
	final int gshtune = 415;
	final int ashtune = 466;
	

	byte[] arrSoundc1 = new byte[ctune];
	byte[] arrSoundd1 = new byte[dtune];
	byte[] arrSounde1 = new byte[etune];
	byte[] arrSoundf1 = new byte[ftune];
	byte[] arrSoundg1 = new byte[gtune];
	byte[] arrSounda1 = new byte[atune];
	byte[] arrSoundh1 = new byte[htune];
	byte[] arrSoundc1sh = new byte[cshtune];
	byte[] arrSoundd1sh = new byte[dshtune];
	byte[] arrSoundf1sh = new byte[fshtune];
	byte[] arrSoundg1sh = new byte[gshtune];
	byte[] arrSounda1sh = new byte[ashtune];
	byte[] arrSoundc2 = new byte[ctune * 2];
	byte[] arrSoundd2 = new byte[dtune * 2];
	byte[] arrSounde2 = new byte[etune * 2];
	byte[] arrSoundf2 = new byte[ftune * 2];
	byte[] arrSoundg2 = new byte[gtune * 2];
	byte[] arrSounda2 = new byte[atune * 2];
	byte[] arrSoundh2 = new byte[htune * 2];
	byte[] arrSoundc2sh = new byte[cshtune * 2];
	byte[] arrSoundd2sh = new byte[dshtune * 2];
	byte[] arrSoundf2sh = new byte[fshtune * 2];
	byte[] arrSoundg2sh = new byte[gshtune * 2];
	byte[] arrSounda2sh = new byte[ashtune * 2];
	byte[] arrSoundc3 = new byte[ctune * 4];
	byte[] arrSoundd3 = new byte[dtune * 4];
	byte[] arrSounde3 = new byte[etune * 4];
	byte[] arrSoundf3 = new byte[ftune * 4];
	byte[] arrSoundg3 = new byte[gtune * 4];
	byte[] arrSounda3 = new byte[atune * 4];
	byte[] arrSoundh3 = new byte[htune * 4];
	byte[] arrSoundc3sh = new byte[cshtune * 4];
	byte[] arrSoundd3sh = new byte[dshtune * 4];
	byte[] arrSoundf3sh = new byte[fshtune * 4];
	byte[] arrSoundg3sh = new byte[gshtune * 4];
	byte[] arrSounda3sh = new byte[ashtune * 4];
	
	final PlaySound soundc1 = new PlaySound(ctune);
	final PlaySound soundd1 = new PlaySound(dtune);
	final PlaySound sounde1 = new PlaySound(etune);
	final PlaySound soundf1 = new PlaySound(ftune);
	final PlaySound soundg1 = new PlaySound(gtune);
	final PlaySound sounda1 = new PlaySound(atune);
	final PlaySound soundh1 = new PlaySound(htune);
	final PlaySound soundc1sh = new PlaySound(cshtune);
	final PlaySound soundd1sh = new PlaySound(dshtune);
	final PlaySound soundf1sh = new PlaySound(fshtune);
	final PlaySound soundg1sh = new PlaySound(gshtune);
	final PlaySound sounda1sh = new PlaySound(ashtune);
	final PlaySound soundc2 = new PlaySound(ctune * 2);
	final PlaySound soundd2 = new PlaySound(dtune * 2);
	final PlaySound sounde2 = new PlaySound(etune * 2);
	final PlaySound soundf2 = new PlaySound(ftune * 2);
	final PlaySound soundg2 = new PlaySound(gtune * 2);
	final PlaySound sounda2 = new PlaySound(atune * 2);
	final PlaySound soundh2 = new PlaySound(htune * 2);
	final PlaySound soundc2sh = new PlaySound(cshtune * 2);
	final PlaySound soundd2sh = new PlaySound(dshtune * 2);
	final PlaySound soundf2sh = new PlaySound(fshtune * 2);
	final PlaySound soundg2sh = new PlaySound(gshtune * 2);
	final PlaySound sounda2sh = new PlaySound(ashtune * 2);
	final PlaySound soundc3 = new PlaySound(ctune * 4);
	final PlaySound soundd3 = new PlaySound(dtune * 4);
	final PlaySound sounde3 = new PlaySound(etune * 4);
	final PlaySound soundf3 = new PlaySound(ftune * 4);
	final PlaySound soundg3 = new PlaySound(gtune * 4);
	final PlaySound sounda3 = new PlaySound(atune * 4);
	final PlaySound soundh3 = new PlaySound(htune * 4);
	final PlaySound soundc3sh = new PlaySound(cshtune * 4);
	final PlaySound soundd3sh = new PlaySound(dshtune * 4);
	final PlaySound soundf3sh = new PlaySound(fshtune * 4);
	final PlaySound soundg3sh = new PlaySound(gshtune * 4);
	final PlaySound sounda3sh = new PlaySound(ashtune * 4);
	
	
    /** Called when the activity is first created. */
	final Camera cam = Camera.open();
	Parameters p = cam.getParameters();
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	setContentView(R.layout.main);
        
    	
    	
    	final Button f_light_konstig = (Button) findViewById(R.id.Button2);
        final Button f_light_blinka  = (Button) findViewById(R.id.search_button);
        final Button f_light_button  = (Button) findViewById(R.id.Button3);
  
		 
        new Thread(new Runnable() { 
            public void run(){

            	while(true)
        		{
            		
            		
            			  
            			  
            		
            		
            		
            		
            		if(blinkabool)
            		{
            			try{
		        			p.setFlashMode(Parameters.FLASH_MODE_TORCH);
		        			cam.setParameters(p);
		        			cam.startPreview();
		        			Thread.sleep(130);
		        			
		        			p.setFlashMode(Parameters.FLASH_MODE_OFF);
		        			cam.setParameters(p);
		        			cam.startPreview();
		        			Thread.sleep(130);
		        			
            			} catch (Exception e){
            				;
            			}
            			
            		}
            		else if(blinkakonstigbool)
            		{
            			try{
		        			p.setFlashMode(Parameters.FLASH_MODE_TORCH);
		        			cam.setParameters(p);
		        			cam.startPreview();
		        			Thread.sleep(230);
		        			
		        			p.setFlashMode(Parameters.FLASH_MODE_OFF);
		        			cam.setParameters(p);
		        			cam.startPreview();
		        			Thread.sleep(90);
		        			
		        			
		        			p.setFlashMode(Parameters.FLASH_MODE_TORCH);
		        			cam.setParameters(p);
		        			cam.startPreview();
		        			Thread.sleep(90);
		        			
		        			p.setFlashMode(Parameters.FLASH_MODE_OFF);
		        			cam.setParameters(p);
		        			cam.startPreview();
		        			Thread.sleep(230);
		        			
		        			
            			} catch (Exception e){
            				;
            			}
            		}
        		}
            }
    }).start();
        
        
        f_light_blinka.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        			blinkabool = !blinkabool;
        			blinkakonstigbool = false;
        			if(!blinkabool)
        				f_light_blinka.setText("BLINKA!!");
        			else
        				f_light_blinka.setText("SLUTA BLINKA!!");
        	} 		
    	});
        
        f_light_konstig.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        			blinkabool = false;
        			blinkakonstigbool = !blinkakonstigbool;
        			if(!blinkakonstigbool)
        				f_light_konstig.setText("BLINKA KONSTIGT!!");
        			else
        				f_light_konstig.setText("SLUTA BLINKA KONSTIGT!!");
        	} 		
    	});
		
        
        f_light_button.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		try
        		{
		        		if (f_light_on) {   
		        			p.setFlashMode(Parameters.FLASH_MODE_TORCH);
		        			cam.setParameters(p);
		        			cam.startPreview();
		        			f_light_on = false;
		        			f_light_button.setText("SLÄCK");
		        		} else 	{
		        			p.setFlashMode(Parameters.FLASH_MODE_OFF);
		        			cam.setParameters(p);
		        			cam.startPreview();
	        		        f_light_on = true;
	        		        f_light_button.setText("TÄND");
		        		}
	        		
	        	} catch (Exception e) {
	        		e.printStackTrace();
	                Toast.makeText(getBaseContext(), "ett fel uppstod",
	                        Toast.LENGTH_SHORT).show();
	        	}
        	} 		
    	}); 
    }
    
    public void onDestroy() {
    	super.onDestroy();
    	cam.stopPreview();
    	cam.release();
    	System.exit(0);
    }
}

