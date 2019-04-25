package com.example.databinding

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var onSubmitAction: View.OnClickListener

    private lateinit var user: User
    private lateinit var userName: String
    private lateinit var userSurname: String
    private lateinit var userAnother: String
    var userAge: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        user = User("https://avatanplus.com/files/effects/mid/5939ac7362ab215c8949a2cc.jpg","Andrew", "Sukhovolskij", 21)
        binding.setUser(user)
//        binding.setVariable(BR.user, user)
//        binding.executePendingBindings()
//        initListeners()
//        bindListeners()
    }

    private fun initListeners() {
        onSubmitAction = View.OnClickListener {
            userName = etMainName.text.toString()
            userSurname = etMainSurname.text.toString()
            userAge = etMainAge.text.toString().toInt()
            userAnother = etMainAnother.text.toString()

            if (isAllViewWithContent(userName, userSurname)) {
                user.name = userName
                user.surname = userSurname
                user.age = userAge
                user.another = userAnother
                makeToast(
                    """onSubmitAction:
                    |User Name = ${user.name}
                    |User Surname = ${user.surname}
                    |User Age = ${user.age}
                    |User Another = ${user.another}
                """.trimMargin()
                )
            } else {
                makeToast("onSubmitAction: Error(Too short Name or Surname)")
            }
        }
    }

    private fun bindListeners() {
        btnMainSubmit.setOnClickListener(onSubmitAction)
    }

    private fun isValid(str: String): Boolean {
        return str.length > 2
    }

    private fun isAllViewWithContent(str1: String, str2: String): Boolean {
        return isValid(str1) && isValid(str2)
    }

    private fun makeToast(msg: String) {
        Toast.makeText(this, "click " + msg, Toast.LENGTH_LONG).show()
    }
}
