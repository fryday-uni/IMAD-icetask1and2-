package com.example.icetask1
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

enum class Time {
    MORNING,
    MID_MORNING,
    AFTERNOON,
    AFTERNOON_SNACK_TIME,
    EVENING,
    NIGHT,
}
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declaring the variables and connecting them to respective buttons
        val currentTime = findViewById<EditText>(R.id.timeEditText)
        val suggestionResult = findViewById<TextView>(R.id.resultViewText)
        val printTextView = findViewById<Button>(R.id.printButton)
        val clearButton = findViewById<Button>(R.id.clearbutton)


        printTextView.setOnClickListener {
            // user input of time set to uppercase to make it not case sensitive
            val timeInput = currentTime.text.toString().uppercase()

            // changing this stupid string into enum value, stole from chat gpt
            val time = try {
                Time.valueOf(timeInput)
            } catch (e: Exception) {
                null
            }

            //sets the time suggestion to whaever string corisponds with it
            val timeSuggestion = when(time) {
                Time.MORNING -> "Review your notes from yesterday's lecture for 15 minutes"
                Time.MID_MORNING -> "Tackle your most difficult assignment or task while your focus is high "
                Time.AFTERNOON -> "Take a 10-minute break, stretch, and drink some water before continue "
                Time.AFTERNOON_SNACK_TIME -> "Do a quick 5-minute revision quiz on today's topics"
                Time.EVENING -> "Organise your notes and create a to-do list for tomorrow"
                Time.NIGHT -> "Wind down by reading over your goals and preparing your bag for tomorrow "
                else -> "dude put _ instead of space "
            }

            suggestionResult.text = timeSuggestion

        }
        //makes the button, button
        clearButton.setOnClickListener {
            suggestionResult.text = ""
            currentTime.text.clear()


        }

    }
}
// cant believe that this ran first try oml