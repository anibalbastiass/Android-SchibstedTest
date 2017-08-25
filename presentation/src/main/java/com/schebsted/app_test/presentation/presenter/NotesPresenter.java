package com.schebsted.app_test.presentation.presenter;

import com.schebsted.app_test.domain.entity.NoteEntity;
import com.schebsted.app_test.domain.entity.VersionEntity;
import com.schebsted.app_test.domain.interactor.CheckVersionExpirationUseCase;
import com.schebsted.app_test.domain.interactor.note.GetNotesUseCase;
import com.schebsted.app_test.presentation.dependency.ActivityScope;
import com.schebsted.app_test.presentation.view.BaseView;
import com.schebsted.app_test.presentation.view.NotesView;

import java.util.List;

import javax.inject.Inject;

@ActivityScope
public class NotesPresenter extends BasePresenter implements Presenter {

    private GetNotesUseCase getNotesUseCase;
    private CheckVersionExpirationUseCase checkVersionExpirationUseCase;
    NotesView notesView;

    @Inject
    public NotesPresenter(GetNotesUseCase getNotesUseCase,
                          CheckVersionExpirationUseCase checkVersionExpirationUseCase) {
        super(getNotesUseCase, checkVersionExpirationUseCase);
        this.getNotesUseCase = getNotesUseCase;
        this.checkVersionExpirationUseCase = checkVersionExpirationUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.notesView = (NotesView) view;
        this.checkVersionExpirationUseCase.execute(new VersionExpirationSubscriber());
    }

    @Override
    public void resume() {
        this.showLoader();
        this.getNotesUseCase.execute(new NotesSubscriber());
    }

    @Override
    public void destroy() {
        super.destroy();
        this.notesView = null;
    }

    protected class NotesSubscriber extends BaseSubscriber<List<NoteEntity>> {

        @Override public void onNext(List<NoteEntity> notes) {
            NotesPresenter.this.hideLoader();
            NotesPresenter.this.notesView.showNotes(notes);
        }
    }

    protected class VersionExpirationSubscriber extends BaseSubscriber<VersionEntity> {

        @Override public void onNext(VersionEntity version) {
            NotesPresenter.this.hideLoader();
            if (version.isWarned()) NotesPresenter.this.notesView.showExpirationWarning();
        }
    }

}
