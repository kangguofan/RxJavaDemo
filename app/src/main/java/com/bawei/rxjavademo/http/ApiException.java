package com.bawei.rxjavademo.http;

/**
 * Created by 姜鹏 on 2017/2/21.
 */

public class ApiException extends RuntimeException {

    private String mMessage;

    public ApiException(String reason){
          super(reason);
        this.mMessage = reason;
    }

    public ApiException(int code){
         this.createMessag(code);
    }

    public void createMessag(int code){
          switch (code){
              case 300:
                  mMessage = "密码错误";
                  break;
          }
    }
    public String getmMessage(){
        return mMessage;
    }
}
