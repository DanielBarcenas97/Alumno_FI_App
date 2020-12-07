package com.example.cmejercicio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmejercicio_1.model.Student;

import static com.example.cmejercicio_1.utils.Dates.returnAge;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    EditText etName;
    EditText etLastName;
    EditText etNumAccount;
    Button   btnContinue;
    DatePicker dpCalendar;
    Spinner  sCareers;

    String[] careers = {getString(R.string.sistemas_biomedicos),getString(R.string.industrial),getString(R.string.electrica),getString(R.string.mecanica),getString(R.string.minas),getString(R.string.petrolera),getString(R.string.ambiental),getString(R.string.aeroespacial),getString(R.string.computacion), getString(R.string.mecatronica), getString(R.string.civil), getString(R.string.geomatica), getString(R.string.geofisica),getString(R.string.telecom)};
    String career;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        etLastName = findViewById(R.id.et_last_name);
        etName = findViewById(R.id.et_name);
        etNumAccount = findViewById(R.id.et_num_account);
        btnContinue = findViewById(R.id.btn_continue);
        dpCalendar = findViewById(R.id.dp_calendar);
        sCareers = (Spinner) findViewById(R.id.s_carrers);
        sCareers.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,careers);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        sCareers.setAdapter(aa);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName != null && etLastName!=null && etNumAccount!=null ){
                    if(dpCalendar != null){
                        if(sCareers != null){
                            String name = etName.getText().toString();
                            String lastName = etLastName.getText().toString();

                            String allName = name + " " + lastName;

                            String numAccount = etNumAccount.getText().toString();

                            String date = String.valueOf(dpCalendar.getMaxDate());
                            int age = returnAge(date).getYears();

                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            intent.putExtra("student", new Student(allName,numAccount,career,age));
                            startActivity(intent);

                        }else{
                            Toast.makeText(getApplicationContext(), R.string.toast_careers, Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), R.string.toast_date_born, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), R.string.toast_introduce, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),careers[i] , Toast.LENGTH_LONG).show();
        career = careers[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}