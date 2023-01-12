package com.difl.natesroommvvm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.difl.natesroommvvm.db.Note;
import com.difl.natesroommvvm.db.NoteDatabase;
import com.difl.natesroommvvm.db.NoteRepo;

import java.util.List;

public class InsertFragment extends Fragment {

    private NoteVewModel noteVewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert, container, false);

        Button add = view.findViewById(R.id.add);
        EditText edt_title = view.findViewById(R.id.edt_title);
        EditText edt_description = view.findViewById(R.id.edt_description);

        noteVewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getActivity().getApplication())).get(NoteVewModel.class);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edt_title.getText().toString();
                String desc = edt_description.getText().toString();
                if(title.equals("") && desc.equals("")){
                    Toast.makeText(getContext(), "Enter info", Toast.LENGTH_SHORT).show();
                }
                else{
                    NoteRepo repo = new NoteRepo(getActivity().getApplication());
                    repo.myAdd(title, desc, getContext());

                    Toast.makeText(getContext(), "Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}