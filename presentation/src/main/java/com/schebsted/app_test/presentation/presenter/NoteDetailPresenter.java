package com.schebsted.app_test.presentation.presenter;

import com.schebsted.app_test.domain.entity.NoteEntity;
import com.schebsted.app_test.domain.interactor.note.GetNoteUseCase;
import com.schebsted.app_test.presentation.dependency.ActivityScope;
import com.schebsted.app_test.presentation.view.BaseView;
import com.schebsted.app_test.presentation.view.NoteDetailView;

import javax.inject.Inject;

@ActivityScope
public class NoteDetailPresenter extends BasePresenter implements Presenter {

    private GetNoteUseCase getNoteUseCase;
    NoteDetailView noteDetailView;

    @Inject
    public NoteDetailPresenter(GetNoteUseCase getNoteUseCase) {
        super(getNoteUseCase);
        this.getNoteUseCase = getNoteUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.noteDetailView = (NoteDetailView) view;
    }

    @Override
    public void resume() {
        this.showLoader();
        this.getNoteUseCase.setParams(this.noteDetailView.getNoteId());
        this.getNoteUseCase.execute(new NoteDetailSubscriber());
    }

    @Override
    public void destroy() {
        super.destroy();
        this.noteDetailView = null;
    }

    protected class NoteDetailSubscriber extends BaseSubscriber<NoteEntity> {

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            NoteDetailPresenter.this.noteDetailView.close();
        }

        @Override public void onNext(NoteEntity note) {
            NoteDetailPresenter.this.hideLoader();
            NoteDetailPresenter.this.noteDetailView.showNote(note);
        }
    }

}
