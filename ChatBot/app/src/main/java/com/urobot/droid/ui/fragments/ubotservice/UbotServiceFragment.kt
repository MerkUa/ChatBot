package com.urobot.droid.ui.fragments.ubotservice

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.urobot.droid.R
import com.urobot.droid.ui.dialogs.ButtomFragment
import kotlinx.android.synthetic.main.bottom_sheet_service.*
import kotlinx.android.synthetic.main.ubot_service_fragment.*


class UbotServiceFragment : Fragment(), ButtomFragment.BottomSheetListener {

    private lateinit var viewModel: UbotViewModel

    private val dialog = ButtomFragment()


    private lateinit var sheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.ubot_service_fragment, container, false)
        val createServiceButton: Button = root.findViewById(R.id.createService)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UbotViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBottomSheet()
        createService.setOnClickListener {
            //            val view = layoutInflater.inflate(R.layout.fragment_ubot, null)
            dialog.setSelectedListener(this)
            dialog.show(activity!!.supportFragmentManager, "BottomSheet")

        }

    }

    private fun setBottomSheet() {
        sheetBehavior = BottomSheetBehavior.from(bottomSheet)
        sheetBehavior.isFitToContents = true
        sheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN


        sheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // empty
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                Timber.d("onSlide $slideOffset")
//                if (slideOffset <= 0.3 && flag) {
//                    flag = false
//                }
            }
        })
    }

    override fun onOptionClick() {
        Log.d("onOptionClick", "onOptionClick")
        dialog.dismiss()
        findNavController().navigate(R.id.navigation_create_calendar)
        sheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
    }
}


