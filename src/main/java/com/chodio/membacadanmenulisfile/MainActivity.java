package com.chodio.membacadanmenulisfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
EditText textpesan;
    Button BRead, BWrite;
    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textpesan=(EditText)findViewById(R.id.editText1);

        BRead = (Button)findViewById(R.id.buttonread);
        BWrite = (Button)findViewById(R.id.buttonwrite);

        bacafile();

        BRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bacafile();
            }
        });
        BWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
                    OutputStreamWriter OutputWriter = new OutputStreamWriter(fileout);
                    OutputWriter.write(textpesan.getText().toString());

                    OutputWriter.close();
                    //display file saved massage
                    Toast.makeText(getBaseContext(),"File Tersimpan", Toast.LENGTH_SHORT).show();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public void bacafile(){
        try {
            FileInputStream fileIn=openFileInput("mytextfile.txt");
            InputStreamReader InputRead = new
                    InputStreamReader(fileIn);
            char [] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charread;

            while ((charread=InputRead.read(inputBuffer))>0) {
                //Char to string conversion
                String
                        readstring = String.copyValueOf(inputBuffer, 0, charread);
                s += readstring;
            }
            InputRead.close();;
            textpesan.setText(s);
            Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
