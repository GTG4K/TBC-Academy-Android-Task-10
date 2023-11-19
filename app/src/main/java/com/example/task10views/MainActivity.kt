package com.example.task10views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task10views.adapters.UserOptionsAdapter
import com.example.task10views.data.OptionViewTypes
import com.example.task10views.data.UserOptions
import com.example.task10views.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: UserOptionsAdapter
    val dataset = mutableListOf<UserOptions>().apply {
        add(UserOptions(R.drawable.ic_user_solid, "Edit Profile", null, OptionViewTypes.NORMAL));
        add(UserOptions(R.drawable.ic_location_dot_solid, "Address", null, OptionViewTypes.NORMAL));
        add(UserOptions(R.drawable.ic_bell_solid, "Notification", null, OptionViewTypes.NORMAL));
        add(UserOptions(R.drawable.ic_wallet_solid, "Payment", null, OptionViewTypes.NORMAL));
        add(UserOptions(R.drawable.ic_shield_solid, "Security", null, OptionViewTypes.NORMAL));
        add(
            UserOptions(
                R.drawable.ic_language_solid, "Language", "English(US)", OptionViewTypes.SELECTOR
            )
        );
        add(UserOptions(R.drawable.ic_eye_solid, "Dark Mode", null, OptionViewTypes.TOGGLE));
        add(UserOptions(R.drawable.ic_lock_solid, "Privacy Policy", null, OptionViewTypes.NORMAL));
        add(
            UserOptions(
                R.drawable.ic_circle_info_solid, "Help Center", null, OptionViewTypes.NORMAL
            )
        );
        add(UserOptions(R.drawable.ic_users_solid, "Invite Friends", null, OptionViewTypes.NORMAL));
        add(UserOptions(R.drawable.ic_logout_solid, "Logout", null, OptionViewTypes.LOGOUT));
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AdapterSetup()
    }

    fun AdapterSetup() {
        adapter = UserOptionsAdapter(dataset)
        binding.rvUserOptions.adapter = adapter;
    }
}