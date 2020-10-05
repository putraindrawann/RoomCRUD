package com.example.roomcrud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomcrud.model.Note

class NoteAdapter(
    private val listItems: ArrayList<Note>,
    private val listener: NoteListener
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = listItems[position]
        holder.textViewTitle.text = item.title
        holder.textViewDescription.text = item.description
        holder.itemView.setOnClickListener {
            listener.OnItemClicked(item)
        }
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTitle = itemView.findViewById<TextView>(R.id.text_view_title)
        var textViewDescription = itemView.findViewById<TextView>(R.id.text_view_description)
    }

    interface NoteListener{
        fun OnItemClicked(note: Note)
    }
}
