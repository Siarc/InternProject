package com.aminul.internproject.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aminul.internproject.R;
import com.aminul.internproject.model.ModelLists;
import com.aminul.internproject.model.ProductGroup;
import com.aminul.internproject.utils.GetDataService;
import com.aminul.internproject.utils.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextInputEditText productGroup;
    private TextInputLayout literature;
    private TextInputLayout physicianSample;
    private TextInputLayout gift;
    private TextInputLayout accompaniedWith;
    private TextInputLayout remarks;
    private Button submit;

    List<String> first = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onClickListeners();
        network();

    }

    /**
     * I do not understand how to get the data here
     */
    private void network() {

        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        Call<ModelLists> call = service.getData();

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ModelLists>() {
            @Override
            public void onResponse(Call<ModelLists> call, Response<ModelLists> response) {

                Log.d(TAG, "onResponse: "+response);
            }

            @Override
            public void onFailure(Call<ModelLists> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void onClickListeners() {

        productGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: dialog box pop up");





            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                productGroup.setText("The name of the wind");
            }
        });
    }

    private void init() {

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        productGroup = findViewById(R.id.product_group);
        literature = findViewById(R.id.literature);
        physicianSample = findViewById(R.id.physician_sample);
        gift = findViewById(R.id.gift);
        accompaniedWith = findViewById(R.id.accompanied_with);
        remarks = findViewById(R.id.remarks);
        submit = findViewById(R.id.submit);


    }


}
