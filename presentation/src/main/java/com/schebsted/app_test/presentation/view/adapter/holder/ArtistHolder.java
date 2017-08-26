/*
 * Copyright (c) 2017. Build by anibalbastias
 */

package com.schebsted.app_test.presentation.view.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.schebsted.app_test.presentation.R;


/**
 * Created by anibalbastias on 18-08-17.
 * Clase para llamar vista XML a cada elemento de RecyclerView
 */

public class ArtistHolder extends RecyclerView.ViewHolder {
    public TextView mDate;
    public TextView mTitle;
    public TextView mNew;
    public TextView mProspect;
    public TextView mModel;
    public TextView mPrice;
    public ImageView mImage;

    /**
     * Holder de item de artists
     *
     * @param itemView View de item de artista
     */
    public ArtistHolder(View itemView) {
        super(itemView);

        mDate = itemView.findViewById(R.id.recyclerview_item_artist_date);
        mTitle = itemView.findViewById(R.id.recyclerview_item_artist_title);
        mNew = itemView.findViewById(R.id.recyclerview_item_artist_new);
        mImage = itemView.findViewById(R.id.recyclerview_item_artist_image);
        mProspect = itemView.findViewById(R.id.recyclerview_item_artist_prospect);
        mModel = itemView.findViewById(R.id.recyclerview_item_artist_model);
        mPrice = itemView.findViewById(R.id.recyclerview_item_artist_price);
    }
}
