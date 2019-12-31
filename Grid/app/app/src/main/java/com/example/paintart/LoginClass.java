package com.example.paintart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginClass extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_class);


        Button loginBtn = findViewById(R.id.submit);
        final EditText userName = findViewById(R.id.UserName);
        final EditText password = findViewById(R.id.Password);



        loginBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String pass="1234";
            String user="Tevin";

            String givenUsername;
            String givenPassword;

            givenPassword= String.valueOf(password.getText());
            givenUsername= String.valueOf(userName.getText());

            String myString="Welcome "+givenUsername+" Enjoy your stay";

            if (givenUsername.equals((user))&&givenPassword.equals(pass)){
                Toast.makeText(getApplicationContext(),myString,Toast.LENGTH_LONG).show();
                goToMain();
            }else{
                Toast.makeText(getApplicationContext(),"Invalid Credentials try again",Toast.LENGTH_LONG).show();
            }


        }
    });
}

        public void  goToMain(){
            Intent intent = new Intent(this,MainClass.class);
            startActivity(intent);



        }



}
