package ru.mertsalovda.messager.ui.chat

import android.view.LayoutInflater
import ru.mertsalovda.messager.R
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mertsalovda.messager.App
import ru.mertsalovda.messager.data.DataBase
import ru.mertsalovda.messager.data.model.Message
import ru.mertsalovda.messager.data.model.UserLogin
import toothpick.Toothpick
import javax.inject.Inject

class ChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var messages = mutableListOf<Message>()

    @Inject
    lateinit var db: DataBase

    init {
        Toothpick.inject(this, App.appScope)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            MessageType.LEFT.ordinal -> {
                val view = inflater.inflate(R.layout.li_message_card_left, parent, false)
                MessageHolderLeft(view)
            }
            MessageType.RIGHT.ordinal -> {
                val view = inflater.inflate(R.layout.li_message_card_right, parent, false)
                MessageHolderRight(view)
            }
            else -> throw Throwable("Неверный холдер $viewType")
        }

    }

    override fun getItemViewType(position: Int): Int {
        val message = messages[position]
        val idUser = db.userLoginDao().getUserLogin().first()
        return when {
            message.senderUid == idUser.uid -> MessageType.RIGHT.ordinal
            message.senderUid != idUser.uid -> MessageType.LEFT.ordinal
            else -> -1
        }
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MessageHolderLeft -> holder.bind(messages[position])
            is MessageHolderRight -> holder.bind(messages[position])
        }
    }

    fun addData(data: List<Message>, isClean: Boolean) {
        if (isClean) {
            messages.clear()
        }
        messages.addAll(data)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick()
    }
}


enum class MessageType {
    LEFT,
    RIGHT
}
