package jay.nakum.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Do a dice roll when the app starts */
        rollDice()

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            /** Roll the dice when button is clicked */
            rollDice()
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        /** Create new Dice object with 6 sides */
        val dice = Dice(6)
        /** Roll the dice */
        val roll = dice.roll()

        /** Update the screen after the roll */
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when(roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = roll.toString()
        // val textView: TextView = findViewById(R.id.textView)
        // textView.text = roll
    }
}