package kyawthetwin.com.shweoah.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kyawthetwin.com.shweoah.Adapter.CourseCategoriesAdapter;
import kyawthetwin.com.shweoah.Interface.FreePageCategories_MVP;
import kyawthetwin.com.shweoah.Model.ImageForCategories;
import kyawthetwin.com.shweoah.Presenter.Free_Presenter;
import kyawthetwin.com.shweoah.R;

/**
 * Created by kyawthetwin on 7/7/17.
 */

public class CourseFragment extends Fragment implements FreePageCategories_MVP.view {

    Free_Presenter presenter;
    CourseCategoriesAdapter adapter;
    RecyclerView course_categories_recyclerView;

    public static CourseFragment newInstance() {
        CourseFragment fragment = new CourseFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_course, container, false);
        findViewById(v);
        presenter = new Free_Presenter(this);
        presenter.setCourseCategories();



        return v;
    }

    void findViewById(View v){

        course_categories_recyclerView = (RecyclerView) v.findViewById(R.id.course_categories);
    }

    @Override
    public void setRecyclerViewCategories(ImageForCategories images) {

        adapter = new CourseCategoriesAdapter(images);
        course_categories_recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        course_categories_recyclerView.setItemAnimator(new DefaultItemAnimator());
        course_categories_recyclerView.setAdapter(adapter);
    }
}
