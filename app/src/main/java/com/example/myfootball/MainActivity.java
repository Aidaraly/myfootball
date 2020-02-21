package com.example.myfootball;

import android.os.Bundle;

import com.example.myfootball.ui.sign_up.SignUpFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Patterns;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarConfiguration mAppBarConfiguration;
    private EditText editTextEmail_sp, editTextPasswor_sp, editTextName_sp, editTextSurname_sp, editTextAge_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_sign_in)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        editTextEmail_sp = findViewById(R.id.Enter_email_signup);
        editTextPasswor_sp = findViewById(R.id.Enter_password_signup);
        editTextName_sp = findViewById(R.id.name_signup);
        editTextSurname_sp = findViewById(R.id.surname_signup);
        editTextAge_sp = findViewById(R.id.age_signup);
        findViewById(R.id.btn_signup).setOnClickListener(this);






    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    private  void UserSignUp(){
        String email_sp = editTextEmail_sp.getText().toString().trim();
        String password_sp = editTextPasswor_sp.getText().toString().trim();
        String name_sp = editTextName_sp.getText().toString().trim();
        String surname_sp = editTextSurname_sp.getText().toString().trim();
        String age_sp = editTextAge_sp.getText().toString().trim();


        if(email_sp.isEmpty()){
            editTextEmail_sp.setError("Email is reqired");
            editTextEmail_sp.requestFocus();
            return;
        }if(Patterns.EMAIL_ADDRESS.matcher(email_sp).matches()){
            editTextEmail_sp.setError("Enter a valid email");
            editTextEmail_sp.requestFocus();
            return;
        }
        if(password_sp.isEmpty()){
            editTextPasswor_sp.setError("Password is required!");
            editTextPasswor_sp.requestFocus();
            return;
        }
        if(password_sp.length() < 6){
            editTextPasswor_sp.setError("Password must be at least 6 character!");
            editTextPasswor_sp.requestFocus();
            return;
        }
        if(name_sp.isEmpty()){
            editTextName_sp.setError("Name is required");
            editTextName_sp.requestFocus();
            return;
        }
        if(surname_sp.isEmpty()){
            editTextSurname_sp.setError("Name is required");
            editTextSurname_sp.requestFocus();
            return;
        }
        if (age_sp.isEmpty()){
            editTextAge_sp.setError("Age is Required");
            editTextAge_sp  .requestFocus();
            return;
        }

        Call<ResponseBody> call = Client
                .getInstance()
                .getApi()
                .signupUser(email_sp, password_sp, name_sp, surname_sp, age_sp);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String s = response.body().string();
                    Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                }catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {


            }
        });


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signup:
                UserSignUp();
                break;

        }
    }
}
