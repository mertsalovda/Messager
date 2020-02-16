package ru.mertsalovda.messager.ui.profile

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fr_profile.*
import ru.mertsalovda.messager.R
import ru.mertsalovda.messager.ui.AuthenticationState
import ru.mertsalovda.messager.ui.MainViewModel

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProviders.of(this).get(ProfileViewModel::class.java)

        val root = inflater.inflate(R.layout.fr_profile, container, false)

        profileViewModel.load()

        profileViewModel.logginInUser.observe(viewLifecycleOwner, Observer {
            tvUID.text = it.uid
            tvNameUser.text = it.displayName
            tvAboutSelf.text = it.about
        })

        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.profile_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.editProfile -> {
            }
            R.id.logout -> {
                profileViewModel.logout()
                MainViewModel.setAuthState(AuthenticationState.UNAUTHORIZED)
            }
            else -> return false
        }
        return super.onOptionsItemSelected(item)
    }
}