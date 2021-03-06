package io.github.plastix.forage.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.Window;

public class ActivityUtils {

    private ActivityUtils() {
        throw new UnsupportedOperationException("No Instantiation!");
    }

    /**
     * Returns an intent for launching the application settings for the app with the specified activity.
     *
     * @param context Context instance
     * @return Intent object.
     */
    public static Intent getApplicationSettingsIntent(@NonNull Context context) {
        Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + context.getPackageName()));

        return intent;
    }

    /**
     * Overloaded version of {@link #setSupportActionBarTitle(Activity, String)}.
     *
     * @param activity Activity to set action bar on.
     * @param titleID  String ID of title.
     */
    public static void setSupportActionBarTitle(@NonNull Activity activity, @StringRes int titleID) {
        setSupportActionBarTitle(activity, activity.getString(titleID));
    }

    /**
     * Sets the support action bar title for the specified activity.
     *
     * @param activity Activity to set action bar on. Must be a {@link AppCompatActivity}.
     * @param title    String title to set.
     */
    public static void setSupportActionBarTitle(@NonNull Activity activity, String title) {
        ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    /**
     * Sets the support action bar back button. The activity still has to manage the back button
     * event correctly!
     *
     * @param delegate AppCompatDelegate for the AppCompatActivity you want to modify.
     */
    public static void setSupportActionBarBack(@NonNull AppCompatDelegate delegate) {
        ActionBar bar = delegate.getSupportActionBar();
        if (bar != null) {
            delegate.getSupportActionBar().setDisplayShowHomeEnabled(true);
            delegate.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public static void setStatusBarTranslucent(AppCompatActivity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.addFlags(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.setStatusBarColor(Color.TRANSPARENT);

        }

    }

}
