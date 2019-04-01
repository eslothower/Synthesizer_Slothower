package com.linburgtech.synthesizer_linburg;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ToggleButton;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private Button button1;
    private Button button2;
    private Button button5;
    private Button button9;
    private Button button3;
    private ToggleButton toggleButton1;
    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private int i = 1;
    private int numbersPickerValue;
    private int notePickerValue;
    private int WHOLE_NOTE = 1000;
    private MediaPlayerThread mpt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button5 = (Button)findViewById(R.id.button5);
        button9 = (Button)findViewById(R.id.button9);
        toggleButton1 = (ToggleButton)findViewById(R.id.toggleButton1);
        numberPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(15);
        numberPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);
        numberPicker2.setMinValue(0);
        mpt = new MediaPlayerThread(MainActivity.this);
        final String[] notes= {"A","B", "C", "C#", "D", "D#","E", "F", "F#", "G", "G#","High E", "High F", "High F#", "High G"};
        final int[] c3= {R.raw.scalee, R.raw.scalefs, R.raw.scalegs, R.raw.scalea, R.raw.scaleb, R.raw.scalecs, R.raw.scaleds, R.raw.scalehighe};
        final int[] noteFiles= {R.raw.scalea, R.raw.scaleb, R.raw.scalec, R.raw.scalecs, R.raw.scaled, R.raw.scaleds, R.raw.scalee, R.raw.scalef, R.raw.scalefs, R.raw.scaleg, R.raw.scalegs, R.raw.scalehighe, R.raw.scalehighf, R.raw.scalehighfs, R.raw.scalehighg};
        final int[] c6= {R.raw.scalea, R.raw.scalea, R.raw.scalehighe, R.raw.scalehighe, R.raw.scalehighfs, R.raw.scalehighfs, R.raw.scalehighe, R.raw.scaled, R.raw.scaled, R.raw.scalecs, R.raw.scalecs, R.raw.scaleb, R.raw.scaleb, R.raw.scalea};

        numberPicker2.setMaxValue(notes.length-1);
        numberPicker2.setDisplayedValues(notes);



//BUTTONS/CHALLENGES. THE CHALLENGE NUUMBER CORRESPONDS WITH THE BUTTON NUMBER, UNLESS IT SAYS OTHERWISE, SUCH AS FOR BUTTON 2, OR BUTTON 5.
//--------------------------------------------------------------------------------------------------------------------------------------------------


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SynthesizerActivity", "Challenge 1 Button clicked");
                mpt.playNote(R.raw.scalee, WHOLE_NOTE/2);
                mpt.playNote(R.raw.scalefs, WHOLE_NOTE/2);
                mpt.playNote(R.raw.scalegs, WHOLE_NOTE/2);
                mpt.playNote(R.raw.scalea, WHOLE_NOTE/2);
                mpt.playNote(R.raw.scaleb, WHOLE_NOTE/2);
                mpt.playNote(R.raw.scalecs, WHOLE_NOTE/2);
                mpt.playNote(R.raw.scaleds, WHOLE_NOTE/2);
                mpt.playNote(R.raw.scalehighe, WHOLE_NOTE/2);
            }
        });

//--------------------------------------------------------------------------------------------------------------------------------------------------

        //THIS IS CHALLENGES 2 AND 4
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button 2 Clicked ");
                numbersPickerValue = numberPicker1.getValue();
                notePickerValue = numberPicker2.getValue();
                for (int i = 0; i < numbersPickerValue; i++ ){
                    mpt.playNote(noteFiles[notePickerValue], WHOLE_NOTE);
                }
            }
        });

//--------------------------------------------------------------------------------------------------------------------------------------------------

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button 3 Clicked ");
                for (int notes: c3 ){
                    mpt.playNote(notes, WHOLE_NOTE/2);
                }
            }
        });

//--------------------------------------------------------------------------------------------------------------------------------------------------

        //THIS IS CHALLENGES 5, 6, 7, AND 8
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "Button 5 Clicked ");

                   /* mpt.playNote(R.raw.scalea, WHOLE_NOTE);
                    mpt.playNote(R.raw.scalea, WHOLE_NOTE);
                    mpt.playNote(R.raw.scalehighe, WHOLE_NOTE);
                    mpt.playNote(R.raw.scalehighe, WHOLE_NOTE);
                    mpt.playNote(R.raw.scalehighfs, WHOLE_NOTE);
                    mpt.playNote(R.raw.scalehighfs, WHOLE_NOTE);
                    mpt.playNote(R.raw.scalehighe, WHOLE_NOTEasdfasdfasdfasdf);
                    mpt.playNote(R.raw.scaled, WHOLE_NOTE);
                    mpt.playNote(R.raw.scaled, WHOLE_NOTE);
                    mpt.playNote(R.raw.scalecs, WHOLE_NOTE);
                    mpt.playNote(R.raw.scalecs, WHOLE_NOTE);
                    mpt.playNote(R.raw.scaleb, WHOLE_NOTE);
                    mpt.playNote(R.raw.scaleb, WHOLE_NOTE);
                    mpt.playNote(R.raw.scalea, WHOLE_NOTEasdfasdfasdfasdf);*/

                for (int notes: c6){
                    if (i != 7){
                        mpt.playNote(notes, WHOLE_NOTE/2);
                        i++;
                    } else {
                        mpt.playNote(notes, WHOLE_NOTE);
                        i = 1;
                    }
                }





            }
        });

//--------------------------------------------------------------------------------------------------------------------------------------------------

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "Button 9 Clicked ");
                WHOLE_NOTE = 500;
                mpt.playNote(R.raw.scalea, WHOLE_NOTE);
                mpt.playNote(R.raw.scalea, WHOLE_NOTE);
                mpt.playNote(R.raw.scalehighe, WHOLE_NOTE);
                mpt.playNote(R.raw.scalehighe, WHOLE_NOTE);
                mpt.playNote(R.raw.scalehighfs, WHOLE_NOTE);
                mpt.playNote(R.raw.scalehighfs, WHOLE_NOTE);
                mpt.playNote(R.raw.scalehighe, WHOLE_NOTE*2);
                mpt.playNote(R.raw.scaled, WHOLE_NOTE);
                mpt.playNote(R.raw.scaled, WHOLE_NOTE);
                mpt.playNote(R.raw.scalecs, WHOLE_NOTE);
                mpt.playNote(R.raw.scalecs, WHOLE_NOTE);
                mpt.playNote(R.raw.scaleb, WHOLE_NOTE);
                mpt.playNote(R.raw.scaleb, WHOLE_NOTE);
                mpt.playNote(R.raw.scalea, WHOLE_NOTE*2);


                //Log.i(TAG, "ELI" + toggleButton1.isChecked());
                if (toggleButton1.isChecked()) {
                    numbersPickerValue = numberPicker1.getValue();
                    for (int i = 0; i < numbersPickerValue; i++) {
                        mpt.playNote(R.raw.scalehighe, WHOLE_NOTE);
                        mpt.playNote(R.raw.scalehighe, WHOLE_NOTE);
                        mpt.playNote(R.raw.scaled, WHOLE_NOTE);
                        mpt.playNote(R.raw.scaled, WHOLE_NOTE);
                        mpt.playNote(R.raw.scalecs, WHOLE_NOTE);
                        mpt.playNote(R.raw.scalecs, WHOLE_NOTE);
                        mpt.playNote(R.raw.scaleb, WHOLE_NOTE * 2);
                    }
                }



                mpt.playNote(R.raw.scalea, WHOLE_NOTE);
                mpt.playNote(R.raw.scalea, WHOLE_NOTE);
                mpt.playNote(R.raw.scalehighe, WHOLE_NOTE);
                mpt.playNote(R.raw.scalehighe, WHOLE_NOTE);
                mpt.playNote(R.raw.scalehighfs, WHOLE_NOTE);
                mpt.playNote(R.raw.scalehighfs, WHOLE_NOTE);
                mpt.playNote(R.raw.scalehighe, WHOLE_NOTE*2);
                mpt.playNote(R.raw.scaled, WHOLE_NOTE);
                mpt.playNote(R.raw.scaled, WHOLE_NOTE);
                mpt.playNote(R.raw.scalecs, WHOLE_NOTE);
                mpt.playNote(R.raw.scalecs, WHOLE_NOTE);
                mpt.playNote(R.raw.scaleb, WHOLE_NOTE);
                mpt.playNote(R.raw.scaleb, WHOLE_NOTE);
                mpt.playNote(R.raw.scalea, WHOLE_NOTE*2);


            }
        });
    }
}
