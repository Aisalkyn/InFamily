package com.example.nestana.infamily.ui

import android.annotation.TargetApi
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.support.v4.content.FileProvider
import android.support.v7.app.AlertDialog
import com.baktiyar.android.jardamberem.utils.Constants
import com.example.nestana.infamily.BuildConfig
import com.example.nestana.infamily.R
import com.example.nestana.infamily.utils.Permissions
import com.example.nestana.infamily.utils.FileUtils
import id.zelory.compressor.Compressor
import java.io.File


abstract class PhotoAnalyzeActivity : BaseActivity() {
    protected var fileName: String? = null
    var paths: ArrayList<String>? = ArrayList()
    protected fun showPickImageDialog() {
        val args = arrayOf<String>(getString(R.string.pick_photo_from_camera),
            getString(R.string.pick_photo_from_gallery))
        AlertDialog.Builder(this).setItems(args, { dialog, w ->
            if (w == 0) takePhotoFromCamera()
            else pickPhotoFromGallery()
            dialog.dismiss()
        }).show()
    }

    private fun takePhotoFromCamera() {
        if (Permissions.iPermissionCamera(this)) {
            fileName = System.nanoTime().toString()
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val uri = FileUtils.getCaptureImageOutputUri(this, fileName)
            if (uri != null) {
                val file = File(uri.path)
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        FileProvider.getUriForFile(this,
                            BuildConfig.APPLICATION_ID + ".provider",
                            file))
                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                } else intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)

                startActivityForResult(intent, Constants.CAMERA)
            }
        }
    }

    private fun pickPhotoFromGallery() {
        if (Permissions.iPermissionReadStorage(this)) {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, Constants.GALLERY)
        }
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                Constants.CAMERA -> {
                    val uri = FileUtils.getPickImageResultUri(this, data, fileName)
                    val file = FileUtils.getNormalizedUri(this, uri)
                    val path = Compressor.getDefault(this).compressToFile(File(file.path)).path
                    paths!!.add(path)
                }
                Constants.GALLERY -> {
                    if (data != null || data!!.clipData != null) {
                        var count = data.clipData?.itemCount
                        var currentItem = 0

                        if (data.clipData == null && data.data != null) {
                            val file = FileUtils.getImagePathFromInputStreamUri(this, data.data)
                            val path = Compressor.getDefault(this).compressToFile(File(file!!)).path
                            paths!!.add(path)

                        } else while (currentItem < count!!) {
                            val imageUri = data.clipData.getItemAt(currentItem).uri
                            val file = FileUtils.getImagePathFromInputStreamUri(this, imageUri)
                            val path = Compressor.getDefault(this).compressToFile(File(file!!)).path
                            paths?.add(path)
                            ++currentItem
                        }
                    }
                }
            }
            setImagePaths(paths)
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == Permissions.Request.READ_EXTERNAL_STORAGE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            pickPhotoFromGallery()
        } else if (requestCode == Constants.CAMERA && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            takePhotoFromCamera()
        }
    }

    abstract fun setImagePaths(imgPaths: ArrayList<String>?)
}