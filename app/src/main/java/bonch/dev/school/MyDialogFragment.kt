package bonch.dev.school

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val builder = AlertDialog.Builder(activity!!)
        builder.setMessage("Сделай сложный выбор")
        builder.setPositiveButton("OK") { dialog, which ->
            Toast.makeText(activity, "Выбор пал на OK", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("CANCEL") { dialog, which ->
            Toast.makeText(activity, "Выбор пал на CANCEL", Toast.LENGTH_SHORT).show()
        }


        return builder.create()
    }
}