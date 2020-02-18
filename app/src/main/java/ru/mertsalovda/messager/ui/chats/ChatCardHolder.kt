package ru.mertsalovda.messager.ui.chats

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.data.model.Chat

class ChatCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mName: TextView = itemView.findViewById(R.id.tvPersonaName)
    private val mMessageText: TextView = itemView.findViewById(R.id.tvLastMessage)

    fun bind(item: Chat, listener: ChatsAdapter.OnItemClickListener) {
        mName.text = item.name
        mMessageText.text = item.messages.last().text
        itemView.setOnClickListener { listener.onItemClick(item.id) }
    }
}
