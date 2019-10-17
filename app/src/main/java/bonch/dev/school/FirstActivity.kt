package bonch.dev.school

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    private val SECOND_ACTIVITY_REQUEST = 0
    private lateinit var secondActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        secondActivityButton = second_activity_button
        secondActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       Toast.makeText(this
           ,if(resultCode == Activity.RESULT_OK) "Ты нажал кнопку" else "Ты вышел иным путем"
           , Toast.LENGTH_SHORT).show()
    }


}
