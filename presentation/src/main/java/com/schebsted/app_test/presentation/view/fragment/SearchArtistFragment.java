/*
 * Copyright (c) 2017. Build by anibalbastias
 */

package com.schebsted.app_test.presentation.view.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.schebsted.app_test.domain.entity.ArtistEntity;
import com.schebsted.app_test.presentation.R;
import com.schebsted.app_test.presentation.presenter.ArtistPresenter;
import com.schebsted.app_test.presentation.presenter.BasePresenter;
import com.schebsted.app_test.presentation.view.SearchArtistView;
import com.schebsted.app_test.presentation.view.adapter.ArtistAdapter;

import javax.inject.Inject;

import butterknife.Bind;

public class SearchArtistFragment extends BaseFragment implements SearchArtistView {

    @Inject
    ArtistPresenter artistPresenter;

    @Bind(R.id.list)
    TextView artist;

    @Bind(R.id.empty_text)
    TextView empty_text;

    @Bind(R.id.container)
    LinearLayout container;

    @Bind(R.id.fragment_artists_recyclerview)
    RecyclerView mRecyclerView;

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

    @Override
    public void viewArtists(ArtistEntity artists) {
        // set Adapter for list
        if (artists.getResults().size() > 0) {
            container.setVisibility(View.VISIBLE);
            empty_text.setVisibility(View.GONE);

            artist.setText(artists.getResults().get(0).getArtistName());

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());

            ArtistAdapter adapter = new ArtistAdapter(artists.getResults(),
                    artist -> {

                    });
            mRecyclerView.setAdapter(adapter);
        } else {
            container.setVisibility(View.GONE);
            empty_text.setVisibility(View.VISIBLE);
        }
    }
}
