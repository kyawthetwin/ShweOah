package kyawthetwin.com.shweoah.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kyawthetwin.com.shweoah.R;

/**
 * Created by kyawthetwin on 7/7/17.
 */

public class PackageFragment extends Fragment {


    public static PackageFragment newInstance() {
        PackageFragment fragment = new PackageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_package, container, false);

        return rootView;
    }
}