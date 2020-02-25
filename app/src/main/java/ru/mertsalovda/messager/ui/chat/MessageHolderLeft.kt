package ru.mertsalovda.messager.ui.chat

import android.text.format.DateFormat
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.data.model.Message
import java.util.*

class MessageHolderLeft(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvLeftName = itemView.findViewById<TextView>(R.id.tvLeftName)
    private val tvLeftDate = itemView.findViewById<TextView>(R.id.tvLeftDate)
    private val tvLeftMessage = itemView.findViewById<TextView>(R.id.tvLeftMessage)

    fun bind(item: Message) {
        tvLeftName.text = item.senderName
        tvLeftDate.text = DateFormat.getDateFormat(itemView.context).format(Date(item.date))
        tvLeftMessage.text = item.text
    }
}
