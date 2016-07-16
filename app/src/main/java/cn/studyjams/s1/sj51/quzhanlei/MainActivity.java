package cn.studyjams.s1.sj51.quzhanlei;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void listenEnglish(View v) {
        Intent intent = new Intent(this, ListenActivity.class);
        startActivity(intent);

    }

    public void sayEnglish(View v) {
        Intent intent = new Intent(this, SayActivity.class);
        startActivity(intent);
    }

    public void readEnglish(View v) {
        Intent intent = new Intent(this, ReadActivity.class);
        startActivity(intent);
    }

    public void writeEnglish(View v) {
        Intent intent = new Intent(this, WriteActivity.class);
        startActivity(intent);
    }

    public void useEnglish(View v) {
        Intent intent = new Intent(this, UseActivity.class);
        startActivity(intent);
    }

    /**
     * feedback to us according email.
     * @param v
     */
    public void feedBack(View v) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:jonemill@qq.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "FeedBackToUS");
        intent.putExtra(Intent.EXTRA_TEXT, "写下对我们的意见：");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }


    /**
     * double back will kill the app.
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), R.string.back, Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
