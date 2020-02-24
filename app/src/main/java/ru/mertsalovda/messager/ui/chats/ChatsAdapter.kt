package ru.mertsalovda.messager.ui.chats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.data.model.Chat
import ru.mertsalovda.messager.data.model.Message

class ChatsAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<ChatCardHolder>() {

    private val chats = mutableListOf<Chat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatCardHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.li_chat_card, parent, false)
        return ChatCardHolder(view)
    }

    override fun getItemCount(): Int = chats.size

    override fun onBindViewHolder(holder: ChatCardHolder, position: Int) {
        holder.bind(chats[position], listener)
    }

    fun filTestData() {
        if (chats.isNotEmpty()) return

        notifyDataSetChanged()
    }

    fun addData(data: List<Chat>, clear: Boolean){
        if (clear){
            chats.clear()
        }

        chats.addAll(data)
        notifyDataSetChanged()
    }

    interface OnItemClickListener{
        fun onItemClick(chatId: Long)
    }
}