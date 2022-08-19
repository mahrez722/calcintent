package com.example.calculatorintentbilly

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    lateinit var ButtonSMS: Button
    lateinit var ButtonEMAIL: Button
    lateinit var ButtonCALL: Button
    lateinit var ButtonMPESA: Button
    lateinit var ButtonSHARE: Button
    lateinit var ButtonCAMERA: Button
    lateinit var ButtonDial: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButtonSMS = findViewById(R.id.Btn_Sms)
        ButtonEMAIL = findViewById(R.id.Btn_Email)
        ButtonCALL = findViewById(R.id.Btn_Call)
        ButtonMPESA = findViewById(R.id.Btn_Mpesa)
        ButtonSHARE = findViewById(R.id.Btn_Share)
        ButtonCAMERA = findViewById(R.id.Btn_Camera)
        ButtonDial = findViewById(R.id.Btn_Dial)

        ButtonSMS.setOnClickListener {
            val uri = Uri.parse("smsto:0705562039")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("sms_body", "The SMS text")

            startActivity(intent)
        }
        ButtonEMAIL.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
        ButtonCALL.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1)
            } else {
                startActivity(intent)
            }
        }
        ButtonCAMERA.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(takePictureIntent, 1)
        }
        ButtonMPESA.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }
        }
        ButtonSHARE.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)
        }
        ButtonDial.setOnClickListener {
            val phone = "+34666777888"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)
        }



    }
}