package demo.app.com.sqlite_db;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);

        editTextEmail=(EditText)findViewById(R.id.txt_email);
        editTextPassword=(EditText)findViewById(R.id.txt_password);
        buttonLogin=(Button) findViewById(R.id.btn_login);
        textViewRegister=(TextView) findViewById(R.id.txt_register);

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                 startActivity(registerIntent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(email, password);

                if(res == true){
                    Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

