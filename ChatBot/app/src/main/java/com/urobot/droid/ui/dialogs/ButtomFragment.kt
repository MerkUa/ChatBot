package com.urobot.droid.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import com.urobot.droid.R

class ButtomFragment : BottomSheetDialogFragment() {

    private lateinit var viewModel: ButtomViewModel
    private var mBottomSheetListener: ButtomFragment.BottomSheetListener? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.bottom_sheet_service, container, false)
        val button = root.findViewById<Button>(R.id.calendarButton)
        button.setOnClickListener {
            mBottomSheetListener?.onOptionClick()
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ButtomViewModel::class.java)
    }

    fun setSelectedListener(listener: ButtomFragment.BottomSheetListener) {
        this.mBottomSheetListener = listener
    }

    interface BottomSheetListener {
        fun onOptionClick()
    }

}

