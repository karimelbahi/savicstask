package com.karim.savicstask.ui.setting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.karim.savicstask.R

class SettingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_setting, container, false)

        val myName: EditText = root.findViewById(R.id.edit_user_name)
        val currentNum: EditText = root.findViewById(R.id.edit_current_number)
        val maxNum: EditText = root.findViewById(R.id.edit_max_number)
        val saveBtn: Button = root.findViewById(R.id.btn_save)

        currentNum.isEnabled = false;

        var strMAxNum: String = maxNum.text.toString()

        val sharedPreference =
            requireActivity().getSharedPreferences("SavicsTask", Context.MODE_PRIVATE)

        saveBtn.setOnClickListener {
            var editor = sharedPreference.edit()
            editor.putString("username", myName.text.toString())
            editor.putInt("currentNum", 0)
            editor.putInt("numOfPatient", strMAxNum.toInt())
            editor.apply()

            Toast.makeText(
                requireActivity(),
                "Max: $strMAxNum Username:" + myName.text.toString(),
                Toast.LENGTH_SHORT
            ).show();

        }

        return root
    }

}