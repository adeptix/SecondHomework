package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText

class FirstActivity : AppCompatActivity() {

    private val SAVE_KEY = "TAP_AMOUNT"

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var nextActivityButton: Button
    private lateinit var textField: EditText

    private var counter = Counter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        initialize()
        initializeListeners()

        val tapAmount = savedInstanceState?.getInt(SAVE_KEY)?: 0
        counter = Counter(tapAmount)
        counterButton.text = counter.currentCount.toString()
    }

    private fun initialize() {
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        nextActivityButton = findViewById(R.id.next_activity_button)
        textField = findViewById(R.id.text_field)

    }

    private fun initializeListeners() {
        indicatorButton.setOnClickListener {
            indicatorButton.isEnabled = false
        }

        counterButton.setOnClickListener {
            counter.increment()
            counterButton.text = counter.currentCount.toString()
        }

        nextActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.IS_CLICKED_KEY, !indicatorButton.isEnabled)
            intent.putExtra(Constants.CLICK_AMOUNT_KEY, counter.currentCount)
            intent.putExtra(Constants.INPUT_TEXT_KEY, textField.text.toString())
            startActivity(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SAVE_KEY, counter.currentCount)
    }



}
