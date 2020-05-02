package fr.steve.leroy.dependentsspinners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Spinner sp_parent, sp_child;

    ArrayList<String> arrayList_parent;
    ArrayAdapter<String> arrayAdapter_parent;


    ArrayList<String> arrayList_animals, arrayList_birds, arrayList_flowers;
    ArrayAdapter<String> arrayAdapter_child;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sp_parent = findViewById(R.id.sp_parent);
        sp_child = findViewById(R.id.sp_child);

        arrayList_parent = new ArrayList<>();
        arrayList_parent.add("Animals");
        arrayList_parent.add("Birds");
        arrayList_parent.add("Flowers");


        arrayAdapter_parent = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_parent);

        sp_parent.setAdapter(arrayAdapter_parent);


        //  ======== child spinner process starts

        arrayList_animals = new ArrayList<>();
        arrayList_animals.add("Tiger");
        arrayList_animals.add("Lion");
        arrayList_animals.add("Elephant");
        arrayList_animals.add("Monkey");
        arrayList_animals.add("Cow");

        arrayList_birds = new ArrayList<>();
        arrayList_birds.add("Sparrow");
        arrayList_birds.add("Peacock");
        arrayList_birds.add("Eagle");

        arrayList_flowers = new ArrayList<>();
        arrayList_flowers.add("Rose");
        arrayList_flowers.add("Lotus");


        sp_parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_animals);
                }
                if (position == 1) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_birds);
                }
                if (position == 2) {
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_flowers);
                }


                sp_child.setAdapter(arrayAdapter_child);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //  ======== child spinner process ends
    }
}
