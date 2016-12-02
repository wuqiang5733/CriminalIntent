package com.afterquestion.criminalintent;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by mac on 16/11/26.
 */

public class CrimeListActivity extends SingleFragmentActivity
        implements CrimeListFragment.Callbacks , CrimeFragment.Callbacks{
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
    @Override
    protected int getLayoutResId() {
//        return R.layout.activity_fragment;
//        return R.layout.activity_twopane;
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.detail_fragment_container) == null) {
//            如果是手机的话
            Intent intent = CrimePagerActivity.newIntent(this, crime.getId());
            startActivity(intent);
        } else {
//            如果是平板的话
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());
            getSupportFragmentManager().beginTransaction()
//                    把原来可能已经显示的 Crime 替换掉
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }

    }
    public void onCrimeUpdated(Crime crime) {
        CrimeListFragment listFragment = (CrimeListFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}
