package ru.mertsalovda.messager.ui.chats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.data.model.Chat
import ru.mertsalovda.messager.data.model.Message
import java.util.*

class ChatsAdapter : RecyclerView.Adapter<ChatCardHolder>() {

    private val chats = mutableListOf<Chat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatCardHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.li_chat_card, parent, false)
        return ChatCardHolder(view)
    }

    override fun getItemCount(): Int = chats.size

    override fun onBindViewHolder(holder: ChatCardHolder, position: Int) {
        holder.bind(chats[position])
    }

    fun filTestData() {

        val message1 = Message(132456, 1, 2, "Hello")
        val message2 = Message(3243543, 1, 2, "Hello")
        val message3 = Message(547787, 1, 2, "WorldWorldWorldWorldWorldWorldWorldWorldWorldWorldWorld")

        chats.add(Chat(123L, "Vasikli", mutableListOf(message1, message2, message3)))
        chats.add(Chat(6354L, "Ivan", mutableListOf(message1, message2, message3)))
        chats.add(Chat(5747L, "Natasha", mutableListOf(message1, message2, message3)))
        chats.add(Chat(879L, "Alex", mutableListOf(message1, message2, message3)))
        chats.add(Chat(134L, "Nina", mutableListOf(message1, message2, message3)))
        notifyDataSetChanged()
    }

    fun addData(data: List<Chat>, clear: Boolean){
        if (clear){
            chats.clear()
        }

        chats.addAll(data)
        notifyDataSetChanged()
    }
}