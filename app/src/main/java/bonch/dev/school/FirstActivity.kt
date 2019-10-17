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
    private val THIRD_ACTIVITY_REQUEST = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        second_activity_button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST)
        }

        third_activity_button.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(intent, THIRD_ACTIVITY_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
      val exitWay = if(resultCode == Activity.RESULT_OK) "Нажав кнопку" else "Не нажимая кнопки"
      val exitAct = when(requestCode) {
          SECOND_ACTIVITY_REQUEST -> "Second"
          THIRD_ACTIVITY_REQUEST -> "Third"
          else -> "Any"
      }

       Toast.makeText(this, "$exitWay ты покинул $exitAct Activity", Toast.LENGTH_SHORT).show()

    }


}
