package in17food.farmerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button launchBestPractices;
    Button launchBenefitsColdStorage;
    Button launchFGA;
    Button launchGovernmentSchemes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchBestPractices = (Button) findViewById(R.id.best_practices);
        launchBestPractices.setOnClickListener(MainActivity.this);

        launchBenefitsColdStorage = (Button) findViewById(R.id.best_practices);
        launchBenefitsColdStorage.setOnClickListener(MainActivity.this);

        launchBestPractices = (Button) findViewById(R.id.best_practices);
        launchBestPractices.setOnClickListener(MainActivity.this);

        launchBestPractices = (Button) findViewById(R.id.best_practices);
        launchBestPractices.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.best_practices){
            Intent intent = new Intent(this, BestPractices.class);
            startActivity(intent);
        }
    }
}
