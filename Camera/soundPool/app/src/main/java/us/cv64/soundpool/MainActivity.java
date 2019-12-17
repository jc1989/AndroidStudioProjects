// https://codinginflow.com/tutorials/android/soundpool
package us.cv64.soundpool;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int sound1, sound2, sound3, sound4, sound5, sound6;
    private int sound3StreamId;  // pause and restart sound

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if SDK greater than 21 use the new Constructor
        // setUsage - this case user interface
        // setContentType - execute from a key click, short Foley sounds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            // see else statement, same attributes
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();

            // else SDK is 20 use the old Constructor
            // maxStreams - how many sounds to play in the pool
            // AudioManager - the type of music to play
            // srcQuality - never implemented
        } else {
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }

        // load sounds
        sound1 = soundPool.load(this, R.raw.sound1, 1);
        sound2 = soundPool.load(this, R.raw.sound2, 1);
        sound3 = soundPool.load(this, R.raw.sound3, 1);
        sound4 = soundPool.load(this, R.raw.sound4, 1);
        sound5 = soundPool.load(this, R.raw.sound5, 1);
        sound6 = soundPool.load(this, R.raw.sound6, 1);
    }

    // play sound that was selected
    // soundPool.play parameters
    // sound file, volume for each side left and right, priority of sound
    // how many loops 0 - not repeat, -1 - indefinitely
    // rate - the speed of the sound, 1 - is normal speed
    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.button_sound1:
                soundPool.play(sound1, 1, 1, 0, 0, 1);
                //soundPool.pause(sound3StreamId); // pauses sound3
                soundPool.autoPause(); // pauses all other sounds
                break;
            case R.id.button_sound2:
                soundPool.play(sound2, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound3:
                sound3StreamId = soundPool.play(sound3, 1, 1, 0, 0, 1);
                break;
            case R.id.radioButton1:
                soundPool.play(sound4, 1, 1, 0, 0, 1);
                break;
            case R.id.radioButton2:
                soundPool.play(sound5, 1, 1, 0, 0, 1);
                break;
            case R.id.radioButton3:
                soundPool.play(sound6, 1, 1, 0, 0, 1);
                break;
        }
    }

    @Override
    // free up sound resources
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
