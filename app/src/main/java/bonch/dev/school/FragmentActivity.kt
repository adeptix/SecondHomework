package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class FragmentActivity : AppCompatActivity() {

    private val fm = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm.beginTransaction()
            .add(R.id.fragment1, FirstFragment())
            .commit()

    }

    fun replaceFragment(){
        fm.beginTransaction()
            .replace(R.id.fragment1, SecondFragment())
            .addToBackStack("second_fragment")
            .commit()
    }
}
