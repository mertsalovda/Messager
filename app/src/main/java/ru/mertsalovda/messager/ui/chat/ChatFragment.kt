package ru.mertsalovda.messager.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fr_chat.*
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.data.model.User
import ru.mertsalovda.messager.ui.MainActivity
import java.lang.Exception

class ChatFragment : Fragment() {

    private lateinit var chatViewModel: ChatViewModel
    var navController: NavController? = null

    private val adapter = ChatAdapter()
    private var chatId: Long = 0
    private var user: User? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        chatViewModel = ViewModelProvider(this).get(ChatViewModel::class.java)
        val root = inflater.inflate(R.layout.fr_chat, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        try {
            chatId = arguments?.get(CHAT_ID) as Long
        } catch (e: Exception) {
            Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT).show()
        }

        recyclerMessages.layoutManager = LinearLayoutManager(activity)
        recyclerMessages.adapter = adapter

        chatViewModel.load(chatId)

        chatViewModel.chatName.observe(viewLifecycleOwner, Observer {
            (requireActivity() as MainActivity).toolbar.title = it
        })

        chatViewModel.messages.observe(viewLifecycleOwner, Observer {
            adapter.addData(it, true)
        })

        customEndIcon.setEndIconOnClickListener {
            Toast.makeText(activity, "CUSTOM END ICON", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val CHAT_ID = "CHAT_ID"
    }
}