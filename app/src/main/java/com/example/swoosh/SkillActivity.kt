package com.example.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var player = Player("", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player.league = intent.getStringExtra(EXTRA_LEAGUE).toString()
        println(player.league)
    }

    fun onBallerClick(view: View){
        beginnerSkillBtn.isChecked = false
        if(true.also { ballerSkillBtn.isChecked = true }){
            player.skill = "baller"
        } else {
            player.skill = ""
        }

    }

    fun onBeginnerClick(view: View){
        ballerSkillBtn.isChecked = false
        if(true.also{beginnerSkillBtn.isChecked = true}){
            player.skill = "beginner"
        } else {
            player.skill = ""
        }

    }

    fun onSkillFinishClicked(view: View){
        if(player.skill != ""){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, player.league)
            finishActivity.putExtra(EXTRA_SKILL, player.skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }

    }
}