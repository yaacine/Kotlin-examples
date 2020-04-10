package com.example.todolist

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the array lists and the adapter
        var itemlist = arrayListOf<String>()
        // another list to keep the date of the todo item
        var dataList = arrayListOf<TodoItem>()
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, itemlist)
        listView.adapter =  adapter
        //populating dataList with some initial Todos for examples
        var todo1 = TodoItem("task for today" ,LocalDate.now().toString())
        var todo2 = TodoItem("task for tomorrow" ,LocalDate.now().plusDays(1).toString())
        var todo3 = TodoItem("task for next month" ,LocalDate.now().plusMonths(1).toString())

        dataList.add(todo1)
        dataList.add(todo2)
        dataList.add(todo3)

        // setting the spinner to select witch data to display
        val languages = resources.getStringArray(R.array.displays)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val SpinAdapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages)
            spinner.adapter = SpinAdapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                @RequiresApi(Build.VERSION_CODES.O)
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    print("posiotionnn====>"+position)
                    val current = LocalDate.now()

                    when(position){
                        0 -> {
                            itemlist.clear()

                            // getting today's todos
                            for (elt in dataList){
                                var parsedDate = LocalDate.parse(elt.date)
                                if(parsedDate.isEqual(current)){
                                    itemlist.add(elt.content)
                                }

                            }

                            adapter.notifyDataSetChanged()

                        }

                        1 ->{
                            itemlist.clear()

                            // getting week's todos
                            for (elt in dataList){
                                var parsedDate = LocalDate.parse(elt.date)
                                if(!parsedDate.isAfter(current.plusWeeks(1))){
                                    itemlist.add(elt.content)
                                }
                            }

                            adapter.notifyDataSetChanged()

                        }

                        2-> {
                            itemlist.clear()

                            // getting all todos
                            for (elt in dataList){
                                var parsedDate = LocalDate.parse(elt.date)
                                itemlist.add(elt.content)
                            }

                            adapter.notifyDataSetChanged()
                        }
                    }





                    Toast.makeText(this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }


        // menu listners for tablet landscape
        all?.setOnClickListener{
            itemlist.clear()

            for (elt in dataList){
                var parsedDate = LocalDate.parse(elt.date)
                itemlist.add(elt.content)
            }


            adapter.notifyDataSetChanged()
        }

        week?.setOnClickListener{
            val current = LocalDate.now()
            itemlist.clear()

            // getting week's todos
            for (elt in dataList){
                var parsedDate = LocalDate.parse(elt.date)
                if(!parsedDate.isAfter(current.plusWeeks(1))){
                    itemlist.add(elt.content)
                }
            }

            adapter.notifyDataSetChanged()
        }

        day?.setOnClickListener{
            val current = LocalDate.now()
            itemlist.clear()
            // getting today's todos
            for (elt in dataList){
                var parsedDate = LocalDate.parse(elt.date)
                if(parsedDate.isEqual(current)){
                    itemlist.add(elt.content)
                }

            }

            adapter.notifyDataSetChanged()
        }




        // getting today's todos by default for small screens
        val current = LocalDate.now()
        println("currentdata ====> "+ current.toString())
        itemlist.clear()

        for (elt in dataList){
            println("date of item ===>"+LocalDate.parse(elt.date))
            var parsedDate = LocalDate.parse(elt.date)
            if(parsedDate.isEqual(current)){

                itemlist.add(elt.content)

                adapter.notifyDataSetChanged()
            }
        }


        // Adding the items to the list when the add button is pressed
        add.setOnClickListener {
            println("new date ====> "+editTextDate.text.toString().replace("/", "-"))
            var entredDate = editTextDate.text.toString().replace("/", "-")
            var elements = entredDate.split("-")
            var correctDate = elements[2]+"-"+elements[1]+"-"+elements[0]
            println("correctedate ===>" +correctDate)
            val newItem = TodoItem(editText.text.toString() , date1 = correctDate)
            dataList.add(newItem)
            itemlist.add(editText.text.toString())
            listView.adapter =  adapter
            adapter.notifyDataSetChanged()
            // This is because every time when you add the item the input      space or the eidt text space will be cleared
            editText.text.clear()
            editTextDate.text.clear()
        }

        // Selecting and Deleting the items from the list when the delete button is pressed
        delete.setOnClickListener {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    adapter.remove(itemlist.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }

        // Clearing all the items in the list when the clear button is pressed
        clear.setOnClickListener {

            itemlist.clear()
            dataList.clear()
            adapter.notifyDataSetChanged()

        }

        // Adding the toast message to the list when an item on the list is pressed
        listView.setOnItemClickListener { adapterView, view, i, l ->
            android.widget.Toast.makeText(this, "You Selected the item --> "+itemlist.get(i), android.widget.Toast.LENGTH_SHORT).show()
        }
    }
}
