package com.schebsted.app_test.presentation.presenter;

import com.schebsted.app_test.domain.entity.NoteEntity;
import com.schebsted.app_test.domain.interactor.note.CreateNoteUseCase;
import com.schebsted.app_test.presentation.dependency.ActivityScope;
import com.schebsted.app_test.presentation.view.BaseView;
import com.schebsted.app_test.presentation.view.NoteCreateView;

import javax.inject.Inject;

@ActivityScope
public class NoteCreatePresenter extends BasePresenter implements Presenter {

    private CreateNoteUseCase createNoteUseCase;
    NoteCreateView noteCreateView;

    @Inject
    public NoteCreatePresenter(CreateNoteUseCase createNoteUseCase) {
        super(createNoteUseCase);
        this.createNoteUseCase = createNoteUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.noteCreateView = (NoteCreateView) view;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.noteCreateView = null;
    }

    public void createButtonPressed(String title, String content) {
        NoteEntity note = new NoteEntity(title, content);

        this.noteCreateView.showLoader();
        this.createNoteUseCase.setParams(note);
        this.createNoteUseCase.execute(new NoteCreateSubscriber());
    }

    protected class NoteCreateSubscriber extends BaseSubscriber<NoteEntity> {

        @Override public void onNext(NoteEntity note) {
            NoteCreatePresenter.this.hideLoader();
            NoteCreatePresenter.this.noteCreateView.close();
        }
    }

}
