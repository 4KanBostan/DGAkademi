package com.furkanbostan.e_ticaret_mini.Fragments.Authentication;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.furkanbostan.e_ticaret_mini.Models.User;
import com.furkanbostan.e_ticaret_mini.R;
import com.furkanbostan.e_ticaret_mini.databinding.FragmentRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterFragment extends Fragment {
    private FirebaseAuth mAuth;
    private FragmentRegisterBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentRegisterBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegister(v);

            }
        });

        binding.registerHaveAnAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment();
                Navigation.findNavController(v).navigate(action);
            }
        });




    }

    private void performRegister(View v) {
        String email = binding.registerEmailEditText.getText().toString();
        String password = binding.registerPasswordEditText.getText().toString();
        if (binding.registerEmailEditText.getText().toString().trim().equals("") || binding.registerPasswordEditText.getText().toString().trim().equals("")|| binding.registerUsernameEditText.getText().toString().trim().equals("")){

        }
        else {

            mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        saveUserToDatabase(v);
                    }
                    else {

                    }
                }
            });
        }


    }
    private void saveUserToDatabase(View v) {
        String uid = FirebaseAuth.getInstance().getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/Users/" + uid);
        User user = new User(uid, binding.registerUsernameEditText.getText().toString(), binding.registerEmailEditText.getText().toString());
        myRef.setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                NavDirections action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment();
                Navigation.findNavController(v).navigate(action);
            }
        });
    }
}