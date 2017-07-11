package kyawthetwin.com.shweoah.Presenter;

import kyawthetwin.com.shweoah.Interface.FreePageCategories_MVP;
import kyawthetwin.com.shweoah.Model.ImageForCategories;
import kyawthetwin.com.shweoah.R;

/**
 * Created by kyawthetwin on 7/11/17.
 */

public class Free_Presenter implements FreePageCategories_MVP.presenter {

    int[] image1 = {R.drawable.business_darkgold,R.drawable.langauge_darkgold,R.drawable.design_darkgold,R.drawable.programming_darkgold,
                    R.drawable.musicology_darkgold,R.drawable.engineer_darkgold};
    int[] image2 = {R.drawable.business_darkgold,R.drawable.langauge_darkgold,R.drawable.design_darkgold,R.drawable.programming_darkgold,
            R.drawable.musicology_darkgold,R.drawable.engineer_darkgold};

    private final FreePageCategories_MVP.view view;

    public Free_Presenter(FreePageCategories_MVP.view view){
        this.view = view;
    }

    @Override
    public void setTutorailCategories() {
        ImageForCategories ifc = new ImageForCategories(image1);
        view.setRecyclerViewCategories(ifc);
    }

    @Override
    public void setCourseCategories() {
        ImageForCategories ifc = new ImageForCategories(image2);
        view.setRecyclerViewCategories(ifc);
    }
}
