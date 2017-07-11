package kyawthetwin.com.shweoah.Interface;

import kyawthetwin.com.shweoah.Model.ImageForCategories;

/**
 * Created by kyawthetwin on 7/11/17.
 */

public interface FreePageCategories_MVP {

    interface view{

        void setRecyclerViewCategories(ImageForCategories images);
    }

    interface presenter{

        void setTutorailCategories();

        void setCourseCategories();
    }
}
