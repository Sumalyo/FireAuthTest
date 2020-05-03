package com.datta.fireauthtest;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();

        final String TAG = "EmailPassword";
        final TextInputLayout passwordTextInput = findViewById(R.id.password_text_input);
        final TextInputEditText passwordEditText = findViewById(R.id.password_edit_text);
        final TextInputLayout emailTextInput = findViewById(R.id.email_input);
        final TextInputEditText emailEditText = findViewById(R.id.email_edit);

        MaterialButton nextButton = findViewById(R.id.next_button);
        MaterialButton signButton = findViewById(R.id.signup_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                authenticat(emailEditText.getText(),passwordEditText.getText());
            }
        });
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signinnow();
            }
        });


    }

    protected void authenticat(@Nullable  Editable e, @Nullable Editable p)
    {
        String es=e.toString();String ps=p.toString();
        assert es!=null;
        assert ps!=null;
        final String TAG ="EmailPassword" ;
        mAuth.signInWithEmailAndPassword(es,ps)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            assert user != null;
                            String userHere = user.getEmail();
                            String userToken = user.getUid();

                            Intent I = new Intent(MainActivity.this, FiringactActivity.class);
                            I.putExtra("Username", userHere);
                            I.putExtra("Id", userToken);
                            startActivity(I);

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                            // ...
                        }

                        // ...
                    }
                });
    }

    public void signinnow()
    {
        Intent s = new Intent(MainActivity.this,sign_act.class);
        startActivity(s);
    }
}


