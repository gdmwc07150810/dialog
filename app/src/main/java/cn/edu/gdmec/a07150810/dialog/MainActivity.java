package cn.edu.gdmec.a07150810.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1= (TextView) findViewById(R.id.charactor);
        t2 = (TextView) findViewById(R.id.uidate);
        t3 = (TextView) findViewById(R.id.uitime);
    }
    public void characterpickerdialog(View v){
        final String str = "34297108#65*";
        CharacterPickerDialog  ch = new CharacterPickerDialog(this,new View(this),null,str,false){
            @Override
            public void onClick(View v) {
                t1.append(((Button)v).getText().toString());
                if(((Button)v).getText().toString().equals("")){
                    dismiss();
                }
            }
        };
        ch.show();
    }
    public void datepickerdialog(View v){
        DatePickerDialog date = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){


            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                t2.setText("日期:"+year+"-"+(month+1)+"-"+dayOfMonth);
            }
        },2016,10,25);
        date.show();


    }


    public void timepickerdialog(View v){
        TimePickerDialog time = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener(){

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                t3.setText("时间："+hourOfDay+":"+minute);
            }
        },9,15,true);
        time.show();
    }


    public void progressdialog(View v){
        final ProgressDialog pro = ProgressDialog.show(this,"加载中","加载中.........",true);
        pro.show();
        new Thread(){
            @Override
            public void run() {
                try{
                    sleep(4000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    pro.dismiss();
                }
            }
        }.start();
    }
}