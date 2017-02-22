package com.bawei.rxjavademo.http;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

import com.bawei.rxjavademo.R;

/**
 * Created by 姜鹏 on 2017/2/21.
 */

public class CustomDialog {

    private static CustomDialog mCustonDialog;
    private Context mContext;
    private Dialog mDialog;
    private DialogCancelLisenter lisenter;

    private CustomDialog(Context context,DialogCancelLisenter lisenter){
        this.mContext = context;
        this.lisenter = lisenter;
        initDialog();
    }

    private void initDialog() {
        mDialog = new Dialog(mContext, R.style.loadstyle);
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_dialog,null);
        mDialog.setCancelable(true); //点击返回按钮是否让dialog消失
        mDialog.setCanceledOnTouchOutside(false); //点击外部是否消失
        mDialog.setContentView(view);

        mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                //回调Dialog消失的方法
                if(lisenter != null){
                    lisenter.onCancel();
                }
            }
        });
    }

    public static CustomDialog getInstance(Context context,DialogCancelLisenter lisenter){
        if(mCustonDialog == null){
              synchronized (CustomDialog.class){
                  if(mCustonDialog == null){
                      mCustonDialog = new CustomDialog(context,lisenter);
                  }
              }
        }
        return mCustonDialog;
    }

    public interface DialogCancelLisenter{
        void onCancel();
    }

    public void show(){
        if(mDialog != null && !mDialog .isShowing()){
            mDialog.show();
        }
    }

    public void dissmiss(){
        if(mDialog != null && mDialog .isShowing()){
            mDialog.dismiss();
        }
    }

}
