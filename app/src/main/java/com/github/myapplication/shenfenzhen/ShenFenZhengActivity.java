package com.github.myapplication.shenfenzhen;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.myapplication.R;
import com.github.myapplication.shenfenzhen.utils.FileUtils;
import com.github.myapplication.shenfenzhen.utils.PermissionsUtils;
import com.github.myapplication.shenfenzhen.utils.PictureUtils;
import com.github.myapplication.shuiyin.ImageUtil;

import java.io.IOException;

import static com.github.myapplication.shenfenzhen.CameraActivity.RESULT_CODE;
import static com.github.myapplication.shenfenzhen.CameraActivity.TYPE_IDCARD_BACK;
import static com.github.myapplication.shenfenzhen.CameraActivity.TYPE_IDCARD_FRONT;

public class ShenFenZhengActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mPictureOne;
    private ImageView mPictureTwo;
    private TextView mTextviewOne;
    private TextView mTextviewTwo;

    private TextView mWatermark;


    private int mType = 0;

    String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};



    public static void openCertificateCamera(Activity activity) {
        Intent intent = new Intent(activity, ShenFenZhengActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shen_qing);

        Log.i("karson","ShenFenZhengActivity");
        init();
    }

    private void init(){

        mPictureOne = findViewById(R.id.picture_one);
        mPictureTwo = findViewById(R.id.picture_two);
        mTextviewOne = findViewById(R.id.text_one);
        mTextviewTwo = findViewById(R.id.text_two);

        mWatermark = new TextView(this);
        mWatermark.setText("我是一个水印");
        mWatermark.setTextSize(22);


        mPictureOne.setOnClickListener(this);
        mPictureTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.picture_one:
                mType = 1;
                PermissionsUtils.showSystemSetting = false;//是否支持显示系统设置权限设置窗口跳转
                //这里的this不是上下文，是Activity对象！
                PermissionsUtils.getInstance().chekPermissions(this, permissions, permissionsResult);
                break;
            case R.id.picture_two:
                mType = 2;
                PermissionsUtils.showSystemSetting = false;//是否支持显示系统设置权限设置窗口跳转
                //这里的this不是上下文，是Activity对象！
                PermissionsUtils.getInstance().chekPermissions(this, permissions, permissionsResult);
                break;

        }
    }

    //创建监听权限的接口对象
    PermissionsUtils.IPermissionsResult permissionsResult = new PermissionsUtils.IPermissionsResult() {
        @Override
        public void passPermissons() {
            switch (mType){
                case 1:
                    CameraActivity.openCertificateCamera(ShenFenZhengActivity.this,TYPE_IDCARD_FRONT);
                    break;
                case 2:
                    CameraActivity.openCertificateCamera(ShenFenZhengActivity.this,TYPE_IDCARD_BACK);
                    break;
            }
        }

        @Override
        public void forbitPermissons() {
            Toast.makeText(ShenFenZhengActivity.this, "权限不通过!", Toast.LENGTH_SHORT).show();
        }
    };

    //返回值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (mType){
            case 1:
                if (resultCode == RESULT_CODE){
                    String filePath = data.getStringExtra("result");
                    if (filePath != null){
                        try {
                            Bitmap srcBitmap = PictureUtils.decodeFile(filePath);
                            //隐藏文字
                            mTextviewOne.setVisibility(View.GONE);
                            //展示图片
                            mPictureOne.setImageBitmap(srcBitmap);
                            //添加水印并保存
                            addWaterMark(srcBitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case 2:
                if (resultCode == RESULT_CODE){
                    if (resultCode == RESULT_CODE){
                        String filePath = data.getStringExtra("result");
                        if (filePath != null){
                            try {
                                Bitmap srcBitmap = PictureUtils.decodeFile(filePath);
                                //隐藏文字
                                mTextviewTwo.setVisibility(View.GONE);
                                //展示图片
                                mPictureTwo.setImageBitmap(srcBitmap);
                                //添加水印并保存
                                addWaterMark(srcBitmap);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                break;
        }
    }

    /**
     * 添加水印
     * */
    private void addWaterMark(Bitmap resource){
        //添加文字水印
        Bitmap watermarkBitmap = ImageUtil.createWaterMaskLeftBottom(
                resource,
                ImageUtil.viewToBitmap(mWatermark),
                0,
                0
        );
        //保存图片
        saveBitmap(watermarkBitmap);
    }


    /**
     * 保存图片
     * */
    private void saveBitmap(Bitmap resource){
        FileUtils.savePhoto(ShenFenZhengActivity.this, resource, new FileUtils.SaveResultCallback() {
            @Override
            public void onSavedSuccess() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ShenFenZhengActivity.this, "保存成功!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onSavedFailed() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ShenFenZhengActivity.this, "保存失败!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    //权限返回值
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //就多一个参数this
        PermissionsUtils.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

}
