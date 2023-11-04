package com.turacican.cookbook

import android.Manifest
import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import java.io.ByteArrayOutputStream


class CookFragment : Fragment() {

    var selectedImage : Uri? = null
    var selectedBitmap : Bitmap? = null
    var  cookImage : ImageView? = null

    var cookNameObject : EditText? = null
    var cookDetailObject : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cook, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val saveButton : Button = view.findViewById(R.id.btnSave)
        saveButton.setOnClickListener {
            btn_saveCook(it)
        }

        val selectImageButton : ImageView = view.findViewById(R.id.img_SelectImage)
        selectImageButton.setOnClickListener {
            btn_SelectCookImage(it)
        }

        cookDetailObject = view.findViewById(R.id.tbxCookDetail)
        cookNameObject = view.findViewById(R.id.tbxFoodName)

        cookImage = view.findViewById(R.id.img_SelectImage)


    }

    fun btn_SelectCookImage(view: View){

        //eğer aktivite null değilse içerisine gelecek
        activity?.let {
            //Burada 'ContextCompat' kullanmamızın sebebi ise, API leveline göre kendisi kontrol etmesidir.
            // ContextCompat yazmazsak her izin için Api leveline göre kontrol yazmak gerekir.

            val galeriIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galeriIntent, 2)

//            val galeriIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//            startActivityForResult(galeriIntent, 2)

//            if(ContextCompat.checkSelfPermission(it.applicationContext, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
//                //izin verilmedi, izin istemek gerekiyor
//
//                //requestCode şu şekildedir, herhangi bir değeri verebiliriz.
//                // İleride bu izini kontrol etmek gerektiğinde bu requestCode değerine göre arayacağız
////                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
//
//                ActivityCompat.requestPermissions(
//                    requireActivity(),
//                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//                    1
//                )
//
//            }
//            else{
//                //izin istemeden galeriye git
//              val galeriIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//              startActivityForResult(galeriIntent, 2)
//            }
        }
    }

    fun btn_saveCook(view: View){

        var cookName = cookNameObject?.text.toString()
        var cookDetail = cookDetailObject?.text.toString()

        if (selectedBitmap != null){
            val smallBitmap = BitmapBoyutunuKucult(selectedBitmap!!, 250)

            var outputStream = ByteArrayOutputStream()
            smallBitmap.compress(Bitmap.CompressFormat.PNG, 50, outputStream)

            val byteArray = outputStream.toByteArray()

            try {

                context?.let {
                    val db = it.openOrCreateDatabase("cooks", Context.MODE_PRIVATE, null)
                    db.execSQL("CREATE TABLE IF NOT EXISTS Cooks (ID INTGER PRIMARY KEY, COOKNAME VARCHAR, COOKDETAIL VARCHAR, COOKIMAGE BLOB)")

                    val sqlString = "INSERT INTO Cooks (COOKNAME, COOKDETAIL, COOKIMAGE) VALUES (?,?,?)";
                    val  statements = db.compileStatement(sqlString)
                    statements.bindString(1, cookName)
                    statements.bindString(2, cookDetail)
                    statements.bindBlob(3, byteArray)

                    statements.execute()


                }

            }
            catch (e: Exception){
                e.printStackTrace()
            }

            findNavController().navigate(R.id.action_cookFragment_to_listFragment)

        }


        Toast.makeText(requireContext(), "Yemek tarifiniz başarıyla eklendi.", Toast.LENGTH_SHORT).show()
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if(requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // İzin verildi, galeriye git
            val galeriIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galeriIntent, 2)
        }
        else{
            Toast.makeText(requireContext(), "Galeriye erişmek için izin gereklidir.", Toast.LENGTH_LONG).show()
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null){
            selectedImage = data.data

            try {

                if (selectedImage != null){

                    context?.let {

                        if (Build.VERSION.SDK_INT >= 28){
                            val source = ImageDecoder.createSource(it.contentResolver, selectedImage!!)
                            selectedBitmap = ImageDecoder.decodeBitmap(source)

                            if (cookImage != null)
                                cookImage!!.setImageBitmap(selectedBitmap)
                        }

                        else{
                            selectedBitmap = MediaStore.Images.Media.getBitmap(it.contentResolver, selectedImage)
                            if (cookImage != null)
                                cookImage!!.setImageBitmap(selectedBitmap)
                        }


                    }

                }

            }
            catch (e: Exception){
                e.printStackTrace()
            }

        }

        super.onActivityResult(requestCode, resultCode, data)
    }



    private val permissionLauncherSinngle = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    )
    { isGranted ->

        if (isGranted){
            Toast.makeText(requireContext(), "İzin başarıyla verildi", Toast.LENGTH_LONG)
        }

        else{
            Toast.makeText(requireContext(), "İzin gereklidir", Toast.LENGTH_LONG)
        }
    }


    fun BitmapBoyutunuKucult(selectedBitmap : Bitmap, maximumBoyut : Int) : Bitmap {

        var with   = selectedBitmap.width
        var height = selectedBitmap.height

        val bitOrani : Double = with.toDouble() / height.toDouble()

        if (bitOrani > 1){
            //Görsel yatay

            with = maximumBoyut
            height = (with / bitOrani).toInt()
        }
        else{
            height = maximumBoyut
            with = (height * bitOrani).toInt()
        }

        return Bitmap.createScaledBitmap(selectedBitmap, with, height, true)
    }

}
