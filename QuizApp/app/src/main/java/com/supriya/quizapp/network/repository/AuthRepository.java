package com.supriya.quizapp.network.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthRepository {
    private Application application ;
    private MutableLiveData<FirebaseUser> firebaseUserMutableLiveData;
    private FirebaseAuth firebaseAuth;

    public MutableLiveData<FirebaseUser> getFirebaseUserMutableLiveData() {
        return firebaseUserMutableLiveData;
    }

    public FirebaseUser getCurrentUser() {
        return firebaseAuth.getCurrentUser();
    }
   public AuthRepository(Application application){
        this.application =  application;
        firebaseUserMutableLiveData = new MutableLiveData<>();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void signUp(String email, String password){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                firebaseUserMutableLiveData.postValue(firebaseAuth.getCurrentUser());
            } else {
                Toast.makeText(application, task.getException().getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void signIn(String email, String password) {
       firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
           if (task.isSuccessful()) {
               firebaseUserMutableLiveData.postValue(firebaseAuth.getCurrentUser());
           } else {
               Toast.makeText(application, task.getException().getMessage() , Toast.LENGTH_SHORT).show();
           }
       });
    }

    public void signOut(){
        firebaseAuth.signOut();
    }
}
