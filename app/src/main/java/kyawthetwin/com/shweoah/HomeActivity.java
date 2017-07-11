package kyawthetwin.com.shweoah;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import kyawthetwin.com.shweoah.Fragment.CourseFragment;
import kyawthetwin.com.shweoah.Fragment.TutorialFragment;


public class HomeActivity extends AppCompatActivity {
    Fragment selectedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        final AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation1);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.course, R.drawable.courseicon, R.color.colorPrimary);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tutorial, R.drawable.tutorialicon, R.color.colorPrimary);
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#d4af37"));
        bottomNavigation.setAccentColor(Color.parseColor("#FFFFFF"));
        bottomNavigation.setInactiveColor(Color.parseColor("#a48623"));

        bottomNavigation.setForceTint(true);

        bottomNavigation.setTranslucentNavigationEnabled(true);

        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);
        bottomNavigation.setColored(true);
        bottomNavigation.setCurrentItem(0);


        selectedFragment = CourseFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, selectedFragment);
        transaction.commit();


        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                if (position == 1 ){
                    selectedFragment = TutorialFragment.newInstance();

                }else
                {
                    selectedFragment = CourseFragment.newInstance();
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });





    }

}
