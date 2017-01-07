package com.freblogg.countdowntimerapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

  TextView tvTimer;
  Button bStopReset;
  Button bStart;
  CountDownTimer timer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tvTimer = (TextView) findViewById(R.id.textView);
    bStart = (Button) findViewById(R.id.start);
    bStopReset = (Button) findViewById(R.id.stop_reset);
  }

  public void startOnClick(View view) {
    // Timer for 15 secs
    timer = new CountDownTimer(15000, 1000) {
      @Override
      public void onTick(final long millSecondsLeftToFinish) {
        String time = String.valueOf(millSecondsLeftToFinish / 1000);
        tvTimer.setText(time);
      }

      @Override
      public void onFinish() {
        tvTimer.setText("Done!");
      }
    };
    timer.start();
  }

  public void stopOnClick(View view) {
    timer.cancel();
    // reset
    tvTimer.setText("0");
  }

}
