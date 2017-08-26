/*
 * Copyright (c) 2017. Build by anibalbastias
 */

package com.schebsted.app_test.presentation.presenter;

import com.schebsted.app_test.domain.entity.ArtistEntity;
import com.schebsted.app_test.domain.interactor.artist.SearchArtistUseCase;
import com.schebsted.app_test.presentation.dependency.ActivityScope;
import com.schebsted.app_test.presentation.view.BaseView;
import com.schebsted.app_test.presentation.view.SearchArtistView;

import javax.inject.Inject;

@ActivityScope
public class ArtistPresenter extends BasePresenter implements Presenter {

    private SearchArtistUseCase searchArtistUseCase;
    SearchArtistView searchArtistView;

    @Inject
    public ArtistPresenter(SearchArtistUseCase searchArtistUseCase) {
        super(searchArtistUseCase);
        this.searchArtistUseCase = searchArtistUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.searchArtistView = (SearchArtistView) view;
        this.searchArtistUseCase.execute(new ArtistPresenter.ArtistSubscriber());
    }

    @Override
    public void resume() {
        //this.showLoader();
        searchArtists("sonata arctica");
    }

    @Override
    public void destroy() {
        super.destroy();
        this.searchArtistView = null;
    }

    public void searchArtists(String artist_name) {
        this.showLoader();
        this.searchArtistUseCase.setParams(artist_name);
        this.searchArtistUseCase.execute(new ArtistSubscriber());
    }

    protected class ArtistSubscriber extends BaseSubscriber<ArtistEntity> {
        @Override
        public void onNext(ArtistEntity artist) {
            ArtistPresenter.this.hideLoader();
            ArtistPresenter.this.searchArtistView.viewArtists(artist);
        }
    }
}
