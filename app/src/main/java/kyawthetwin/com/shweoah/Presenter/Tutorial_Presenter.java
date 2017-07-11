package kyawthetwin.com.shweoah.Presenter;

import kyawthetwin.com.shweoah.Interface.TutorialPage_MVP;

/**
 * Created by kyawthetwin on 7/10/17.
 */

public class Tutorial_Presenter implements TutorialPage_MVP.presenter{


    private final TutorialPage_MVP.view view;

    public Tutorial_Presenter(TutorialPage_MVP.view view){
        this.view = view;
    }

    @Override
    public void OnPageChange() {
        view.OnPageChangeListener();
    }


}
