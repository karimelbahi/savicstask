package com.karim.savicstask.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.karim.savicstask.R


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var counter: Int = 0
        var maxNum: Int = 0
        var radioString: String = ""
        var userName: String = ""
        var strList: StringBuilder = StringBuilder()
        val sharedPreference =
            requireActivity().getSharedPreferences("SavicsTask", Context.MODE_PRIVATE)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val radioGroup: RadioGroup = root.findViewById(R.id.radio)
        val name: EditText = root.findViewById(R.id.edit_current_user_name)
        val age: EditText = root.findViewById(R.id.edit_age)
        val email: EditText = root.findViewById(R.id.edit_email)
        val txtPatient: TextView = root.findViewById(R.id.txt_patient)
        val fab: FloatingActionButton = root.findViewById(R.id.fab)


        maxNum = sharedPreference.getInt("numOfPatient", 5)
        userName = sharedPreference.getString("username", "").toString()

        if (userName.isNotEmpty()) {
            Toast.makeText(requireActivity(), "Hi again, $userName", Toast.LENGTH_SHORT).show();
        }
        fab.setOnClickListener { view ->
            if (counter < maxNum) {
                counter++
                var strName: String = name.text.toString()
                var strAge: String = age.text.toString()
                var strEmail: String = email.text.toString()
                strList.appendln("$counter patient(fullName=' $strName', gender=' $radioString', age= $strAge")
                txtPatient.text = strList
            } else {
                Toast.makeText(
                    requireActivity(),
                    "Max of patients per session reached",
                    Toast.LENGTH_SHORT
                ).show();

            }

        }


        radioGroup.clearCheck()
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val rb = group.findViewById<View>(checkedId) as RadioButton
            if (checkedId > -1) {
                radioString = rb.text as String
            }
        })
        return root
    }
}