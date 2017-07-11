package kyawthetwin.com.shweoah.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freegeek.android.materialbanner.MaterialBanner;
import com.freegeek.android.materialbanner.holder.ViewHolderCreator;
import com.freegeek.android.materialbanner.view.indicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import kyawthetwin.com.shweoah.Adapter.TutorialCategoriesAdapter;
import kyawthetwin.com.shweoah.DepthPageTransformer;
import kyawthetwin.com.shweoah.ImageViewHolder;
import kyawthetwin.com.shweoah.Interface.FreePageCategories_MVP;
import kyawthetwin.com.shweoah.Model.BannerData;
import kyawthetwin.com.shweoah.Model.ImageForCategories;
import kyawthetwin.com.shweoah.Presenter.Free_Presenter;
import kyawthetwin.com.shweoah.R;

/**
 * Created by kyawthetwin on 7/7/17.
 */

public class FreeFragment extends Fragment implements FreePageCategories_MVP.view{

    TutorialCategoriesAdapter adapter;
    Free_Presenter presenter;
    MaterialBanner materialBanner;
    private CirclePageIndicator circlePageIndicator;
    RecyclerView categories_recyclerview;

    private String[] images = {"http://static.panoramio.com/photos/large/132796978.jpg",
            "http://static.panoramio.com/photos/large/132796977.jpg",
            "http://static.panoramio.com/photos/large/133036192.jpg",
            "http://static.panoramio.com/photos/large/132796982.jpg",
            "http://static.panoramio.com/photos/large/132796981.jpg"
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_free, container, false);
        findViewById(rootView);
        presenter = new Free_Presenter(this);



        setMaterialBanner();
        presenter.setTutorailCategories();

        return rootView;
    }

    void setMaterialBanner() {
        initIndicator();
        List<BannerData> bannerData = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            BannerData data = new BannerData();
            data.setTitle("Country road " + (i + 1));
            data.setUrl(images[i]);
            bannerData.add(data);
        }

        materialBanner.setPages(new ViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new ImageViewHolder();
            }
        }, bannerData);
        materialBanner.startTurning(3000);
        materialBanner.setIndicator(circlePageIndicator);
        materialBanner.setTransformer(new DepthPageTransformer());
        materialBanner.setMatch(!materialBanner.isMatch());
    }

    void findViewById(View v) {

        materialBanner = (MaterialBanner) v.findViewById(R.id.material_banner);
        categories_recyclerview = (RecyclerView) v.findViewById(R.id.f_m_categories);

    }



    void initIndicator() {

        circlePageIndicator = new CirclePageIndicator(getActivity());
        circlePageIndicator.setStrokeColor(Color.WHITE);
        circlePageIndicator.setFillColor(Color.WHITE);
        circlePageIndicator.setRadius(MaterialBanner.dip2Pix(getActivity(), 3));
        circlePageIndicator.setBetween(20);


    }


    @Override
    public void setRecyclerViewCategories(ImageForCategories images) {
        adapter = new TutorialCategoriesAdapter(images);
        categories_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        categories_recyclerview.setItemAnimator(new DefaultItemAnimator());
        categories_recyclerview.setAdapter(adapter);
    }
}