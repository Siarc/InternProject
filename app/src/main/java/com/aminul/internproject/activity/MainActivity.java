package com.aminul.internproject.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextInputEditText accompaniedWith;
    private TextInputEditText remarks;

    private AutoCompleteTextView productGroup;
    private AutoCompleteTextView literature;
    private AutoCompleteTextView physicianSample;
    private AutoCompleteTextView gift;

    private EditText literatureQuantity;
    private EditText physicianQuantity;
    private EditText giftQuantity;
    private Button submit;

//    List<Gift> giftList = new ArrayList<>();
//    List<Literature> literatureList = new ArrayList<>();
//    List<PhysicianSample> physicianSampleList = new ArrayList<>();
//    List<ProductGroup> productGroupList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onClickListeners();
        network();
        loadData(savedInstanceState);

    }

    private void init() {

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        accompaniedWith = findViewById(R.id.accompanied_with);
        remarks = findViewById(R.id.remarks);
        submit = findViewById(R.id.submit);

        productGroup = findViewById(R.id.product_group);
        literature = findViewById(R.id.literature);
        physicianSample = findViewById(R.id.physician_sample);
        gift = findViewById(R.id.gift);

    }

    private void loadData(Bundle savedInstanceState) {

        if (savedInstanceState != null) {

//            Log.d(TAG, "loadData: "+productGroupList);

//            productGroupSpinner.setSelection(savedInstanceState.getInt("productOutSate",0));
//            literatureSpinner.setSelection(savedInstanceState.getInt("literatureOutState",0));
//            physicianSampleSpinner.setSelection(savedInstanceState.getInt("simpleOutState",0));
//            giftSpinner.setSelection(savedInstanceState.getInt("giftOutState",0));

            productGroup.setText(savedInstanceState.getString("accOutState"));
            literature.setText(savedInstanceState.getString("accOutState"));
            physicianSample.setText(savedInstanceState.getString("accOutState"));
            gift.setText(savedInstanceState.getString("accOutState"));

            accompaniedWith.setText(savedInstanceState.getString("accOutState"));
            remarks.setText(savedInstanceState.getString("remarksOutState"));



        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

//        outState.putInt("productOutSate", productGroupSpinner.getSelectedItemPosition());
//        outState.putInt("literatureOutState", literatureSpinner.getSelectedItemPosition());
//        outState.putInt("simpleOutState", physicianSampleSpinner.getSelectedItemPosition());
//        outState.putInt("giftOutState", giftSpinner.getSelectedItemPosition());


        outState.putString("productGroupOutState", Objects.requireNonNull(productGroup.getText()).toString().trim());
        outState.putString("literatureOutState", Objects.requireNonNull(literature.getText()).toString().trim());
        outState.putString("physicianSampleOutState", Objects.requireNonNull(physicianSample.getText()).toString().trim());
        outState.putString("giftOutState", Objects.requireNonNull(gift.getText()).toString().trim());
        outState.putString("accOutState", Objects.requireNonNull(accompaniedWith.getText()).toString().trim());
        outState.putString("remarksOutState", Objects.requireNonNull(remarks.getText()).toString().trim());


    }

    /**
     * Retrofit
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

//        giftList = dataModelResponse.getGiftList();
//        literatureList = dataModelResponse.getLiteratureList();
//        physicianSampleList = dataModelResponse.getPhysicianSampleList();
//        productGroupList = dataModelResponse.getProductGroupList();

//        Log.d(TAG, "showData:Gift: "+giftList);
//
//        Log.d(TAG, "showData:Literature: "+literatureList);
//
//        Log.d(TAG, "showData:Sample: "+physicianSampleList);
//
//        Log.d(TAG, "showData:Product: "+productGroupList);

//        spinners(giftList, literatureList, physicianSampleList, productGroupList);

        List<String> productGroupNames = new ArrayList<>();
        List<String> literatureNames = new ArrayList<>();
        List<String> physicianSampleNames = new ArrayList<>();
        List<String> giftNames = new ArrayList<>();

        productGroupNames.add(0,"Choose");
        literatureNames.add(0,"Choose");
        physicianSampleNames.add(0,"Choose");
        giftNames.add(0,"Choose");

        for (ProductGroup name: dataModelResponse.getProductGroupList()){
            productGroupNames.add(name.getProductGroupName());
            Log.d(TAG, "spinners: "+name.getProductGroupName());
        }

        Log.d(TAG, "spinners: "+productGroupNames);

        for (Literature name: dataModelResponse.getLiteratureList()){
            literatureNames.add(name.getLiteratureName());
        }

        for (PhysicianSample name: dataModelResponse.getPhysicianSampleList()){
            physicianSampleNames.add(name.getSampleName());
        }

        for (Gift name: dataModelResponse.getGiftList()){
            giftNames.add(name.getGiftName());
        }

        ArrayAdapter<String> arrayAdapterProductGroup = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productGroupNames);

        productGroup.setAdapter(arrayAdapterProductGroup);

        productGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productGroup.showDropDown();
            }
        });

        ArrayAdapter<String> arrayAdapterLiterature = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, literatureNames);

        literature.setAdapter(arrayAdapterLiterature);

        literature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                literature.showDropDown();
            }
        });

        ArrayAdapter<String> arrayAdapterPhysicianSample = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, physicianSampleNames);

        physicianSample.setAdapter(arrayAdapterPhysicianSample);

        physicianSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                physicianSample.showDropDown();
            }
        });

        ArrayAdapter<String> arrayAdapterGift = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, giftNames);

        gift.setAdapter(arrayAdapterGift);

        gift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gift.showDropDown();
            }
        });

    }

    private void onClickListeners() {

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
            }
        });

//        productGroupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(0, 172, 193));
//                ((TextView)parent.getChildAt(0)).setTextSize(12);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        literatureSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(0, 172, 193));
//                ((TextView)parent.getChildAt(0)).setTextSize(12);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        physicianSampleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(0, 172, 193));
//                ((TextView)parent.getChildAt(0)).setTextSize(12);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        giftSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(0, 172, 193));
//                ((TextView)parent.getChildAt(0)).setTextSize(12);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }


    private void spinners(List<Gift> giftList, List<Literature> literatureList, List<PhysicianSample> physicianSampleList, List<ProductGroup> productGroupList) {

//        List<String> productGroupNames = new ArrayList<>();
//        List<String> literatureNames = new ArrayList<>();
//        List<String> physicianSampleNames = new ArrayList<>();
//        List<String> giftNames = new ArrayList<>();
//
//        productGroupNames.add(0,"Choose");
//        literatureNames.add(0,"Choose");
//        physicianSampleNames.add(0,"Choose");
//        giftNames.add(0,"Choose");
//
//        for (ProductGroup name: productGroupList){
//            productGroupNames.add(name.getProductGroupName());
//            Log.d(TAG, "spinners: "+name.getProductGroupName());
//        }
//
//        Log.d(TAG, "spinners: "+productGroupNames);
//
//        for (Literature name: literatureList){
//            literatureNames.add(name.getLiteratureName());
//        }
//
//        for (PhysicianSample name: physicianSampleList){
//            physicianSampleNames.add(name.getSampleName());
//        }
//
//        for (Gift name: giftList){
//            giftNames.add(name.getGiftName());
//        }
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productGroupNames);
//
//        autoCompleteTextViewProductGroup.setAdapter(arrayAdapter);
//
//        autoCompleteTextViewProductGroup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                autoCompleteTextViewProductGroup.showDropDown();
//            }
//        });
//
//        ArrayAdapter<String> productGroupArrayAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, productGroupNames);
//        productGroupArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        productGroupSpinner.setAdapter(productGroupArrayAdapter);
//
//
//        ArrayAdapter<String> literatureArrayAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, literatureNames);
//        literatureArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        literatureSpinner.setAdapter(literatureArrayAdapter);
//
//        ArrayAdapter<String> physicianSampleArrayAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, physicianSampleNames);
//        physicianSampleArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        physicianSampleSpinner.setAdapter(physicianSampleArrayAdapter);
//
//        ArrayAdapter<String> giftArrayAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, giftNames);
//        giftArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        giftSpinner.setAdapter(giftArrayAdapter);

    }

}
