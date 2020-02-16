package ru.mertsalovda.messager.ui.chats

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.data.model.Chat

class ChatCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mName: TextView = itemView.findViewById(R.id.tvPersonaName)
    private val mMessageText: TextView = itemView.findViewById(R.id.tvLastMessage)

    fun bind(item: Chat) {
        val name = if (item.name.length > 20) {
            item.name.substring(1..20) + "..."
        } else {
            item.name
        }

        val textMessage = if (item.messages.last().text.length > 20) {
            item.messages.last().text.substring(1..20) + "..."
        } else {
            item.messages.last().text
        }
        mName.text = name
        mMessageText.text = textMessage
    }
}
