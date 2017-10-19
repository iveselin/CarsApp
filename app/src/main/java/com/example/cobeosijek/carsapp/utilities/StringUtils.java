package com.example.cobeosijek.carsapp.utilities;

import android.text.TextUtils;

/**
 * Created by Ivan on 19.10.2017..
 */

public class StringUtils {
    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
