package bonch.dev.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

const val IS_CLICKED_KEY = "IS_CLICKED"
const val CLICK_AMOUNT_KEY = "CLICK_AMOUNT"
const val INPUT_TEXT_KEY = "INPUT_TEXT"

class MyFragment : Fragment() {

    private var isClicked: Boolean? = null
    private var clickAmount: Int? = null
    private var inputText: String? = null

    private lateinit var textView : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isClicked = it.getBoolean(IS_CLICKED_KEY)
            clickAmount = it.getInt(CLICK_AMOUNT_KEY)
            inputText = it.getString(INPUT_TEXT_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)

        textView = view.findViewById(R.id.text_view)
        textView.text="Индикатор нажат : $isClicked \nКол-во кликов по второй кнопке : $clickAmount \nВведенный текст : $inputText"

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(isClicked: Boolean, clickAmount: Int, inputText: String) =
            MyFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(IS_CLICKED_KEY, isClicked)
                    putInt(CLICK_AMOUNT_KEY, clickAmount)
                    putString(INPUT_TEXT_KEY, inputText)
                }
            }
    }

}