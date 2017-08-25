/*
 * Copyright (c) 2017. Build by anibalbastias
 */

package com.schebsted.app_test.domain.interactor.artist;

import com.schebsted.app_test.domain.entity.ArtistEntity;
import com.schebsted.app_test.domain.executor.PostExecutionThread;
import com.schebsted.app_test.domain.executor.ThreadExecutor;
import com.schebsted.app_test.domain.interactor.UseCase;
import com.schebsted.app_test.domain.repository.ArtistRepository;
import com.schebsted.app_test.domain.repository.SessionRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class SearchArtistUseCase extends UseCase<ArtistEntity> {

    private ArtistRepository artistsRepository;
    private SessionRepository sessionRepository;

    private String artist_name;

    @Inject
    public SearchArtistUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                               ArtistRepository artistsRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.artistsRepository = artistsRepository;
        this.sessionRepository = sessionRepository;
    }

    public void setParams(String artist_name) {
        this.artist_name = artist_name;
    }

    @Override
    protected Observable<ArtistEntity> buildUseCaseObservable() {
        return this.artistsRepository.searchArtist(this.artist_name)
                .doOnNext(new Consumer<ArtistEntity>() {
                    @Override
                    public void accept(ArtistEntity artistsEntity) throws Exception {
                        sessionRepository.setCurrentArtists(artistsEntity);
                    }
                });
    }
}
