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

        users.add(User(15, "Grisha", "Рад поболтать!"))
        users.add(User(11, "Alex", "I am use messager"))
        users.add(User(16, "Petr", "Болтать!"))
        users.add(User(34, "Sasha", "Писать только по делу"))
        users.add(User(88, "Masha", "Смотри дальше"))
        users.add(User(85, "Ivan", "И на меня не смотри"))
        users.add(User(12, "Sergey", "А на меня смотри"))

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