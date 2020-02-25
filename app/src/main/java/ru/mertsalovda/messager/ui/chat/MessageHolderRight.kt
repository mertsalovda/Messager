package ru.mertsalovda.messager.ui.chat

import android.text.format.DateFormat
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.data.model.Message
import java.util.*

class MessageHolderRight(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvRightName = itemView.findViewById<TextView>(R.id.tvRightName)
    private val tvRightDate = itemView.findViewById<TextView>(R.id.tvRightDate)
    private val tvRightMessage = itemView.findViewById<TextView>(R.id.tvRightMessage)

    fun bind(item: Message) {
        tvRightName.text = item.senderName
        tvRightDate.text = DateFormat.getDateFormat(itemView.context).format(Date(item.date))
        tvRightMessage.text = item.text
    }
}
