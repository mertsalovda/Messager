package ru.mertsalovda.messager.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fr_users.*
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.data.model.User
import ru.mertsalovda.messager.ui.chat.ChatFragment

class UsersFragment : Fragment(), UsersAdapter.OnItemClickListener {

    private lateinit var usersViewModel: UsersViewModel
    private val adapter = UsersAdapter(this)
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        usersViewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)
        val root = inflater.inflate(R.layout.fr_users, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navController = findNavController()
        recyclerUsers.layoutManager = LinearLayoutManager(activity)
        recyclerUsers.adapter = adapter

    }

    override fun onItemClick(user: User) {
        val bundle = Bundle()
        bundle.putSerializable(ChatFragment.USER, user)
        navController?.navigate(R.id.action_nav_add_chat_to_nav_chat, bundle)
    }
}