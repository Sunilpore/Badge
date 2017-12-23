package com.example.sunil.badgeeg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static com.example.sunil.badgeeg.R.id.strawberry_incr;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvStraw,tvLab,tvCal;
    ToggleButton tgStraw,tgLab,tgCal;
    Button incrStraw,incrLab,incrCal;
    Button decrStraw,decrLab,decrCal;
    Button clear;
    View actionView;

    Toolbar myToolbar;
    MenuItem notifyMenuItem;

    ImageButton mImgBt;
    TextView mCount;
    int sumCount;

    static int Straw,Lab,Cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar= (Toolbar) findViewById(R.id.toolbar_lay);
        setSupportActionBar(myToolbar);

        tvStraw= (TextView) findViewById(R.id.badge_notify1);
        tvLab= (TextView) findViewById(R.id.badge_notify2);
        tvCal= (TextView) findViewById(R.id.badge_notify3);

        tgStraw= (ToggleButton) findViewById(R.id.toggle_strawberry);
        tgLab= (ToggleButton) findViewById(R.id.toggle_label);
        tgCal= (ToggleButton) findViewById(R.id.toggle_calender);

        incrStraw= (Button) findViewById(strawberry_incr);
        incrLab= (Button) findViewById(R.id.label_incr);
        incrCal= (Button) findViewById(R.id.calender_incr);

        decrStraw= (Button) findViewById(R.id.strawberry_decr);
        decrLab= (Button) findViewById(R.id.label_decr);
        decrCal= (Button) findViewById(R.id.calender_decr);

        clear= (Button) findViewById(R.id.clearall_button);

        tgStraw.setOnClickListener(this);tgLab.setOnClickListener(this);tgCal.setOnClickListener(this);
        incrStraw.setOnClickListener(this);incrLab.setOnClickListener(this);incrCal.setOnClickListener(this);
        decrStraw.setOnClickListener(this);decrLab.setOnClickListener(this);decrCal.setOnClickListener(this);
        clear.setOnClickListener(this);

        tvStraw.setText(String.valueOf(Straw));
        tvLab.setText(String.valueOf(Lab));
        tvCal.setText(String.valueOf(Cal));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        notifyMenuItem=menu.findItem(R.id.count_menuitem);
            actionView=notifyMenuItem.getActionView();

            if(actionView!=null){
                mImgBt=actionView.findViewById(R.id.ib_notification_base);
                mCount=actionView.findViewById(R.id.tv_notification);
            }

            mImgBt.setOnClickListener(this);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.strawberry_incr:
                if(tgStraw.isChecked()){
                    Straw++;
                    sumCount++;
                    tvStraw.setText(String.valueOf(Straw));
                    mCount.setText(String.valueOf(sumCount));
                }
                break;

            case R.id.strawberry_decr:
                Toast.makeText(this, "ON/OFF"+tgStraw.isChecked()+"\n"+Straw, Toast.LENGTH_SHORT).show();
                if(tgStraw.isChecked() && Straw>0){
                    Straw--;
                    tvStraw.setText(String.valueOf(Straw));
                }
                break;

            case R.id.label_incr:
                if(tgLab.isChecked()){
                    Lab++;
                    tvLab.setText(String.valueOf(Lab));
                }
                break;

            case R.id.label_decr:
                if(tgLab.isChecked() && Lab>0){
                    Lab--;
                    tvLab.setText(String.valueOf(Lab));
                }
                break;


            case R.id.calender_incr:
                if(tgCal.isChecked()){
                    Cal++;
                    tvCal.setText(String.valueOf(Cal));
                }
                break;

            case R.id.calender_decr:
                if(tgCal.isChecked() && Cal>0){
                    Cal--;
                    tvCal.setText(String.valueOf(Cal));
                }
                break;

            case R.id.clearall_button:
                if(tgStraw.isChecked() && tgLab.isChecked() && tgCal.isChecked()){
                    Straw=0;Lab=0;Cal=0;
                    tvStraw.setText(String.valueOf(Straw));
                    tvLab.setText(String.valueOf(Lab));
                    tvCal.setText(String.valueOf(Cal));
                }
                else if(tgStraw.isChecked() && tgLab.isChecked()){
                    Straw=0;Lab=0;
                    tvStraw.setText(String.valueOf(Straw));
                    tvLab.setText(String.valueOf(Lab));
                }
                else if(tgStraw.isChecked() && tgCal.isChecked()){
                    Straw=0;Cal=0;
                    tvStraw.setText(String.valueOf(Straw));
                    tvCal.setText(String.valueOf(Cal));
                }
                else if(tgLab.isChecked()&& tgCal.isChecked()){
                    Lab=0;Cal=0;
                    tvLab.setText(String.valueOf(Lab));
                    tvCal.setText(String.valueOf(Cal));
                }
                else if(tgStraw.isChecked()){
                    Straw=0;
                    tvStraw.setText(String.valueOf(Straw));
                }
                else if(tgLab.isChecked()){
                    Lab=0;
                    tvLab.setText(String.valueOf(Lab));
                }
                else if(tgCal.isChecked()){
                    Cal=0;
                    tvCal.setText(String.valueOf(Cal));
                }
                break;

            case R.id.ib_notification_base:
                Toast.makeText(this, "Image Button clicked", Toast.LENGTH_SHORT).show();
                break;

        }

    }


}
