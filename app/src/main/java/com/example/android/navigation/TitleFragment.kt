package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
                R.layout.fragment_title, container, false)

        binding.playButton.setOnClickListener {  view: View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)    //根據action的動作來作切換
        }

        // enable option menu
        setHasOptionsMenu(true)


        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    /***
     *Tip: Make sure that the ID of the menu item that you just added is
     * exactly the same as the ID of the AboutFragment
     * that you added in the navigation graph. T
     * his will make the code for the onClick handler much simpler.
     * 各個menu的id一定要對應navigation path裡面需要之fragment的id
     */

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }



}