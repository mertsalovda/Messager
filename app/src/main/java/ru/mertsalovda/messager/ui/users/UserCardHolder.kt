package ru.mertsalovda.messager.ui.users

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.data.model.User

class UserCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mName: TextView = itemView.findViewById(R.id.tvUserName)
    private val mDescription: TextView = itemView.findViewById(R.id.tvUserDescription)

    fun bind(item: User, listener: UsersAdapter.OnItemClickListener) {
        mName.text = item.name
        mDescription.text = item.about
        itemView.setOnClickListener { listener.onItemClick(item) }
    }
}
