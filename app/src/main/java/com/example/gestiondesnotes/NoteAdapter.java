package com.example.gestiondesnotes;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class NoteAdapter extends BaseAdapter{

    private List<Note> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public NoteAdapter(Context aContext,  List<Note> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    static class ViewHolder {

        TextView moduleView;
        TextView NoteView;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();

            holder.moduleView = (TextView) convertView.findViewById(R.id.moduleView);
            holder.NoteView = (TextView) convertView.findViewById(R.id.NoteView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Note note = this.listData.get(position);
        holder.moduleView.setText(note.getModule());
        holder.NoteView.setText("Note " + note.getNote());



        return convertView;


    }
}
