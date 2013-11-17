package android.app;

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


public class DataKeyboardActivity extends Activity {

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

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		


		final Button c1 = (Button) findViewById(R.id.Button01);
		final Button d1 = (Button) findViewById(R.id.Button02);
		final Button e1 = (Button) findViewById(R.id.Button03);
		final Button f1 = (Button) findViewById(R.id.Button04);
		final Button g1 = (Button) findViewById(R.id.Button05);
		final Button a1 = (Button) findViewById(R.id.Button06);
		final Button h1 = (Button) findViewById(R.id.Button07);
		final Button c2 = (Button) findViewById(R.id.Button08);
		final Button d2 = (Button) findViewById(R.id.Button09);
		final Button e2 = (Button) findViewById(R.id.Button10);
		final Button f2 = (Button) findViewById(R.id.Button11);
		final Button g2 = (Button) findViewById(R.id.Button12);
		final Button a2 = (Button) findViewById(R.id.Button13);
		final Button h2 = (Button) findViewById(R.id.Button14);
		final Button c3 = (Button) findViewById(R.id.Button15);
		final Button d3 = (Button) findViewById(R.id.Button16);
		final Button e3 = (Button) findViewById(R.id.Button17);
		final Button f3 = (Button) findViewById(R.id.Button18);
		final Button g3 = (Button) findViewById(R.id.Button19);
		final Button a3 = (Button) findViewById(R.id.Button20);
		final Button h3 = (Button) findViewById(R.id.Button21);
		final Button c1sh = (Button) findViewById(R.id.Button22);
		final Button d1sh = (Button) findViewById(R.id.Button23);
		final Button f1sh = (Button) findViewById(R.id.Button24);
		final Button g1sh = (Button) findViewById(R.id.Button25);
		final Button a1sh = (Button) findViewById(R.id.Button26);
		final Button c2sh = (Button) findViewById(R.id.Button27);
		final Button d2sh = (Button) findViewById(R.id.Button28);
		final Button f2sh = (Button) findViewById(R.id.Button29);
		final Button g2sh = (Button) findViewById(R.id.Button30);
		final Button a2sh = (Button) findViewById(R.id.Button31);
		final Button c3sh = (Button) findViewById(R.id.Button32);
		final Button d3sh = (Button) findViewById(R.id.Button33);
		final Button f3sh = (Button) findViewById(R.id.Button34);
		final Button g3sh = (Button) findViewById(R.id.Button35);
		final Button a3sh = (Button) findViewById(R.id.Button36);
		final Button refresh = (Button) findViewById(R.id.refreshButton);
		final Button hold = (Button) findViewById(R.id.holdButton);

	    //int halfbuttonwidth = buttonwidth/2;
	    
	    //initWidth();
		

		
		
	    
		final Spinner spinner = (Spinner) findViewById(R.id.soundSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.soundoptions, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		
		final SeekBar freq = (SeekBar) findViewById(R.id.seekBar2);
		final SeekBar longshort = (SeekBar) findViewById(R.id.seekBar1);
		
		
		freq.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) { // TODO Auto-generated method stub
				freqchanger = progress;
			}
			public void onStartTrackingTouch(SeekBar seekBar) {}
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});
		
		longshort.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) { // TODO Auto-generated method stub
				tuneLength = 30 * progress + 435; //The minimum and longest length on the tuneArray.
				
				
			}
			public void onStartTrackingTouch(SeekBar seekBar) {}
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});
		

		
	
	
		
		c1.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
							c1hold = true;
							final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
									4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
									AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
									AudioTrack.MODE_STREAM);
							audioTrack.play();
							new Thread(new Runnable() {
								public void run() {
									while (c1hold) {
										audioTrack.write(arrSoundc1, 0, soundArrLength); if(hold_sleep_time){break;}
										try {Thread.sleep(sleep_time);
										} catch (InterruptedException e) {}}
									audioTrack.release();
								}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) c1hold = false;
				return false;}});
		
		d1.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					d1hold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (d1hold) {
								audioTrack.write(arrSoundd1, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);
								} catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) d1hold = false;
				return false;}});

		e1.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					new Thread(new Runnable() {
						public void run() {
							final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
									4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
								AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
								AudioTrack.MODE_STREAM);
							audioTrack.play();
							e1hold = true;
							while (e1hold) {
								audioTrack.write(arrSounde1, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);
								} catch (InterruptedException e)   {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) e1hold = false;
				return false;}});
		
		f1.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					new Thread(new Runnable() {
						public void run() {
							f1hold = true;
							final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
									4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
									AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
									AudioTrack.MODE_STREAM);
							audioTrack.play();
							while (f1hold) {
								audioTrack.write(arrSoundf1, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e)   {e.printStackTrace();}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) f1hold = false;
				return false;}});

		g1.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					new Thread(new Runnable() {
						public void run() {
							g1hold = true;
							final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
									4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
									AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
									AudioTrack.MODE_STREAM);
							audioTrack.play();
							while (g1hold) {
								audioTrack.write(arrSoundg1, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) g1hold = false;
				return false;}});

		a1.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					new Thread(new Runnable() {
						public void run() {
							a1hold = true;
							final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
									4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
									AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
									AudioTrack.MODE_STREAM);
							audioTrack.play();
							while (a1hold) {
								audioTrack.write(arrSounda1, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) a1hold = false;
				return false;}});

		h1.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					new Thread(new Runnable() {
						public void run() {
							h1hold = true;
							final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
									4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
									AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
									AudioTrack.MODE_STREAM);
							audioTrack.play();
							while (h1hold) {
								audioTrack.write(arrSoundh1, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) h1hold = false;
				return false;}});

		c1sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					new Thread(new Runnable() {
						public void run() {
							c1shhold = true;
							final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
									4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
									AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
									AudioTrack.MODE_STREAM);
							audioTrack.play();
							while (c1shhold) {
								audioTrack.write(arrSoundc1sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) c1shhold = false;
				return false;}});
		
		d1sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					d1shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while(d1shhold){
								audioTrack.write(arrSoundd1sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) d1shhold = false;
				return false;}});
		
		f1sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					f1shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (f1shhold) {
								audioTrack.write(arrSoundf1sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) f1shhold = false;
				return false;}});
		
		g1sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					g1shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (g1shhold) {
								audioTrack.write(arrSoundg1sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) g1shhold = false;
				return false;}});
	
		a1sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					a1shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (a1shhold) {
								audioTrack.write(arrSounda1sh, 0, soundArrLength); if(hold_sleep_time){break;}
								
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) a1shhold = false;
				return false;}});	
		
		c2.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					c2hold = true;
					//Log.d("test","först");
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					new Thread(new Runnable() {
						public void run() {
							audioTrack.play();
							while (c2hold) {
								try {audioTrack.write(arrSoundc2, 0, soundArrLength);  if(hold_sleep_time){break;}
								Thread.sleep(sleep_time);
								} catch (InterruptedException e) {}}
							audioTrack.release();
							
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) c2hold = false;
				return false;}});
		
		d2.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					d2hold = true;
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (d2hold) {
								audioTrack.write(arrSoundd2, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);
								} catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) d2hold = false;
				return false;}});

		e2.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
						AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
						AudioTrack.MODE_STREAM);
					audioTrack.play();
					e2hold = true;
					new Thread(new Runnable() {
						public void run() {
							while (e2hold) {
								audioTrack.write(arrSounde2, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);
								} catch (InterruptedException e)   {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) e2hold = false;
				return false;}});
		
		f2.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					f2hold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (f2hold) {
								audioTrack.write(arrSoundf2, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e)   {e.printStackTrace();}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) f2hold = false;
				return false;}});

		g2.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					g2hold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (g2hold) {
								audioTrack.write(arrSoundg2, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) g2hold = false;
				return false;}});

		a2.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					a2hold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (a2hold) {
								audioTrack.write(arrSounda2, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) a2hold = false;
				return false;}});

		h2.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					h2hold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (h2hold) {
								audioTrack.write(arrSoundh2, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) h2hold = false;
				return false;}});

		c2sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					c2shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (c2shhold) {
								audioTrack.write(arrSoundc2sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) c2shhold = false;
				return false;}});
		
		d2sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					d2shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while(d2shhold){
								audioTrack.write(arrSoundd2sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) d2shhold = false;
				return false;}});
		
		f2sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					f2shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (f2shhold) {
								audioTrack.write(arrSoundf2sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) f2shhold = false;
				return false;}});
		
		g2sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							g2shhold = true;
							while (g2shhold) {
								audioTrack.write(arrSoundg2sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) g2shhold = false;
				return false;}});	
	
		a2sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							a2shhold = true;
							while (a2shhold) {
								audioTrack.write(arrSounda2sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) a2shhold = false;
				return false;}});	
		
		c3.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					c3hold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (c3hold) {
								audioTrack.write(arrSoundc3, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);
								} catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) c3hold = false;
				return false;}});
		
		d3.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					d3hold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (d3hold) {
								audioTrack.write(arrSoundd3, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);
								} catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) d3hold = false;
				return false;}});

		e3.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
						AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
						AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							e3hold = true;
							while (e3hold) {
								audioTrack.write(arrSounde3, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);
								} catch (InterruptedException e)   {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) e3hold = false;
				return false;}});
		
		f3.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					f3hold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (f3hold) {
								audioTrack.write(arrSoundf3, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e)   {e.printStackTrace();}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) f3hold = false;
				return false;}});

		g3.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					g3hold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (g3hold) {
								audioTrack.write(arrSoundg3, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) g3hold = false;
				return false;}});

		a3.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					a3hold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (a3hold) {
								audioTrack.write(arrSounda3, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) a3hold = false;
				return false;}});

		h3.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					h3hold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (h3hold) {
								audioTrack.write(arrSoundh3, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) h3hold = false;
				return false;}});
		

		c3sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					c3shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (c3shhold) {
								audioTrack.write(arrSoundc3sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) c3shhold = false;
				return false;}});
		
		d3sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					d3shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while(d3shhold){
								audioTrack.write(arrSoundd3sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) d3shhold = false;
				return false;}});
		
		f3sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					f3shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (f3shhold) {
								audioTrack.write(arrSoundf3sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) f3shhold = false;
				return false;}});
		
		g3sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					g3shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (g3shhold) {
								audioTrack.write(arrSoundg3sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) g3shhold = false;
				return false;}});
	
		a3sh.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					a3shhold = true;
					final AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
							4000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
							AudioFormat.ENCODING_PCM_16BIT, soundArrLength,
							AudioTrack.MODE_STREAM);
					audioTrack.play();
					new Thread(new Runnable() {
						public void run() {
							while (a3shhold) {
								audioTrack.write(arrSounda3sh, 0, soundArrLength); if(hold_sleep_time){break;}
								try {Thread.sleep(sleep_time);} 
								catch (InterruptedException e) {}}
							audioTrack.release();
							}}).start();
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) a3shhold = false;
				return false;}});	
		

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			
		    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		        //Object item = parent.getItemAtPosition(pos);
		        soundOptions = String.valueOf(spinner.getSelectedItem());
		        Log.d("TramsActivity", soundOptions);
		    }

		    
		    public void onNothingSelected(AdapterView<?> parent) {
		    	 soundOptions = String.valueOf(spinner.getSelectedItem());
			        Log.d("TramsActivity", soundOptions);
		    }
		});
		
		refresh.setOnClickListener(new Button.OnClickListener() {  
	        public void onClick(View v)
	            {
	        	new Thread(new Runnable() {
					public void run() {
	            //initAllSoundArr();
	            sleep_time = tuneLength/5;
	            soundArrLength = tuneLength*2;
	            }}).start();
	            }
	         });
	        	
		
		hold.setOnClickListener(new Button.OnClickListener() {  
	        public void onClick(View v)
	            {
	        	hold_sleep_time = !hold_sleep_time;
	        		if(hold_sleep_time){
	        			hold.setBackgroundResource(R.drawable.keycolorpressed);
	        		}
	        		else {
	        			hold.setBackgroundResource(R.drawable.keycolor);
	        		}
	            }
	         });

		DisplayMetrics metrics = this.getResources().getDisplayMetrics();
		int width = metrics.widthPixels;
	    int buttonwidth = width/7-2;
	    //int halfbuttonwidth = buttonwidth/2;
	    
	    
	    ViewGroup.LayoutParams paramsc1 = c1.getLayoutParams();
		ViewGroup.LayoutParams paramsd1 = d1.getLayoutParams();
		ViewGroup.LayoutParams paramse1 = e1.getLayoutParams();
		ViewGroup.LayoutParams paramsf1 = f1.getLayoutParams();
		ViewGroup.LayoutParams paramsg1 = g1.getLayoutParams();
		ViewGroup.LayoutParams paramsa1 = a1.getLayoutParams();
		ViewGroup.LayoutParams paramsh1 = h1.getLayoutParams();
	    ViewGroup.LayoutParams paramsc2 = c2.getLayoutParams();
		ViewGroup.LayoutParams paramsd2 = d2.getLayoutParams();
		ViewGroup.LayoutParams paramse2 = e2.getLayoutParams();
		ViewGroup.LayoutParams paramsf2 = f2.getLayoutParams();
		ViewGroup.LayoutParams paramsg2 = g2.getLayoutParams();
		ViewGroup.LayoutParams paramsa2 = a2.getLayoutParams();
		ViewGroup.LayoutParams paramsh2 = h2.getLayoutParams();
	    ViewGroup.LayoutParams paramsc3 = c3.getLayoutParams();
		ViewGroup.LayoutParams paramsd3 = d3.getLayoutParams();
		ViewGroup.LayoutParams paramse3 = e3.getLayoutParams();
		ViewGroup.LayoutParams paramsf3 = f3.getLayoutParams();
		ViewGroup.LayoutParams paramsg3 = g3.getLayoutParams();
		ViewGroup.LayoutParams paramsa3 = a3.getLayoutParams();
		ViewGroup.LayoutParams paramsh3 = h3.getLayoutParams();
	    ViewGroup.LayoutParams paramsc1sh = c1sh.getLayoutParams();
		ViewGroup.LayoutParams paramsd1sh = d1sh.getLayoutParams();
		ViewGroup.LayoutParams paramsf1sh = f1sh.getLayoutParams();
		ViewGroup.LayoutParams paramsg1sh = g1sh.getLayoutParams();
		ViewGroup.LayoutParams paramsa1sh = a1sh.getLayoutParams();
		ViewGroup.LayoutParams paramsc2sh = c2sh.getLayoutParams();
		ViewGroup.LayoutParams paramsd2sh = d2sh.getLayoutParams();
		ViewGroup.LayoutParams paramsf2sh = f2sh.getLayoutParams();
		ViewGroup.LayoutParams paramsg2sh = g2sh.getLayoutParams();
		ViewGroup.LayoutParams paramsa2sh = a2sh.getLayoutParams();
	    ViewGroup.LayoutParams paramsc3sh = c3sh.getLayoutParams();
		ViewGroup.LayoutParams paramsd3sh = d3sh.getLayoutParams();
		ViewGroup.LayoutParams paramsf3sh = f3sh.getLayoutParams();
		ViewGroup.LayoutParams paramsg3sh = g3sh.getLayoutParams();
		ViewGroup.LayoutParams paramsa3sh = a3sh.getLayoutParams();
		
		
	    paramsc1.width = buttonwidth;
	    paramsd1.width = buttonwidth;
	    paramse1.width = buttonwidth;
	    paramsf1.width = buttonwidth;
	    paramsg1.width = buttonwidth;
	    paramsa1.width = buttonwidth;
	    paramsh1.width = buttonwidth;
	    paramsc2.width = buttonwidth;
	    paramsd2.width = buttonwidth;
	    paramse2.width = buttonwidth;
	    paramsf2.width = buttonwidth;
	    paramsg2.width = buttonwidth;
	    paramsa2.width = buttonwidth;
	    paramsh2.width = buttonwidth;
	    paramsc3.width = buttonwidth;
	    paramsd3.width = buttonwidth;
	    paramse3.width = buttonwidth;
	    paramsf3.width = buttonwidth;
	    paramsg3.width = buttonwidth;
	    paramsa3.width = buttonwidth;
	    paramsh3.width = buttonwidth;
	    paramsc1sh.width = buttonwidth;
	    paramsd1sh.width = buttonwidth;
	    paramsf1sh.width = buttonwidth;
	    paramsg1sh.width = buttonwidth;
	    paramsa1sh.width = buttonwidth;
	    paramsc2sh.width = buttonwidth;
	    paramsd2sh.width = buttonwidth;
	    paramsf2sh.width = buttonwidth;
	    paramsg2sh.width = buttonwidth;
	    paramsa2sh.width = buttonwidth;
	    paramsc3sh.width = buttonwidth;
	    paramsd3sh.width = buttonwidth;
	    paramsf3sh.width = buttonwidth;
	    paramsg3sh.width = buttonwidth;
	    paramsa3sh.width = buttonwidth;
	    
	    c1.setLayoutParams(paramsc1);
	    d1.setLayoutParams(paramsd1);
	    e1.setLayoutParams(paramse1);
	    f1.setLayoutParams(paramsf1);
	    g1.setLayoutParams(paramsg1);
	    a1.setLayoutParams(paramsa1);
	    h1.setLayoutParams(paramsh1);
	    c2.setLayoutParams(paramsc2);
	    d2.setLayoutParams(paramsd2);
	    e2.setLayoutParams(paramse2);
	    f2.setLayoutParams(paramsf2);
	    g2.setLayoutParams(paramsg2);
	    a2.setLayoutParams(paramsa2);
	    h2.setLayoutParams(paramsh2);
	    c3.setLayoutParams(paramsc3);
	    d3.setLayoutParams(paramsd3);
	    e3.setLayoutParams(paramse3);
	    f3.setLayoutParams(paramsf3);
	    g3.setLayoutParams(paramsg3);
	    a3.setLayoutParams(paramsa3);
	    h3.setLayoutParams(paramsh3);
	    c2sh.setLayoutParams(paramsc2sh);
	    d2sh.setLayoutParams(paramsd2sh);
	    f2sh.setLayoutParams(paramsf2sh);
	    g2sh.setLayoutParams(paramsg2sh);
	    a2sh.setLayoutParams(paramsa2sh);
	    c3sh.setLayoutParams(paramsc3sh);
	    d3sh.setLayoutParams(paramsd3sh);
	    f3sh.setLayoutParams(paramsf3sh);
	    g3sh.setLayoutParams(paramsg3sh);
	    a3sh.setLayoutParams(paramsa3sh);

	    
	    RelativeLayout.LayoutParams marginparamsc1sh = (RelativeLayout.LayoutParams)paramsc1sh;
		marginparamsc1sh.leftMargin = buttonwidth/2;
		RelativeLayout.LayoutParams marginparamsc2sh = (RelativeLayout.LayoutParams)paramsc2sh;
		marginparamsc2sh.leftMargin = buttonwidth/2;
		RelativeLayout.LayoutParams marginparamsc3sh = (RelativeLayout.LayoutParams)paramsc3sh;
		marginparamsc3sh.leftMargin = buttonwidth/2;
		
		 
	    RelativeLayout.LayoutParams marginparamsf1sh = (RelativeLayout.LayoutParams)paramsf1sh;
		marginparamsf1sh.leftMargin = buttonwidth+2;
		RelativeLayout.LayoutParams marginparamsf2sh = (RelativeLayout.LayoutParams)paramsf2sh;
		marginparamsf2sh.leftMargin = buttonwidth+2;
		RelativeLayout.LayoutParams marginparamsf3sh = (RelativeLayout.LayoutParams)paramsf3sh;
		marginparamsf3sh.leftMargin = buttonwidth+2;
		
		
		initAllSoundArr();
	}

	public void initAllSoundArr(){
		arrSoundc1 = soundc1.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundd1 = soundd1.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSounde1 = sounde1.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundf1 = soundf1.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundg1 = soundg1.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSounda1 = sounda1.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundh1 = soundh1.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundc1sh = soundc1sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundd1sh = soundd1sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundf1sh = soundf1sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundg1sh = soundg1sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSounda1sh = sounda1sh.createSndArr(freqchanger,soundOptions,tuneLength);
		
		arrSoundc2 = soundc2.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundd2 = soundd2.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSounde2 = sounde2.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundf2 = soundf2.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundg2 = soundg2.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSounda2 = sounda2.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundh2 = soundh2.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundc2sh = soundc2sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundd2sh = soundd2sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundf2sh = soundf2sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundg2sh = soundg2sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSounda2sh = sounda2sh.createSndArr(freqchanger,soundOptions,tuneLength);
		
		arrSoundc3 = soundc3.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundd3 = soundd3.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSounde3 = sounde3.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundf3 = soundf3.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundg3 = soundg3.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSounda3 = sounda3.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundh3 = soundh3.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundc3sh = soundc3sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundd3sh = soundd3sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundf3sh = soundf3sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSoundg3sh = soundg3sh.createSndArr(freqchanger,soundOptions,tuneLength);
		arrSounda3sh = sounda3sh.createSndArr(freqchanger,soundOptions,tuneLength);
	}
	

	

	public void onDestroy() {
		super.onDestroy();
		System.exit(0);
	}
}