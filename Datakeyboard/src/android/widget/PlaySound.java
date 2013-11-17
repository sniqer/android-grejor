package android.widget;

import android.app.Activity;
import android.app.R;

import android.os.Bundle;
import android.util.Log;


public class PlaySound extends Activity {
	private float freq;
	private final int sampleRate = 4000;
	private final int numSamples = 4000;
	private final double sample[] = new double[numSamples];
	private int idx;
	private float toneMultiplier;
	private byte generatedSnd[];
	private short[] val;
	private int dist = 32767+150; // lite mer än max
	private float tonetimefreq; // multiplikator med frekvensen, 0.3 default (0.3 - 0.89)
	private double omfg;
	
	public PlaySound(float freq) {
		this.freq = freq;
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	

	public byte[] createSndArr(final int freqchanger, final String soundOptions, final int tuneLength) {
		toneMultiplier = (float) (freqchanger + 60) / 90;
		tonetimefreq = freq*toneMultiplier;
		
		omfg = 2 * Math.PI / (sampleRate/tonetimefreq);
			for (int i = 0; i < tuneLength; i++) {
				sample[i] = Math.sin(omfg*i);
			}
			
			
			int normal = (int) (174*32767/tonetimefreq);
			idx = 0;
			generatedSnd = new byte[tuneLength*2];
			val = new short[tuneLength];
			for (int i = 0; i < tuneLength; i++) {

				if (soundOptions.equals("Normal")) 
					val[i] =  (short) (sample[i] * normal);
				else if (soundOptions.equals("Distortion")) 
					{
						val[i] = (short) ((sample[i] * dist));
						val[i] =  (short) (val[i]/4);
					}
				else if (soundOptions.equals("Vibrato"))
					val[i] = (short) (sample[i]  * normal * (Math.sin(i* 2 * Math.PI / 800 )));
				else if (soundOptions.equals("Click"))
					if(i <= 100)
						val[i] = (short) (sample[i] * 32767);
					else break;
				else if (soundOptions.equals("Marimba")) 
					{
						val[i] = (short) (sample[i] * 32767* 1.1 * Math.exp(-1.5*i/tuneLength));
						val[i] =  (short) (241*val[i]/(tonetimefreq+100)); //262+100/3 = 120, istället för 262/3 = 87
					}
				/*else if (soundOptions.equals("likstrom")){
					val[i] = (short) normal;
				}
				else if (soundOptions.equals("bursting")) 
				{
					if (i % 25 < 50)
						val[i] =  (short) (sample[i] * normal);
					else 
						val[i] = (short) 0;
				}
				else if (soundOptions.equals("yoink")) 
				{
					val[i] =  (short) (sample[i] * normal);
					val[i] = (short) (val[i] * Math.expm1(i/tuneLength)/2.71);
				}*/
				else if (soundOptions.equals("Trumpet")) 
				{
					val[i] = (short) (sample[i] * 32767 * 1.3 * Math.exp(-1.1*i/tuneLength));
					//val[i] =  (short) (274*val[i]/(tonetimefreq+150)); //87 262+100/3 = 120, istället för 262/3 = 87
				}
				
				else if (soundOptions.equals("Normal Faded")) 
				{
					val[i] = (short) (sample[i] * 32867 * Math.exp(-1.1*i/tuneLength));
					val[i] =  (short) (241*val[i]/(tonetimefreq+100)); //87 262+100/3 = 120, istället för 262/3 = 87
				}
				else if (soundOptions.equals("Noise")){
					val[i] = (short) (sample[i] * 327670);
					val[i] = (short) (val[i]/4);
				}

				if (i <= 49)
					val[i] = (short) (val[i]*Math.sin(i * 2 * Math.PI/200));
				else if (i >= tuneLength-49)
					val[i] = (short) (val[i]*Math.cos((i-(tuneLength-49)) * 2 * Math.PI/200));
				
				generatedSnd[idx++] = (byte) (val[i] & 0x00ff);
				generatedSnd[idx++] = (byte) ((val[i] & 0xff00) >>> 8);

			}		
		System.gc();
		return generatedSnd;
	}
}