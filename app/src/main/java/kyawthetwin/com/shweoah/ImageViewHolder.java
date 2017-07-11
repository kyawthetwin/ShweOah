package kyawthetwin.com.shweoah;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.freegeek.android.materialbanner.holder.Holder;
import com.squareup.picasso.Picasso;

import java.lang.annotation.Target;

import kyawthetwin.com.shweoah.Model.BannerData;

import static android.R.attr.data;

/**
 * Created by kyawthetwin on 7/10/17.
 */

public class ImageViewHolder implements Holder<BannerData> {

    private ImageView imageView;
    private TextView title;
    private ProgressBar progressBar;

    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner,null);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        title = (TextView) view.findViewById(R.id.txt_title);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return view;
    }

    @Override
    public void UpdateUI(Context context, int i, BannerData bannerData) {
        title.setText(bannerData.getTitle());
        Picasso.with(context)
                .load(bannerData.getUrl())
                .into(new com.squareup.picasso.Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        progressBar.setVisibility(View.GONE);
                        imageView.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
    }
}
