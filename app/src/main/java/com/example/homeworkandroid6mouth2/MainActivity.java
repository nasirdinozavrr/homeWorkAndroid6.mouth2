package com.example.homeworkandroid6mouth2;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText gmail = findViewById(R.id.gmail);
        EditText password = findViewById(R.id.password);
        Button btn = findViewById(R.id.enter);

        Resources res = getResources();
        int main = res.getColor(R.color.gray);
        int extra = res.getColor(R.color.orange);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (gmail.getText().toString().length() > 0 && password.getText().toString().length() > 0) {
                    btn.setBackgroundColor(extra);
                } else {
                    btn.setBackgroundColor(main);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn.setOnClickListener(view -> {
            String email = gmail.getText().toString();
            String pass = password.getText().toString();
            if (email.length() > 0 && pass.length() > 0) {
                if (email.matches("admin") && pass.matches("admin")) {
                    findViewById(R.id.sign_in).setVisibility(View.INVISIBLE);
                    findViewById(R.id.text).setVisibility(View.INVISIBLE);
                    findViewById(R.id.gmail).setVisibility(View.INVISIBLE);
                    findViewById(R.id.password).setVisibility(View.INVISIBLE);
                    findViewById(R.id.enter).setVisibility(View.INVISIBLE);
                    findViewById(R.id.forget_password).setVisibility(View.INVISIBLE);
                    Toast.makeText(this, "Авторизация прошла успешно!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Неправильный логин или пароль!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}