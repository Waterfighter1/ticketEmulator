package com.example.ticketemulator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // var bank
    double costPerTicket = 79.99;
    int numberOfTickets; // get the number selected from the UI / User
    double totalCost; // holds the cost (numOfTickets * costPerTicket)
    String groupChoice; // holds the group selected from the spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // get all of the views
        EditText tickets = (EditText) findViewById(R.id.txtTickets);
        Spinner group = (Spinner) findViewById(R.id.txtGroup); // the group
        Button cost = (Button) findViewById(R.id.btnCost); // click the button
        TextView result = (TextView) findViewById(R.id.txtResult);

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                totalCost = numberOfTickets * costPerTicket;
                DecimalFormat df = new DecimalFormat("$###,###.###");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Cost for " + numberOfTickets + " " + groupChoice + " tickets is " + df.format(totalCost));
            }
        });

    }
}