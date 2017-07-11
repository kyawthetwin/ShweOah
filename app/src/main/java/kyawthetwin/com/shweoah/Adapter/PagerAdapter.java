package kyawthetwin.com.shweoah.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import kyawthetwin.com.shweoah.Fragment.FreeFragment;
import kyawthetwin.com.shweoah.Fragment.PackageFragment;
import kyawthetwin.com.shweoah.Fragment.PaidFragment;

/**
 * Created by kyawthetwin on 7/10/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FreeFragment tab1 = new FreeFragment();
                return tab1;
            case 1:
                PaidFragment tab2 = new PaidFragment();
                return tab2;
            case 2:
                PackageFragment tab3 = new PackageFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}