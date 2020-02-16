package ru.mertsalovda.messager.ui.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fr_chats.*
import ru.mertsalovda.messager.R

class ChatsFragment : Fragment() {

    private lateinit var chatsViewModel: ChatsViewModel
    private val adapter = ChatsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        chatsViewModel =
            ViewModelProviders.of(this).get(ChatsViewModel::class.java)
        val root = inflater.inflate(R.layout.fr_chats, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        adapter.filTestData()
        recyclerChats.layoutManager = layoutManager
        recyclerChats.adapter = adapter
    }
}