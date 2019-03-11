package lk.ac.kln.countdowntimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private int counter = 99;
private boolean runnning;
private boolean wasRunning;
private final String CURRENT_COUNTER = "counter";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = savedInstanceState.getInt(CURRENT_COUNTER);
        countdown();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInce){
        super.onSaveInstanceState(savedInce);
        savedInce.putInt(CURRENT_COUNTER,counter);
    }

    protected void clickStart(View view) {//runnning true;}


    protected void coundown(){
        final TextView textView = findViewById(R.id.textView);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(Integer.toString(counter));
                counter--;
                handler.postDelayed(this,100);
                if(counter==0){
                    counter=99;
                }
            }
        });
    }




}

