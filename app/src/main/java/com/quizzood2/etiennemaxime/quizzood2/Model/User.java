package com.quizzood2.etiennemaxime.quizzood2.Model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class User {

    private String userId;
    private String email;
    private String password;

    public User() {
    }

    public User(String userId, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public boolean makeRequest (){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address
            //this.name = user.getDisplayName();
            String email = user.getEmail();
        }
            return true;
    }
}
