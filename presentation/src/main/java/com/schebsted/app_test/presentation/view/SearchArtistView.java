/*
 * Copyright (c) 2017. Build by anibalbastias
 */

package com.schebsted.app_test.presentation.view;

import com.schebsted.app_test.domain.entity.ArtistEntity;

public interface SearchArtistView extends BaseView {

    void viewArtists(ArtistEntity artists);

}
