package com.chodio.membacadanmenulisfile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuUtama extends AppCompatActivity {
    Button btnBuka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        btnBuka = (Button)findViewById(R.id.btnBuka);

        btnBuka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buka = new Intent(MenuUtama.this, MainActivity.class);

                startActivity(buka);
            }
        });

    }
}
