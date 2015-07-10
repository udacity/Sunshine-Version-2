package com.example.android.sunshine.app.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.android.sunshine.app.R;
import com.example.android.sunshine.app.Utility;

import java.util.concurrent.ExecutionException;

import static com.example.android.sunshine.app.util.VersionUtil.isLaterHoneyComb;

/**
 * Created by Администратор on 7/9/2015.
 */
public class ImageUtil {


    public static void loadImage(Context context, int weatherId, ImageView imageView) {
        Glide.with(context).load(Utility.getArtUrlForWeatherCondition(context, weatherId))
                .error(Utility.getIconResourceForWeatherCondition(weatherId))
                .into(imageView);
    }

    public static Bitmap getLargeBitmap(Context context, String artUrl, int artResourceId, int largeIconWidth, int largeIconHeight) {
        try {
            return Glide.with(context).load(artUrl).asBitmap().error(artResourceId).into(largeIconWidth, largeIconHeight).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap getLargeBitmap(Context context, int weatherId) {
        return getLargeBitmap(context, Utility.getArtUrlForWeatherCondition(context, weatherId), Utility.getIconResourceForWeatherCondition(weatherId), getLargeIconWidth(context), getLargeIconHeight(context));
    }

    public static int getLargeIconWidth(Context context) {
        if (context != null) {
            Resources res = context.getResources();
            return res.getDimensionPixelSize(isLaterHoneyComb() ? android.R.dimen.notification_large_icon_width : R.dimen.notification_large_icon_default);
        } else {
            return 0;
        }

    }

    public static int getLargeIconHeight(Context context) {
        if (context != null) {
            Resources res = context.getResources();
            return res.getDimensionPixelSize(isLaterHoneyComb() ? android.R.dimen.notification_large_icon_height : R.dimen.notification_large_icon_default);
        } else {
            return 0;
        }

    }
}
