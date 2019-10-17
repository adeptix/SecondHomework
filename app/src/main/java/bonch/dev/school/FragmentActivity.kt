package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class FragmentActivity : AppCompatActivity() {

    private val TAP_KEY = "TAP_AMOUNT"
    private val ENABLED_KEY = "IS_ENABLED"

    private val fm = supportFragmentManager

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var attachFragmentButton: Button
    private lateinit var textField: EditText

    private var counter = Counter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        initialize()
        initializeListeners()

        val tapAmount = savedInstanceState?.getInt(TAP_KEY)?: 0
        counter = Counter(tapAmount)
        counterButton.text = counter.currentCount.toString()
        indicatorButton.isEnabled = savedInstanceState?.getBoolean(ENABLED_KEY)?: true
    }

    private fun initialize() {
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        attachFragmentButton = findViewById(R.id.attach_fragment_button)
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

        attachFragmentButton.setOnClickListener {

            val fragment = MyFragment.newInstance(!indicatorButton.isEnabled, counter.currentCount, textField.text.toString())
            createFragment(fragment)

        }

    }

    fun createFragment(fragment: Fragment){
       fm.beginTransaction()
           .replace(R.id.fragment_place, fragment)
           .commit()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(TAP_KEY, counter.currentCount)
        outState.putBoolean(ENABLED_KEY, indicatorButton.isEnabled)
    }






}
