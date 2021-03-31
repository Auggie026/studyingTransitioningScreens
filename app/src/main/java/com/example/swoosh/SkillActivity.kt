package com.example.swoosh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)!!
        println(player.league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
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
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }

    }
}