package testapp.sergey.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Utils.DbUtils;

public class MainActivity extends AppCompatActivity {

    static DbUtils dbUtils;
    public static final String LOG_TAG = "===== DEBUG =====:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnItems = (Button) findViewById(R.id.btnItems);
        Button btnOutfits = (Button) findViewById(R.id.btnOutfits);
        Button btnCalender = (Button) findViewById(R.id.btnCalendar);
        TextView lblWelcome = (TextView) findViewById(R.id.lblWelcome);

        btnItems.setOnClickListener(onClickListener);
        btnOutfits.setOnClickListener(onClickListener);
        btnCalender.setOnClickListener(onClickListener);

        dbUtils = new DbUtils(this);
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnItems:
                    startActivity(new Intent(MainActivity.this, ItemsActivity.class));
                    break;
                case R.id.btnOutfits:
                    startActivity(new Intent(MainActivity.this, OutfitsActivity.class));
                    break;
                case R.id.btnCalendar:
            }
        }
    };
}
