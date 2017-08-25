/*
 * Copyright (c) 2017. Build by anibalbastias
 */

package com.schebsted.app_test.presentation.view.fragment;

import android.widget.TextView;

import com.schebsted.app_test.domain.entity.ArtistEntity;
import com.schebsted.app_test.presentation.R;
import com.schebsted.app_test.presentation.presenter.ArtistPresenter;
import com.schebsted.app_test.presentation.presenter.BasePresenter;
import com.schebsted.app_test.presentation.view.SearchArtistView;

import javax.inject.Inject;

import butterknife.Bind;

public class SearchArtistFragment extends BaseFragment implements SearchArtistView {

    @Inject
    ArtistPresenter artistPresenter;

    @Bind(R.id.list)
    TextView artist;

    @Override
    protected void callInjection() {
        this.getFragmentInjector().inject(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_artists;
    }

    @Override
    public BasePresenter presenter() {
        return this.artistPresenter;
    }

    public ArtistPresenter searchArtistPresenter() {
        return artistPresenter;
    }

    @Override
    public void viewArtists(ArtistEntity artists) {
        //((Listener) getActivity()).searchArtist(artists);
        this.searchArtistPresenter().searchArtists("epica");

        // set Adapter for list


        try {
            artist.setText("" + artists.getResults().get(0).getArtistName());
        } catch (Exception e) {

        }
    }
}
