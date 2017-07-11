package kyawthetwin.com.shweoah.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kyawthetwin.com.shweoah.Adapter.PagerAdapter;
import kyawthetwin.com.shweoah.Interface.TutorialPage_MVP;
import kyawthetwin.com.shweoah.Presenter.Tutorial_Presenter;
import kyawthetwin.com.shweoah.R;

/**
 * Created by kyawthetwin on 7/7/17.
 */

public class TutorialFragment extends Fragment implements TutorialPage_MVP.view {

    ViewPager viewPager;
    Tutorial_Presenter presenter;
    Context context;
    TabLayout tabLayout;
    PagerAdapter adapter;

    public static TutorialFragment newInstance() {
        TutorialFragment fragment = new TutorialFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_tutorial, container, false);
        context = getActivity();
        presenter = new Tutorial_Presenter(this);
        findViewById(v);

        tabLayout.addTab(tabLayout.newTab().setText("Free"));
        tabLayout.addTab(tabLayout.newTab().setText("Paid"));
        tabLayout.addTab(tabLayout.newTab().setText("Package"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        adapter = new PagerAdapter
                (getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        presenter.OnPageChange();
        return v;
    }


    @Override
    public void OnPageChangeListener() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    void findViewById(View v) {
        viewPager = (ViewPager) v.findViewById(R.id.pager);
        tabLayout = (TabLayout) v.findViewById(R.id.tab_layout);

    }
}
