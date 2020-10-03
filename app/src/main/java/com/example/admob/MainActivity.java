package com.example.admob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    Button btShow;
    AdView adView1,adView2;
    InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btShow = findViewById(R.id.bt_show);
        adView1 = findViewById(R.id.ad_view1);
        adView2 = findViewById(R.id.ad_view2);

        MobileAds.initialize(this, "ca-app-pub-5245362487102890~8072584105");

        AdRequest adRequest = new AdRequest.Builder().build();
        adView1.loadAd(adRequest);
        adView2.loadAd(adRequest);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5245362487102890/2616738138");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interstitialAd.show();
            }
        });
    }
}