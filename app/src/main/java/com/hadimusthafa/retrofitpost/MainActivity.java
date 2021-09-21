package com.hadimusthafa.retrofitpost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.auth.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.b1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSendOnRequestClicked();
            }
        });
    }

    private void btnSendOnRequestClicked() {
        Api api = RetrofitClient.getRetrofit().create(Api.class);
        Call<Model> call = api.getUserInfo("Hadi M", "Android Developer");
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.e("responseSuccess-->", "-->" + response.code());
                Log.e("ID-->", "-->" + response.body().getId());
                Log.e("NAME-->", "-->" + response.body().getName());
                Log.e("JOB-->", "-->" + response.body().getJob());
                Log.e("CreatedAt-->", "-->" + response.body().getCreatedAt());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e("responseFail-->", "-->" + t.getMessage());
            }
        });
    }
}