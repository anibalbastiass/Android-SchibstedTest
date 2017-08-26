/*
 * Copyright (c) 2017. Build by anibalbastias
 */

package com.schebsted.app_test.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.schebsted.app_test.domain.entity.ArtistResultEntity;
import com.schebsted.app_test.presentation.R;
import com.schebsted.app_test.presentation.view.adapter.holder.ArtistHolder;
import com.schebsted.app_test.presentation.view.util.GeneralUtils;

import java.util.ArrayList;

/**
 * Created by anibalbastias on 18-08-17.
 * Clase adaptadora para elemento de RecyclerView
 */

public class ArtistAdapter extends RecyclerView.Adapter<ArtistHolder> {
    private final ArrayList<ArtistResultEntity> mArtists;
    private final AdapterCallback mCallback;

    public ArtistAdapter(ArrayList<ArtistResultEntity> artists, AdapterCallback callback) {
        mArtists = artists;
        mCallback = callback;
    }

    @Override
    public ArtistHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_cell_artist, parent, false);
        return new ArtistHolder(v);
    }

    /**
     * Bind del holder de posts
     *
     * @param holder   objeto de holder
     * @param position posicion del mItem
     */
    @Override
    public void onBindViewHolder(final ArtistHolder holder, int position) {
        holder.mTitle.setText(mArtists.get(position).getArtistName());
        holder.mDate.setText(mArtists.get(position).getCollectionName());
        holder.mModel.setText("USD$" + mArtists.get(position).getTrackPrice());
        holder.mNew.setText(GeneralUtils.getFormatMoney((int) mArtists.get(position).getCollectionPrice()));
        holder.mPrice.setText(mArtists.get(position).getCountry());
        holder.mProspect.setText(mArtists.get(position).getPrimaryGenreName());

        // Image with glide lib
        GeneralUtils.loadImageUrl(holder.mTitle.getContext(),
                mArtists.get(position).getArtworkUrl100(), holder.mImage);

        holder.mTitle.setOnClickListener(view -> mCallback.onItemClickListener(mArtists.get(position)));
    }

    /**
     * Cuenta total de items
     *
     * @return Total items
     */
    @Override
    public int getItemCount() {
        return mArtists.size();
    }

    public interface AdapterCallback {
        void onItemClickListener(ArtistResultEntity artist);
    }
}
