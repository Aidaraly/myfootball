package com.example.myfootball.ui.sign_up;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myfootball.Client;
import com.example.myfootball.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener {

    private EditText enter_email_signup, enter_password_signup, name_signup, surname_signup, age_signup;
    public SignUpFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sign_up, container, false);
        final EditText enter_email_signup = root.findViewById(R.id.Enter_email_signup);
        final EditText enter_password_signup = root.findViewById(R.id.Enter_password_signup);
        final EditText name_signup = root.findViewById(R.id.name_signup);
        final EditText surname_signup = root.findViewById(R.id.surname_signup);
        final EditText age_signup = root.findViewById(R.id.age_signup);
        final Button btn_signup = root.findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(this);






        return root;
    }
    private  void UserSignUp(){
        String email_sp = enter_email_signup.getText().toString().trim();
        String password_sp = enter_password_signup.getText().toString().trim();
        String name_sp = name_signup.getText().toString().trim();
        String surname_sp = surname_signup.getText().toString().trim();
        String age_sp = age_signup.getText().toString().trim();

        if(email_sp.isEmpty()){
            enter_email_signup.setError("Email is reqired");
            enter_email_signup.requestFocus();
            return;
        }
        if(Patterns.EMAIL_ADDRESS.matcher(email_sp).matches()){
            enter_email_signup.setError("Enter a valid email");
            enter_email_signup.requestFocus();
            return;
        }
        if(password_sp.isEmpty()){
            enter_password_signup.setError("Password is required!");
            enter_password_signup.requestFocus();
            return;
        }
        if(password_sp.length() < 6){
            enter_password_signup.setError("Password must be at least 6 character!");
            enter_password_signup.requestFocus();
            return;
        }
        if(name_sp.isEmpty()){
            name_signup.setError("Name is required");
            name_signup.requestFocus();
            return;
        }
        if(surname_sp.isEmpty()){
            surname_signup.setError("Name is required");
            surname_signup.requestFocus();
            return;
        }
        if (age_sp.isEmpty()){
            age_signup.setError("Age is Required");
            age_signup.requestFocus();
            return;
        }

//        Call<ResponseBody> call = Client
//                .getInstance()
//                .getApi()
//                .signupUser(email_sp, password_sp, name_sp, surname_sp, age_sp);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    String s = response.body().string();
//                }catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//
//            }
//        });

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_signup:
            UserSignUp();
            break;

        }

    }

}
