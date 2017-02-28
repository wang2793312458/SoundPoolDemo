package com.example.soundpooldemo;

import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_play1)
    Button mBtnPlay1;
    @BindView(R.id.btn_play2)
    Button mBtnPlay2;
    @BindView(R.id.btn_play3)
    Button mBtnPlay3;
    @BindView(R.id.btn_play4)
    Button mBtnPlay4;
    @BindView(R.id.btn_play5)
    Button mBtnPlay5;
    @BindView(R.id.btn_release)
    Button mBtnRelease;

    private AssetManager aManager;
    private SoundPool mSoundPool = null;
    private HashMap<Integer, Integer> soundID = new HashMap<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        aManager = getAssets();
        try {
            initSP();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initSP()throws Exception {
        //设置最多可容纳5个音频流，音频的品质为5
        mSoundPool = new SoundPool(5, AudioManager.STREAM_SYSTEM, 5);
        soundID.put(1, mSoundPool.load(this, R.raw.duang, 1));
        soundID.put(2 , mSoundPool.load(getAssets().openFd("biaobiao.mp3") , 1));  //需要捕获IO异常
        soundID.put(3, mSoundPool.load(this, R.raw.duang, 1));
        soundID.put(4, mSoundPool.load(this, R.raw.duang, 1));
        soundID.put(5, mSoundPool.load(this, R.raw.duang, 1));

    }

    @OnClick({R.id.btn_play1, R.id.btn_play2, R.id.btn_play3, R.id.btn_play4, R.id.btn_play5, R.id.btn_release})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_play1:
                mSoundPool.play(soundID.get(1), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_play2:
                mSoundPool.play(soundID.get(2), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_play3:
                mSoundPool.play(soundID.get(3), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_play4:
                mSoundPool.play(soundID.get(4), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_play5:
                mSoundPool.play(soundID.get(5), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_release:
                mSoundPool.release();   //回收SoundPool资源
                break;
        }
    }
}
