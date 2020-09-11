package com.jombeja.gadsleaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ImageView mHeaderImage;
    private TextView mHeaderText;
    EditText firstName;
    EditText lastName;
    EditText emailAddress;
    EditText githubLink;
    Button submit;
    Button close;
    Button confrim;
    Dialog mDialog;
    private TextView mTVconfirm;

    private static final String URL1 = "https://docs.google.com/forms/d/e/";

    private static Retrofit.Builder subBuilder = new Retrofit.Builder()
            .baseUrl(URL1)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit subRetrofit = subBuilder.build();
    private AlertDialog mAlertDialog;
    private Button myesButton;
    private Button mcloseButton;
    private TextView mTxtConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        mToolbar = findViewById(R.id.toolbar_submit);
        mHeaderImage = findViewById(R.id.header_image);
        mHeaderText = findViewById(R.id.txt_submission);
        firstName = findViewById(R.id.txt_first_name);
        lastName = findViewById(R.id.txt_last_name);
        emailAddress = findViewById(R.id.txt_email);
        githubLink = findViewById(R.id.txt_github_link);
        submit = findViewById(R.id.btn_submit);
        submitWork();
    }

    private void submitWork() {
        submit.setOnClickListener(view ->ExecuteSubmitRequest(
                firstName.getText().toString(),
                lastName.getText().toString(),
                emailAddress.getText().toString(),
                githubLink.getText().toString()
        ));

    }
    private void ExecuteSubmitRequest(String firstname, String lastname, String emailaddress,
                                      String githublink) {
        Submit submit = subRetrofit.create(Submit.class);
        Call<SubmitData> call = submit.submitForm(firstname, lastname, emailaddress, githublink);

        call.enqueue(new Callback<SubmitData>() {
            @Override
            public void onResponse(Call<SubmitData> call, Response<SubmitData> response) {
                Toast.makeText(SubmitActivity.this, "Submitted successfully", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<SubmitData> call, Throwable t) {
                Toast.makeText(SubmitActivity.this, "failed to submit", Toast.LENGTH_LONG).show();
            }
        });
    }

}