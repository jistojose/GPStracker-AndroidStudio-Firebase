package com.example.gpstracker;

//import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.ActionCodeSettings;
//import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {


        Button btnlog;
        private final static int LOGIN_PERMISSION = 1000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            btnlog=(Button) findViewById(R.id.btnsignin);
            btnlog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivityForResult(
                            AuthUI.getInstance().createSignInIntentBuilder().build(),LOGIN_PERMISSION

                    );

                }
            });


        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            if(requestCode == LOGIN_PERMISSION)
            {
                startNewActivity(resultCode,data);
            }
        }

        private void startNewActivity(int resultCode, Intent data) {

            if (resultCode == RESULT_OK) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
                finish();
                Toast.makeText(this, "Login successfully !!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Login failed !!!", Toast.LENGTH_SHORT).show();
            }

        }


    public void forgetpassword(View view) {
        Intent intent = new Intent(getApplicationContext(),forgetpassword.class);
        startActivity(intent);
        finish();
    }
}
