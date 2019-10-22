package com.iitism.medtime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;


import java.util.Locale;

public class AddMedicineActivity extends AppCompatActivity implements View.OnClickListener{
    TextView selectedtime;
    Spinner medicinespinner;
    private int hour, minute;
    EditText medicinename;
    Button mon,tue,wed,thu,fri,sat,sun,add;
    String xmedicinename;


    private boolean dayOfWeekList[] = new boolean[7];

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    String selectedmedicine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        medicinename=findViewById(R.id.edt_text_medicine_name);
        mon=findViewById(R.id.select_date_monday);
        tue=findViewById(R.id.select_date_tuesday);
        wed=findViewById(R.id.select_date_wednesday);
        thu=findViewById(R.id.select_date_thursday);
        fri=findViewById(R.id.select_date_friday);
        sat=findViewById(R.id.select_date_saturday);
        sun=findViewById(R.id.select_date_sunday);
        add=findViewById(R.id.btn_add_medicine);

        dayOfWeekList[0]=false;
        dayOfWeekList[1]=false;
        dayOfWeekList[2]=false;
        dayOfWeekList[3]=false;
        dayOfWeekList[4]=false;
        dayOfWeekList[5]=false;
        dayOfWeekList[6]=false;


        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();

        selectedtime=findViewById(R.id.selected_time_txt);
        medicinespinner=(Spinner) findViewById(R.id.medicine_type_spinner);





        String[]medicinetypes=getResources().getStringArray(R.array.medicine_type);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,medicinetypes);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medicinespinner.setAdapter(arrayAdapter);
        medicinespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedmedicine=medicinespinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setCurrentTime();


        selectedtime.setOnClickListener(this);
        mon.setOnClickListener(this);
        tue.setOnClickListener(this);
        wed.setOnClickListener(this);
        thu.setOnClickListener(this);
        fri.setOnClickListener(this);
        sat.setOnClickListener(this);
        sun.setOnClickListener(this);
        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view== selectedtime)
        {
            showTimePicker();
        }
        else if(view==mon)
        {
            if(dayOfWeekList[1]==false)
            {dayOfWeekList[1]=true;
            mon.setBackgroundResource(R.drawable.btn_selected_background);
            Toast.makeText(getApplicationContext(), ""+dayOfWeekList[1], Toast.LENGTH_SHORT).show();}
            else
            {
                dayOfWeekList[1]=false;
                mon.setBackgroundResource(R.drawable.btn_light_background);
                Toast.makeText(getApplicationContext(), ""+dayOfWeekList[1], Toast.LENGTH_SHORT).show();
            }

        }
        else if(view==tue)
        {if(dayOfWeekList[2]==false)
        {dayOfWeekList[1]=true;
            mon.setBackgroundResource(R.drawable.btn_selected_background);
            Toast.makeText(getApplicationContext(), ""+dayOfWeekList[2], Toast.LENGTH_SHORT).show();}
        else
        {
            dayOfWeekList[2]=false;
            mon.setBackgroundResource(R.drawable.btn_light_background);
            Toast.makeText(getApplicationContext(), ""+dayOfWeekList[2], Toast.LENGTH_SHORT).show();
        }



        }
        else if(view==wed)
        {
            if(dayOfWeekList[3]==false)
            {dayOfWeekList[1]=true;
                mon.setBackgroundResource(R.drawable.btn_selected_background);
                Toast.makeText(getApplicationContext(), ""+dayOfWeekList[3], Toast.LENGTH_SHORT).show();}
            else
            {
                dayOfWeekList[3]=false;
                mon.setBackgroundResource(R.drawable.btn_light_background);
                Toast.makeText(getApplicationContext(), ""+dayOfWeekList[3], Toast.LENGTH_SHORT).show();
            }
        }
        else if(view==thu)
        {
            if(dayOfWeekList[4]==false)
            {dayOfWeekList[1]=true;
                mon.setBackgroundResource(R.drawable.btn_selected_background);
                Toast.makeText(getApplicationContext(), ""+dayOfWeekList[4], Toast.LENGTH_SHORT).show();}
            else
            {
                dayOfWeekList[4]=false;
                mon.setBackgroundResource(R.drawable.btn_light_background);
                Toast.makeText(getApplicationContext(), ""+dayOfWeekList[4], Toast.LENGTH_SHORT).show();
            }

        }
        else if(view==fri)
        {
            if(dayOfWeekList[5]==false)
            {dayOfWeekList[1]=true;
                mon.setBackgroundResource(R.drawable.btn_selected_background);
                Toast.makeText(getApplicationContext(), ""+dayOfWeekList[5], Toast.LENGTH_SHORT).show();}
            else
            {
                dayOfWeekList[5]=false;
                mon.setBackgroundResource(R.drawable.btn_light_background);
                Toast.makeText(getApplicationContext(), ""+dayOfWeekList[5], Toast.LENGTH_SHORT).show();
            }
        }
        else if(view==sat)
        {
            if(dayOfWeekList[6]==false)
            {dayOfWeekList[1]=true;
                mon.setBackgroundResource(R.drawable.btn_selected_background);
                Toast.makeText(getApplicationContext(), ""+dayOfWeekList[6], Toast.LENGTH_SHORT).show();}
            else
            {
                dayOfWeekList[6]=false;
                mon.setBackgroundResource(R.drawable.btn_light_background);
                Toast.makeText(getApplicationContext(), ""+dayOfWeekList[6], Toast.LENGTH_SHORT).show();
            }

        }
        else if(view==sun)
        {
            if(dayOfWeekList[0]==false)
            {dayOfWeekList[1]=true;
                mon.setBackgroundResource(R.drawable.btn_selected_background);
                Toast.makeText(getApplicationContext(), ""+dayOfWeekList[0], Toast.LENGTH_SHORT).show();}
            else
            {
                dayOfWeekList[0]=false;
                mon.setBackgroundResource(R.drawable.btn_light_background);
                Toast.makeText(getApplicationContext(), ""+dayOfWeekList[0], Toast.LENGTH_SHORT).show();
            }
        }
        else if(view==add)
        {


        }
    }


    private void showTimePicker() {
        Calendar mCurrentTime = Calendar.getInstance();
        hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
        minute = mCurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(getApplicationContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                selectedtime.setText(String.format(Locale.getDefault(), "%d:%d", selectedHour, selectedMinute));
            }
        }, hour, minute, false);//No 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    private void setCurrentTime() {
        Calendar mCurrentTime = Calendar.getInstance();
        hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
        minute = mCurrentTime.get(Calendar.MINUTE);


        selectedtime.setText(String.format(Locale.getDefault(), "%d:%d", hour, minute));
    }

}
