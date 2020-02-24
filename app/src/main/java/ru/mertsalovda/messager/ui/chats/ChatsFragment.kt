package ru.mertsalovda.messager.ui.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fr_chats.*
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.ui.chat.ChatFragment

class ChatsFragment : Fragment(), ChatsAdapter.OnItemClickListener {

    private lateinit var chatsViewModel: ChatsViewModel
    private val adapter = ChatsAdapter(this)
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        chatsViewModel =
            ViewModelProvider(this).get(ChatsViewModel::class.java)
        val root = inflater.inflate(R.layout.fr_chats, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)
        navController = findNavController()
        recyclerChats.layoutManager = layoutManager
        recyclerChats.adapter = adapter

        chatsViewModel.load()
        chatsViewModel.chats.observe(viewLifecycleOwner, Observer {
            adapter.addData(it, true)
        })
    }

    override fun onItemClick(chatId: Long) {
        val bundle = Bundle()
        bundle.putLong(ChatFragment.CHAT_ID, chatId)
        navController?.navigate(R.id.action_nav_all_chats_to_nav_chat, bundle)
    }
}