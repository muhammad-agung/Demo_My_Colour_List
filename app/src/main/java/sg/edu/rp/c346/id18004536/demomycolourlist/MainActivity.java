package sg.edu.rp.c346.id18004536.demomycolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etPosition;
    EditText etElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;

    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPosition = findViewById(R.id.editTextIndex);
        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.ListViewColour);


        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                String index = etPosition.getText().toString();
                int position = Integer.parseInt(index)-1;

                alColours.add(position,colour);

                aaColour.notifyDataSetChanged();
            }
        });


        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String index = etPosition.getText().toString();
                int position = Integer.parseInt(index)-1;

                alColours.remove(position);

                aaColour.notifyDataSetChanged();
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                String index = etPosition.getText().toString();
                int position = Integer.parseInt(index)-1;

                alColours.set(position,colour);

                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this,colour,Toast.LENGTH_LONG).show();
            }
        });

    }
}
