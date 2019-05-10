package demo.app.com.sqlite_db;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword, editTextComfirmPW;
    Button buttonSave;
    TextView textViewLogin;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        editTextEmail=(EditText)findViewById(R.id.txt_email);
        editTextPassword=(EditText)findViewById(R.id.txt_password);
        editTextComfirmPW=(EditText)findViewById(R.id.txt_confirm);
        buttonSave=(Button) findViewById(R.id.btn_save);
        textViewLogin=(TextView) findViewById(R.id.txt_login);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(LoginIntent);


            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String pw = editTextPassword.getText().toString().trim();
                String comfirmpw = editTextComfirmPW.getText().toString().trim();

                if(pw.equals(comfirmpw)){
                    long val = db.addUser(email,pw);
                    if(val > 0) {
                        Toast.makeText(RegisterActivity.this, "You have register", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(loginIntent);
                    }else{
                        Toast.makeText(RegisterActivity.this,"Register error",Toast.LENGTH_SHORT).show();

                    }

                }else {
                    Toast.makeText(RegisterActivity.this,"Password is not match",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
