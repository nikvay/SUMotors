package com.nikvay.sumotors.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.inputmethod.InputMethodManager;

public class Const {

    //====== open key bord =====
    public static void openKeyBord(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    //====== image file ========
    public static void scanFile(Context mContext, Uri fromFile) {
        Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        scanIntent.setData(fromFile);
        mContext.sendBroadcast(scanIntent);

    }


}
