package com.example.myfootball.ui.sign_in;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myfootball.R;
import com.example.myfootball.ui.sign_up.SignUpFragment;

public class SignInFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sign_in, container, false);
        final EditText enter_email = root.findViewById(R.id.Enter_email);
        final EditText enter_password = root.findViewById(R.id.Enter_password);
        final Button btn_signin = root.findViewById(R.id.btn_signin);
        final TextView not_register_txt = root.findViewById(R.id.notregister_text);
        final TextView sign_up_txt = root.findViewById(R.id.txt_sign_up);

        //open SignUpFragment
        sign_up_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpFragment signUpFragment = new SignUpFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, signUpFragment, signUpFragment.getTag())
                        .addToBackStack(null)
                        .commit();
            }
        });



        return root;
    }
}