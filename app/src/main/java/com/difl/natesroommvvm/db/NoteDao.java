package com.difl.natesroommvvm.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    public void insert(Note note);

    @Query("DELETE FROM my_notes WHERE id = :userId")
    abstract void deleteByUserId(long userId);

    @Update
    public void update(Note note);

    @Delete
    public void delete(Note note);

    @Query("select * from my_notes")
    public LiveData<List<Note>> getAll();

    @Query("SELECT * FROM my_notes")
    List<Note> getAd();

}
