package com.food.recommand_for_eat;

import android.app.Activity;
import android.os.Bundle;

//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.lang.ref.WeakReference;

public class MainActivity extends Activity {

    private final MyHandler handler = new MyHandler(this);

    //사용자가 먹게될 음식을 표현하는 ImageView
    ImageView imageView;

    //사용자가 선택한 음식의 이름을 표현하는 TextView
    TextView choosen_food_name;

    //사용자가 원하는 타이밍에 버튼으로 음식을 선택하기위해 있는 버튼
    Button button;

    int test=0;
    int backValue = 0;
    Back_Thread thread;
    boolean stop=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity_main을 시작화면으로 설정
        imageView  = findViewById(R.id.imageView0);
        choosen_food_name=findViewById(R.id.choosen_food_name);
        button=findViewById(R.id.button);

        imageView.setImageResource(R.drawable.question);

        //애드뷰 변수 선언
        AdView mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



    }       //onCreate end

    class MyHandler extends Handler{                     //MyHandler start
        private final WeakReference<MainActivity> weakReference;

        public MyHandler(MainActivity activity){
            this.weakReference=new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            if(msg.what == 0){
                imageView.setImageResource(R.drawable.food_0);
                choosen_food_name.setText("양념치킨");
            }
            else if(msg.what == 1){
                imageView.setImageResource(R.drawable.food_1);
                choosen_food_name.setText("떡볶이");
            }
            else if(msg.what == 2){
                imageView.setImageResource(R.drawable.food_2);
                choosen_food_name.setText("족발");
            }
            else if(msg.what == 3){
                imageView.setImageResource(R.drawable.food_3);
                choosen_food_name.setText("피자");
            }
            else if(msg.what == 4){
                imageView.setImageResource(R.drawable.food_4);
                choosen_food_name.setText("짬뽕");
            }
            else if(msg.what == 5){
                imageView.setImageResource(R.drawable.food_5);
                choosen_food_name.setText("짜장면");
            }
            else if(msg.what == 6){
                imageView.setImageResource(R.drawable.food_6);
                choosen_food_name.setText("비빔국수");
            }
            else if(msg.what == 7){
                imageView.setImageResource(R.drawable.food_7);
                choosen_food_name.setText("우동");
            }
            else if(msg.what == 8){
                imageView.setImageResource(R.drawable.food_8);
                choosen_food_name.setText("라멘");
            }
            else if(msg.what == 9){
                imageView.setImageResource(R.drawable.food_9);
                choosen_food_name.setText("햄버거");
            }
            else if(msg.what == 10){
                imageView.setImageResource(R.drawable.food_10);
                choosen_food_name.setText("김밥");
            }
            else if(msg.what == 11){
                imageView.setImageResource(R.drawable.food_11);
                choosen_food_name.setText("국밥");
            }
            else if(msg.what == 12){
                imageView.setImageResource(R.drawable.food_12);
                choosen_food_name.setText("감자탕");
            }
            else if(msg.what == 13){
                imageView.setImageResource(R.drawable.food_13);
                choosen_food_name.setText("초밥");
            }
            else if(msg.what == 14){
                imageView.setImageResource(R.drawable.food_14);
                choosen_food_name.setText("쌀국수");
            }
            else if(msg.what == 15){
                imageView.setImageResource(R.drawable.food_15);
                choosen_food_name.setText("비빔밥");
            }
            else if(msg.what == 16){
                imageView.setImageResource(R.drawable.food_16);
                choosen_food_name.setText("스파게티");
            }
            else if(msg.what == 17){
                imageView.setImageResource(R.drawable.food_17);
                choosen_food_name.setText("라면");
            }
            else if(msg.what == 18){
                imageView.setImageResource(R.drawable.food_18);
                choosen_food_name.setText("김치볶음밥");
            }
            else if(msg.what == 19){
                imageView.setImageResource(R.drawable.food_19);
                choosen_food_name.setText("삼겹살");
            }
            else if(msg.what == 20){
                imageView.setImageResource(R.drawable.food_20);
                choosen_food_name.setText("수육");
            }
            else if(msg.what == 21){
                imageView.setImageResource(R.drawable.food_21);
                choosen_food_name.setText("회");
            }
            else if(msg.what == 22){
                imageView.setImageResource(R.drawable.food_22);
                choosen_food_name.setText("백반 정식");
            }


        }

    }       // MyHandler end

    class Back_Thread extends Thread{
        @Override
        public void run() {
            while(stop){
                System.out.println("test : "+test);
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(backValue);
                backValue++;
                test++;
                if(backValue>=23){
                    backValue=0;
                }

            } // end while
        } // end run()
    } // end class BackThread

    public void onButton1Clicked(View v){
        if(stop){
            stop=false;
            button.setText("다시하기!!");
        }
        else{
            stop=true;
            // 스레즈 생성하고 시작
            thread = new Back_Thread();
            thread.setDaemon(true);
            thread.start();
            button.setText("랜덤 음식 선택하기");
        }

    }

}