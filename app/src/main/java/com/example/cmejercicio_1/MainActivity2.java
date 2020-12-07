package com.example.cmejercicio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cmejercicio_1.model.Student;

import java.text.MessageFormat;

public class MainActivity2 extends AppCompatActivity {

    TextView mName;
    TextView mNumAccount;
    TextView mAge;
    TextView mCareer;
    ImageView mImage;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mName = findViewById(R.id.tv_name);
        mNumAccount = findViewById(R.id.tv_num_account);
        mAge = findViewById(R.id.tv_age);
        mCareer = findViewById(R.id.tv_career);
        mImage = findViewById(R.id.iv_image);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            student = (Student) data.getParcelable("student");
        }
        init();
    }

    private void init() {
        int pos = getIntent().getExtras().getInt("position") +1;
        mName.setText(student.getName());
        mNumAccount.setText(student.getNumAccount());
        mCareer.setText(student.getCareer());
        mAge.setText(MessageFormat.format(getString(R.string.txt_age), student.getAge()));

        switch (pos){
            case 1:
                mImage.setImageResource(R.drawable.image1);
                break;
            case 2:
                mImage.setImageResource(R.drawable.image2);
                break;
            case 3:
                mImage.setImageResource(R.drawable.image3);
                break;
            case 4:
                mImage.setImageResource(R.drawable.image4);
                break;
            case 5:
                mImage.setImageResource(R.drawable.image5);
                break;
            case 6:
                mImage.setImageResource(R.drawable.image6);
                break;
            case 7:
                mImage.setImageResource(R.drawable.image7);
                break;
            case 8:
                mImage.setImageResource(R.drawable.image8);
                break;
            case 9:
                mImage.setImageResource(R.drawable.image9);
                break;

            case 10:
                mImage.setImageResource(R.drawable.image10);
                break;

            case 11:
                mImage.setImageResource(R.drawable.image11);
                break;

            case 12:
                mImage.setImageResource(R.drawable.image12);
                break;

            case 13:
                mImage.setImageResource(R.drawable.image13);
                break;

            case 14:
                mImage.setImageResource(R.drawable.image14);
                break;



        }
    }
}