package com.furkanbostan.automobilefactory.SignIn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.furkanbostan.automobilefactory.Models.User;
import com.furkanbostan.automobilefactory.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

   private ActivityRegisterBinding binding;
   private FirebaseAuth mAuth;
   private DatabaseReference myRef;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       binding = ActivityRegisterBinding.inflate(getLayoutInflater());
       View view = binding.getRoot();
       setContentView(view);


       binding.registerButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               performRegister();
           }
       });

       binding.registerHaveAnAccountText.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
               Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
               startActivity(intent);
           }
       });


   }


   private void performRegister() {
       String email = binding.registerEmailEditText.getText().toString();
       String password = binding.registerPasswordEditText.getText().toString();
       if (binding.registerEmailEditText.getText().toString().trim().equals("") || binding.registerPasswordEditText.getText().toString().trim().equals("")|| binding.registerUsernameEditText.getText().toString().trim().equals("")){

           Toast.makeText(this, "Lütfen 'usrname, email, password' kısımlarını doldurunuz", Toast.LENGTH_SHORT).show();
       }
       else {

           mAuth = FirebaseAuth.getInstance();
           mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()){
                       saveUserToDatabase();
                   }
                   else {
                       Toast.makeText(RegisterActivity.this,  task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                   }
               }
           });
       }


   }
       private void saveUserToDatabase() {
           String uid = FirebaseAuth.getInstance().getUid();
           FirebaseDatabase database = FirebaseDatabase.getInstance();
           DatabaseReference myRef = database.getReference("/Users/" + uid);
           User user = new User(uid, binding.registerUsernameEditText.getText().toString(), binding.registerEmailEditText.getText().toString());
           myRef.setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
               @Override
               public void onSuccess(Void unused) {
                   finish();
                   Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                   startActivity(intent);
               }
           });
       }
    }
