package com.example.task16

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  val adapter : ListAdapter= ListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        setData(1)
    }
    val models: MutableList<User> = mutableListOf()
   private fun setData(count: Int) {
       for (i in 0 until count) {
           val model = User()
           model.title = "Title ${i + 1}"
           model.description = "Description ${i + 1}"
           models.add(model)
       }
       adapter.setData(models)
   }


    fun onOptionsButtonClick(view: View, position: Int){
        val optionsMenu=PopupMenu(this, view)
        val menuInflater=optionsMenu.menuInflater
        menuInflater.inflate(R.menu.menu_item_options,optionsMenu.menu)
        optionsMenu.show()
        optionsMenu.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.itemAdd ->{
                    var dialog=AlertDialog.Builder(this)
                    dialog.setTitle("Aniq itemdi qosajaqsizba?")
                    dialog.setMessage("Itemdi qosip keyin oshirseniz boladi")
                    dialog.setPositiveButton("Awa") {dialog, which -> adapter.addUser(position+1) }
                    dialog.setNegativeButton("Yaq") {dialog, which -> dialog.dismiss() }
                    dialog.setNeutralButton("Oylanip koreyin") {dialog, which ->dialog.dismiss()  }
                    dialog.show()
                }
                R.id.itemDelete ->{
                    var dialog=AlertDialog.Builder(this)
                        dialog.setTitle("Siz aniq usi itemdi oshirejaqsizba?")
                        dialog.setMessage("Oshirsen qaytip tiklenbeydi oylanip kor bala")
                        dialog.setPositiveButton("Awa") {dialog, which -> adapter.removeUser(position) }
                        dialog.setNegativeButton("Yaq") {dialog, which -> dialog.dismiss() }
                        dialog.setNeutralButton("Oylanip koreyin") {dialog, which ->dialog.dismiss()  }
                    dialog.show()
                }
            }
            return@setOnMenuItemClickListener true
        }
    }


}
