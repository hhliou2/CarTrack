package com.example.menga.imagerec;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

public class SavedCarImage {

    private String fileDirectory = "No directory!";

    public SavedCarImage(String fd) {
        fileDirectory = fd;
    }

    public void createDirectoryAndSaveFile(Bitmap imageToSave, String fileName) {

        File direct = new File(Environment.getExternalStorageDirectory() + "/DirName");

        if (!direct.exists()) {
            File wallpaperDirectory = new File(fileDirectory);
            wallpaperDirectory.mkdirs();
        }

        File file = new File(new File(fileDirectory), fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            imageToSave.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        fileDirectory = file.getParent();
    }

    public String getFileDirectory() {
        return fileDirectory;
    }
}
