package com.quizzood2.etiennemaxime.quizzood2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    Button btnSignup;
    TextView btnLogin,btnForgotPass;
    EditText input_email,input_pass;
    RelativeLayout activity_sign_up;

    private FirebaseAuth auth;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Inscription");
        //View
        btnSignup = (Button)findViewById(R.id.signup_btn_register);
        btnLogin = (TextView)findViewById(R.id.signup_btn_login);
        btnForgotPass = (TextView)findViewById(R.id.signup_btn_forgot_pass);
        input_email = (EditText)findViewById(R.id.signup_email);
        input_pass = (EditText)findViewById(R.id.signup_password);
        activity_sign_up = (RelativeLayout)findViewById(R.id.activity_sign_up);

        btnSignup.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnForgotPass.setOnClickListener(this);

        //Init Firebase
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.signup_btn_login){
            startActivity(new Intent(SignUp.this,MainActivity.class));
            finish();
        }
        else if(view.getId() == R.id.signup_btn_forgot_pass){
            startActivity(new Intent(SignUp.this,ForgotPassword.class));
            finish();
        }
        else if(view.getId() == R.id.signup_btn_register){
            signUpUser(input_email.getText().toString(),input_pass.getText().toString());
        }
    }

    private void signUpUser(String email, final String password) {
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(password.length() < 6)
                        {
                            Snackbar snackBar = Snackbar.make(activity_sign_up,"Le mot de passe est trop court, 6 caractères minimum",Snackbar.LENGTH_SHORT);
                            snackBar.show();
                        }
                        if(!task.isSuccessful())
                        {
                            snackbar = Snackbar.make(activity_sign_up,"Erreur: "+task.getException(),Snackbar.LENGTH_SHORT);
                            snackbar.show();
                        }
                        else{
                            /*DatabaseReference ref = new Firebase("https://quizzood2-ecbe1.firebaseio.com/");
                            ref.onAuth(function(authData) {

                                // save the user's profile into the database so we can list users,
                                // use them in Security and Firebase Rules, and show profiles
                                ref.child("users").child(authData.uid).set({
                                        provider: authData.provider,
                                        name: getName(authData)
                                });
                            }); */
                            snackbar = Snackbar.make(activity_sign_up,"Enregistrement réussi! ",Snackbar.LENGTH_SHORT);
                            snackbar.show();
                        }
                    }
                });
    }
}