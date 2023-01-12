package com.difl.natesroommvvm;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.difl.natesroommvvm.db.Note;
import com.difl.natesroommvvm.db.NoteDatabase;
import com.difl.natesroommvvm.db.NoteRepo;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.LikeHolder>{

    List<Note> personList;

    public NewAdapter(List<Note> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public LikeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new LikeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikeHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText(personList.get(position).getTitle());
        holder.desc.setText(personList.get(position).getDisc());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteDatabase db = Room.databaseBuilder(v.getContext(), NoteDatabase.class,
                        "person-db").allowMainThreadQueries().build();

                db.noteDao().deleteByUserId(personList.get(position).getId());
                personList.remove(position);
                notifyItemRemoved(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class LikeHolder extends RecyclerView.ViewHolder{

        TextView title, desc;
        ImageButton delete;

        public LikeHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            delete = itemView.findViewById(R.id.delete);

        }
    }
}