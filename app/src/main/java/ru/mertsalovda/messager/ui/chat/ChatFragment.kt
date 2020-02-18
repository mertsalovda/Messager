package ru.mertsalovda.messager.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fr_chat.*
import ru.mertsalovda.messager.R

class ChatFragment : Fragment() {

    private lateinit var chatViewModel: ChatViewModel
    var navController: NavController? = null

    private val adapter = ChatAdapter()
    private var chatId: Long = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        chatId = arguments?.get(CHAT_ID) as Long

        chatViewModel =
            ViewModelProviders.of(this).get(ChatViewModel::class.java)
        val root = inflater.inflate(R.layout.fr_chat, container, false)

        chatViewModel.text.observe(viewLifecycleOwner, Observer {
        })

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController = findNavController()

        adapter.addData(chatViewModel.loadMessage(chatId), true)
        recyclerMessages.layoutManager = LinearLayoutManager(activity)
        recyclerMessages.adapter = adapter


        customEndIcon.setEndIconOnClickListener {
            Toast.makeText(activity, "CUSTOM END ICON", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val CHAT_ID = "CHAT_ID"
    }
}