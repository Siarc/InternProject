package com.aminul.internproject.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.aminul.internproject.R;
import com.aminul.internproject.model.DataModelResponse;
import com.aminul.internproject.model.Gift;
import com.aminul.internproject.model.Literature;
import com.aminul.internproject.model.PhysicianSample;
import com.aminul.internproject.model.ProductGroup;
import com.aminul.internproject.utils.GetDataService;
import com.aminul.internproject.utils.RetrofitInstance;
import com.google.gson.Gson;

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
    private Spinner productGroupSpinner;
    private Spinner literatureSpinner;
    private Spinner physicianSampleSpinner;
    private Spinner giftSpinner;
    private Button submit;

    List<Gift> giftList = new ArrayList<>();
    List<Literature> literatureList = new ArrayList<>();
    List<PhysicianSample> physicianSampleList = new ArrayList<>();
    List<ProductGroup> productGroupList = new ArrayList<>();

    String[] names = {"auri","Nynaeve","Jashnah"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onClickListeners();
        network();
        spinners();

    }

    private void init() {

//        Toolbar toolbar = findViewById(R.id.toolbar);
////        toolbar.setTitle("Intern DCR");
////        setSupportActionBar(toolbar);

        productGroup = findViewById(R.id.product_group);
        literature = findViewById(R.id.literature);
        physicianSample = findViewById(R.id.physician_sample);
        gift = findViewById(R.id.gift);
        accompaniedWith = findViewById(R.id.accompanied_with);
        remarks = findViewById(R.id.remarks);
        submit = findViewById(R.id.submit);

        productGroupSpinner = findViewById(R.id.product_group_spinner);
        literatureSpinner = findViewById(R.id.literature_spinner);
        physicianSampleSpinner = findViewById(R.id.physician_sample_spinner);
        giftSpinner = findViewById(R.id.gift_spinner);

    }



    /**
     * I do not understand how to get the data here
     */
    private void network() {

        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        Call<DataModelResponse> call = service.getData();
        call.enqueue(new Callback<DataModelResponse>() {
            @Override
            public void onResponse(Call<DataModelResponse> call, Response<DataModelResponse> response) {

                Log.d(TAG, "onResponse: "+response);

                if(response.isSuccessful()){

                    DataModelResponse dataModelResponse = response.body();
                    showData(dataModelResponse);


                }
            }



            @Override
            public void onFailure(Call<DataModelResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void showData(DataModelResponse dataModelResponse) {

        Log.d(TAG, "showData: "+new Gson().toJson(dataModelResponse));

        giftList = dataModelResponse.getGiftList();
        literatureList = dataModelResponse.getLiteratureList();
        physicianSampleList = dataModelResponse.getPhysicianSampleList();
        productGroupList = dataModelResponse.getProductGroupList();

        Log.d(TAG, "showData:Gift: "+giftList);

        Log.d(TAG, "showData:Literature: "+literatureList);

        Log.d(TAG, "showData:Sample: "+physicianSampleList);

        Log.d(TAG, "showData:Product: "+productGroupList);

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


    private void spinners() {

        ArrayAdapter<String> productGroupArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, names);
        Log.d(TAG, "spinners: "+productGroupList);

        productGroupArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        productGroupSpinner.setAdapter(productGroupArrayAdapter);

    }

}
