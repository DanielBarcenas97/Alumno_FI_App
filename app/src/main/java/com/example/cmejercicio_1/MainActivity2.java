package com.example.cmejercicio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cmejercicio_1.model.Student;

import java.text.MessageFormat;

public class MainActivity2 extends AppCompatActivity {

    TextView mName;
    TextView mNumAccount;
    TextView mAge;
    TextView mCareer;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mName = findViewById(R.id.tv_name);
        mNumAccount = findViewById(R.id.tv_num_account);
        mAge = findViewById(R.id.tv_age);
        mCareer = findViewById(R.id.tv_career);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            student = (Student) data.getParcelable("student");
        }
        init();
    }

    private void init() {
        mName.setText(student.getName());
        mNumAccount.setText(student.getNumAccount());
        mCareer.setText(student.getCareer());
        mAge.setText(MessageFormat.format("{0} Años", student.getAge()));

    }
}