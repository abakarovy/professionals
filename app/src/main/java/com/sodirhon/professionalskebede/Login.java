package com.sodirhon.professionalskebede;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    private Pattern emailPattern = Pattern.compile("\\b[A-Za-z0-9._%-]+@[a-z]+\\.[a-z]{2,6}\\b");

    EditText emailField;
    TextInputLayout passwordField;

    boolean loginValidated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        Button button = findViewById(R.id.loginButton);

        emailField = findViewById(R.id.emailTextField);
        passwordField = findViewById(R.id.passwordTextField);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTermsAndConditionsDialog();
            }
        });

//        emailField.addTextChangedListener(new TextValidator(email) {
//            @Override
//            public boolean validate(TextView textView, String text) {
//                if (!emailPattern.matcher(text).find()) {
//                    email.setError("Email doesn't match");
//                    return true;
//                }
//                return false;
//            }
//        });
    }

    private void showTermsAndConditionsDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.terms_conditions, null);
        CheckBox checkboxAgree = dialogView.findViewById(R.id.checkbox_agree);
        TextView textViewTerms = dialogView.findViewById(R.id.textview_terms_conditions);

        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
        builder.setTitle("Terms and Conditions")
                .setView(dialogView)
                .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!checkboxAgree.isChecked()) {
                            loginValidated = false;
                        } else {
                            loginValidated = true;
                        }

//                        if (loginValidated
//                                && emailField != null
//                                && passwordField != null
//                                && validateEmail(emailField.getText().toString())
//                                && passwordField.getEditText().getText().length() > 6) {
//
//                            System.out.println("Success");

                            setContentView(R.layout.main_activity);
//                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    private boolean validateEmail(String text) {
        if (emailPattern.matcher(text).find()) {
            return true;
        }
        return false;
    }

}