package com.example.wowstudy;

import android.app.TabActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class sajeTab extends TabActivity {


    ImageView ivDPS, ivTank;
    TextView tvItem1, tvItem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabhost);
        TabHost host = getTabHost();

        ivDPS = (ImageView) findViewById(R.id.ivDPS);
        ivTank = (ImageView) findViewById(R.id.ivTank);
        //암흑 사제 이미지+텍스트
        tvItem1 = (TextView) findViewById(R.id.tvItem1);
        tvItem2 = (TextView) findViewById(R.id.tvItem2);
        //신성 사제 이미지+텍스트

        //스크롤바가 짤리는 문제로 스크롤 메서드 사용.
        tvItem1.setMovementMethod(new ScrollingMovementMethod());
        tvItem2.setMovementMethod(new ScrollingMovementMethod());

        // Tab1 Setting
        {TabHost.TabSpec tabSpec1 = host.newTabSpec("Tab1");
            tabSpec1.setIndicator("암흑 사제"); // 탭에서 보이는 부분
            tabSpec1.setContent(R.id.tab_view1); // Tab Content
            host.addTab(tabSpec1);

            InputStream inputS = getResources().openRawResource(R.raw.sajedps);
            ivDPS.setImageResource(R.drawable.sajedark);
            try {
                byte[] txt = new byte[inputS.available()];
                inputS.read(txt);
                String str = new String(txt);
                tvItem1.setText(str);
                inputS.close();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "파일을 읽을 수 없습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        // Tab2 Setting
        {TabHost.TabSpec tabSpec2 = host.newTabSpec("Tab2");
            tabSpec2.setIndicator("신성 사제"); // Tab Subject
            tabSpec2.setContent(R.id.tab_view2); // Tab Content
            host.addTab(tabSpec2);

            InputStream inputSS = getResources().openRawResource(R.raw.sajehill);
            ivTank.setImageResource(R.drawable.sajehill);
            try {
                byte[] txt = new byte[inputSS.available()];
                inputSS.read(txt);
                String str = new String(txt);
                tvItem2.setText(str);
                inputSS.close();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "파일을 읽을 수 없습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        // show First Tab Content

        host.setCurrentTab(0);

    }
}
