// https://codinginflow.com/tutorials/android/mediaplayer
package us.cv64.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // play a sound
    public void play(View v) {

        // if MediaPlayer already created do not create another MediaPlayer
        if (mediaPlayer == null) {

            // context is the class creating the MediaPlayer
            // the name of the song
            mediaPlayer = MediaPlayer.create(this, R.raw.song);

            // when the MediaPlayer is complete - stop the MediaPlayer and release the resource
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        // start MediaPlayer
        mediaPlayer.start();
    }

    // pause MediaPlayer
    public void pause(View v) {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    // stop MediaPlayer
    public void stop(View v) {
        stopPlayer();
    }

    // stop MediaPlayer and release the resource
    private void stopPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;

            // View when MediaPlayer was resource was released
            Toast.makeText(this, "MediaPlayer Resource Released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    // release MediaPlayer when application exits
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}