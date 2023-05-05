
/*
                Name = Surpreet singh
                Student Id = 218663803
                Unit = SIT305-Task5.1
*/



package com.application.week5recyclerviewcloudsession;

// Import classes from libraries
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

// MainActivity class definition
public class MainActivity extends AppCompatActivity {



    // Called when the activity is starting
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// Set the layout for the activity

        // Create a new instance of MainFragment
        Fragment fragment = MainFragment.newInstance();
        // Begin a transaction to replace the content of the activity with the fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.abcd,fragment,"Main Fragment");
        transaction.commit(); // Commit the transaction and replace the content

    }


}