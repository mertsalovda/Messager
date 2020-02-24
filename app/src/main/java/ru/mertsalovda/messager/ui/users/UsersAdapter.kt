package ru.mertsalovda.messager.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.data.model.User

class UsersAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<UserCardHolder>() {

    private val users = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserCardHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.li_user_card, parent, false)
        return UserCardHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserCardHolder, position: Int) {
        holder.bind(users[position], listener)
    }

    fun filTestData() {
        if (users.isNotEmpty()) return

        notifyDataSetChanged()
    }

    fun addData(data: List<User>, clear: Boolean){
        if (clear){
            users.clear()
        }

        users.addAll(data)
        notifyDataSetChanged()
    }

    interface OnItemClickListener{
        fun onItemClick(user: User)
    }
}