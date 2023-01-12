package com.difl.natesroommvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.difl.natesroommvvm.db.Note;
import com.difl.natesroommvvm.db.NoteRepo;

import java.util.List;

public class NoteVewModel extends AndroidViewModel {

    private final NoteRepo noteRepo;
    private final LiveData<List<Note>> notelist;

    public NoteVewModel(@NonNull Application application) {
        super(application);
        noteRepo = new NoteRepo(application);
        notelist = noteRepo.getAll();
    }

    public void insert(Note note){
        noteRepo.insertData(note);
    }

    public void delete(Note note){
        noteRepo.deleteData(note);
    }

    public void update(Note note){
        noteRepo.updateData(note);
    }

    public LiveData<List<Note>> getNotelist(){
        return notelist;
    }

}
