package com.khomeapps.asist.ui.main

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.khomeapps.asist.R
import com.khomeapps.asist.adapters.ActionAdapter
import com.khomeapps.asist.databinding.MainFragmentBinding
import com.khomeapps.asist.entity.Actions

class MainFragment : Fragment() {
    lateinit var binding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.main_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcomeTextTitle.text = getString(R.string.welcome_title)
        binding.welcomeTextHeader.text = getString(R.string.welcome_header)
        val actionList = listOf(
            Actions.TOWING,
            Actions.BREAKDOWN,
            Actions.FLATTIRE,
            Actions.JUMPSTART,
            Actions.LOCKOUT,
            Actions.OUTOFGAS
        )

        binding.actionsList.adapter = ActionAdapter(actionList)
        binding.actionsList.adapter?.notifyDataSetChanged()

        //For small screen devices demonstrate scroll
        if ((binding.actionsList?.layoutManager as GridLayoutManager).findLastCompletelyVisibleItemPosition() != binding.actionsList.adapter?.itemCount) {

            Handler().postDelayed({
                binding.actionsList?.smoothScrollBy(
                    0,
                    300,
                    AccelerateInterpolator()
                )
            }, 500)
            Handler().postDelayed({
                binding.actionsList?.smoothScrollBy(
                    0,
                    -300,
                    AccelerateInterpolator()
                )
            }, 1500)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
