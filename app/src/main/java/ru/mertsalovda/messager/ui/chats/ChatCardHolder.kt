package ru.mertsalovda.messager.ui.chats

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.data.model.Chat
import ru.mertsalovda.messager.data.model.ChatAndMessages

class ChatCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mName: TextView = itemView.findViewById(R.id.tvPersonaName)
    private val mMessageText: TextView = itemView.findViewById(R.id.tvLastMessage)

    fun bind(item: ChatAndMessages, listener: ChatsAdapter.OnItemClickListener) {
        mName.text = item.chat.name
        if (item.messages.isNotEmpty()) {
            mMessageText.text = item.messages.last().text
        }
        itemView.setOnClickListener { listener.onItemClick(item.chat.chatId) }
    }
}
