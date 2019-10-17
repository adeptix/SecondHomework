package bonch.dev.school


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    private lateinit var  finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        finishButton = finish_button
        finishButton.setOnClickListener {
           setResult(Activity.RESULT_OK)
           finish()
        }
    }
}
