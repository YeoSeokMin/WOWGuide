package com.example.wowstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivEla, ivHord;
    Button btnHead, btnLog;
    ImageButton ibClass[] = new ImageButton[10]; // 이미지 버튼 배열 선언
    Integer ibClassID[]={R.id.ibWorrier, R.id.ibRouge, R.id.ibDruid, R.id.ibHunter, R.id.ibMagic, R.id.ibBudu, R.id.ibKisa, R.id.ibSaje, R.id.ibSulsa};
    EditText edtID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int a=0; a<ibClassID.length; a++){
            ibClass[a]=(ImageButton)findViewById(ibClassID[a]);
        }
        ivEla = (ImageView)findViewById(R.id.ivEla);
        ivHord = (ImageView)findViewById(R.id.ivHord);
        btnHead = (Button)findViewById(R.id.btnHead);
        btnLog = (Button)findViewById(R.id.btnLog);
        edtID = (EditText)findViewById(R.id.edtID);

        btnHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goHead = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ko.classic.wowhead.com"));
                startActivity(goHead);
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goLog = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.classic.warcraftlogs.com/search/?term="+edtID.getText().toString()));
                startActivity(goLog);
            }
        });
        //전사 버튼 클릭
        ibClass[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWorrier = new Intent(getApplicationContext(),worrierTab.class);
                startActivity(goWorrier);
            }
        });
        //도적 버튼 클릭
        ibClass[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goRouge = new Intent(getApplicationContext(),rougeTab.class);
                startActivity(goRouge);
            }
        });
        //드루이드 버튼 클릭
        ibClass[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goDruid = new Intent(getApplicationContext(),druidTab.class);
                startActivity(goDruid);
            }
        });
        //사냥꾼 버튼 클릭
        ibClass[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goHunter = new Intent(getApplicationContext(),hunterTab.class);
                startActivity(goHunter);

            }
        });
        //마법사 버튼 클릭
        ibClass[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMagic = new Intent(getApplicationContext(),magicTab.class);
                startActivity(goMagic);
            }
        });
        //흑마법사 버튼 클릭
        ibClass[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gobudu = new Intent(getApplicationContext(),buduTab.class);
                startActivity(gobudu);
            }
        });
        //성기사 버튼 클릭
        ibClass[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gokisa = new Intent(getApplicationContext(),kisaTab.class);
                startActivity(gokisa);
            }
        });
        //사제 버튼 클릭
        ibClass[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gosaje = new Intent(getApplicationContext(),sajeTab.class);
                startActivity(gosaje);
            }
        });
        //주술사 버튼 클릭
        ibClass[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gosulsa = new Intent(getApplicationContext(),sulsaTab.class);
                startActivity(gosulsa);
            }
        });
    }
}
