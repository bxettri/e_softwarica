package com.example.e_softwarica.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.e_softwarica.fragments.aboutFragment;
import com.example.e_softwarica.fragments.addStudentFragment;
import com.example.e_softwarica.fragments.homeFragment;
import com.example.e_softwarica.R;
import com.example.e_softwarica.model.modelStudent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<modelStudent> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);



        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new homeFragment()).commit();


        studentList = new ArrayList<>();
        studentList.add(new modelStudent("Bibek dahal", "BRT", "Male", 55, R.drawable.ic_person));
        studentList.add(new modelStudent("Shyam Ayadi", "Jomsom", "Male", 44, R.drawable.ic_person));
        studentList.add(new modelStudent("Swarnim Rimal", "Kathmandu", "Female", 44, R.drawable.girl));




    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch(menuItem.getItemId()){
                        case R.id.home:
                            selectedFragment = new homeFragment();
                            setTitle("Home");
                            break;

                        case R.id.addStudent:
                            selectedFragment = new addStudentFragment();
                            setTitle("Add Student");
                            break;

                        case R.id.about:
                            selectedFragment = new aboutFragment();
                            setTitle("About Us");
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
                    return true;
                }
            };
}
