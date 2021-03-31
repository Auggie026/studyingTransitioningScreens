package com.example.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE).toString()
        println(league)
    }

    fun onBallerClick(view: View){
        beginnerSkillBtn.isChecked = false
        if(true.also { ballerSkillBtn.isChecked = true }){
            skill = "baller"
        } else {
            skill = ""
        }

    }

    fun onBeginnerClick(view: View){
        ballerSkillBtn.isChecked = false
        if(true.also{beginnerSkillBtn.isChecked = true}){
            skill = "beginner"
        } else {
            skill = ""
        }

    }

    fun onSkillFinishClicked(view: View){
        if(skill != ""){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }

    }
}