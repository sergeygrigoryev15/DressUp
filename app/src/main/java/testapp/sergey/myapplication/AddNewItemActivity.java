package testapp.sergey.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import Utils.Item;

import static testapp.sergey.myapplication.MainActivity.dbUtils;

public class AddNewItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final EditText txbItemName = (EditText) findViewById(R.id.txbName);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbUtils.addItem(new Item(txbItemName.getText().toString()));
                startActivity(new Intent(AddNewItemActivity.this, ItemsActivity.class));
            }
        });
    }

}
