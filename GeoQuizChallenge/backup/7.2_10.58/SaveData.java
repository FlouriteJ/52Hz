package com.bignerdranch.android.geoquiz;

import java.io.FileOutputStream;

import android.content.Context;

// 此文件无用
/**
 * 保存用户名和密码的业务方法
 * Context  上下文 就是一个类，提供一些方便的api，
 * 可以得到应用程序的环境 环境包名 安装路径 文件的路径 资源的路径 资产的路径
 */
public class SaveData {
    public static void saveUserInfo(Context context, String name, String password) {
        FileOutputStream fos = null;
        try {
            context.openFileOutput("private.txt", Context.MODE_APPEND);
            fos.write((name + "##" + password).getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
