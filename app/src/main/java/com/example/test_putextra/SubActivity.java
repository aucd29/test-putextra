package com.example.test_putextra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2016. 10. 14.. <p/>
 */
public class SubActivity extends AppCompatActivity {
    private static final String TAG = "SubActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int pos = getIntent().getIntExtra("pos", -1);
        if (pos == -1) {
            Log.e(TAG, "ERROR: invalid pos");

            finish();
        } else {
            TextView tv = new TextView(this);
            tv.setText("POS : " + pos);
            setContentView(tv);
        }
    }
}
