package com.example.calculatorintentbilly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var ButtonAdd:Button
    lateinit var ButtonSub:Button
    lateinit var ButtonMultply:Button
    lateinit var ButtonDiv:Button
    lateinit var Edit_fnum:EditText
    lateinit var Edit_snum:EditText
    lateinit var Text_Ans:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        ButtonAdd=findViewById(R.id.Btn_Add)
        ButtonSub=findViewById(R.id.Btn_Subtract)
        ButtonMultply=findViewById(R.id.Btn_Multiply)
        ButtonDiv=findViewById(R.id.Btn_Divide)
        Edit_fnum=findViewById(R.id.Edt_Firstnumber)
        Edit_snum=findViewById(R.id.Edt_Secondnumber)
        Text_Ans=findViewById(R.id.Txt_Answer)

        ButtonAdd.setOnClickListener {
            var firstnumber=Edit_fnum.text.toString()
            var secondnumber=Edit_snum.text.toString()

            if (firstnumber.isEmpty() && secondnumber.isEmpty()){
                Text_Ans.text="Please fill in the details"
            }else{
                var ans=firstnumber.toDouble() + secondnumber.toDouble()
                Text_Ans.text=ans.toString()
            }
        }
        ButtonSub.setOnClickListener {
            var firstnumber=Edit_fnum.text.toString()
            var secondnumber=Edit_snum.text.toString()

            if (firstnumber.isEmpty() && secondnumber.isEmpty()){
                Text_Ans.text="Please fill in the details"
            }else{
                var ans=firstnumber.toDouble() - secondnumber.toDouble()
                Text_Ans.text=ans.toString()
            }
        }
        ButtonMultply.setOnClickListener {
            var firstnumber=Edit_fnum.text.toString()
            var secondnumber=Edit_snum.text.toString()

            if (firstnumber.isEmpty() && secondnumber.isEmpty()){
                Text_Ans.text="Please fill in the details"
            }else{
                var ans=firstnumber.toDouble() * secondnumber.toDouble()
                Text_Ans.text=ans.toString()
            }
        }
        ButtonDiv.setOnClickListener {
            var firstnumber=Edit_fnum.text.toString()
            var secondnumber=Edit_snum.text.toString()

            if (firstnumber.isEmpty() && secondnumber.isEmpty()){
                Text_Ans.text="Please fill in the details"
            }else{
                var ans=firstnumber.toDouble() / secondnumber.toDouble()
                Text_Ans.text=ans.toString()
            }
        }
    }
}