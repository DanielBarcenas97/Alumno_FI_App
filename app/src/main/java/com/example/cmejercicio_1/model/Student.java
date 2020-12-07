package com.example.cmejercicio_1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    String name;
    String numAccount;
    String career;
    int age;
    
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public Student(String name, String numAccount, String career, int age) {
        this.name = name;
        this.numAccount = numAccount;
        this.career = career;
        this.age = age;
    }

    public Student(Parcel in){
        this.name = in.readString();
        this.numAccount = in.readString();
        this.career =  in.readString();
        this.age =  in.readInt();
    }

    public int getAge() {
        return age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }

    public void setCareer(String career) {
        this.career = career;
    }


    public String getName() {
        return name;
    }

    public String getNumAccount() {
        return numAccount;
    }

    public String getCareer() {
        return career;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(this.name);
        dest.writeString(this.numAccount);

        dest.writeString(this.career);
        dest.writeInt(this.age);
    }
}
