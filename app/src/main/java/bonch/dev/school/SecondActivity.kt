package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.text_view)

        val isClicked = intent.getBooleanExtra(Constants.IS_CLICKED_KEY, false)
        val clickAmount = intent.getIntExtra(Constants.CLICK_AMOUNT_KEY, 0)
        val inputText = intent.getStringExtra(Constants.INPUT_TEXT_KEY)

        textView.text="Индикатор нажат : $isClicked \nКол-во кликов по второй кнопке : $clickAmount \nВведенный текст : $inputText"
    }


}
