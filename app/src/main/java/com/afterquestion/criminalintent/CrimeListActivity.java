package com.afterquestion.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by mac on 16/11/26.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
