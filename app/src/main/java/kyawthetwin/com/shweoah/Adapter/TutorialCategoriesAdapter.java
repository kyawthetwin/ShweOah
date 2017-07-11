package kyawthetwin.com.shweoah.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import kyawthetwin.com.shweoah.Model.ImageForCategories;
import kyawthetwin.com.shweoah.R;

/**
 * Created by kyawthetwin on 7/10/17.
 */

public class TutorialCategoriesAdapter extends RecyclerView.Adapter<TutorialCategoriesAdapter.MyViewHolder> {

    ImageForCategories images;



    public TutorialCategoriesAdapter(ImageForCategories images) {
        this.images = images;
    }
    @Override
    public TutorialCategoriesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tutorial_categories, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TutorialCategoriesAdapter.MyViewHolder holder, int position) {


        holder.imageView.setImageResource(images.getImageId()[position]);



    }

    @Override
    public int getItemCount() {

        return images.getImageId().length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MyViewHolder(View view) {
            super(view);

            imageView = (ImageView) view.findViewById(R.id.tutorial_categories_imageView);
        }
    }

}
