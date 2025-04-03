package com.example.bai_tap_0304;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnChoose, btnUpload;
    private ImageView imgChoose;
    private EditText editUserName;
    private Uri imageUri;
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các view
//        btnChoose = findViewById(R.id.btnChoose);
//        btnUpload = findViewById(R.id.btnUpload);
//        imgChoose = findViewById(R.id.imgChoose);
//        editUserName = findViewById(R.id.editUserName);

        // Sự kiện chọn ảnh
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở gallery để chọn ảnh
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE);
            }
        });

        // Sự kiện upload ảnh
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageUri != null) {
                    uploadFileToServer(imageUri);
                }
            }
        });
    }

    // Phương thức onActivityResult để nhận kết quả chọn ảnh
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();  // Lấy đường dẫn URI của ảnh được chọn
            imgChoose.setImageURI(imageUri);  // Hiển thị ảnh lên ImageView
        }
    }

    // Phương thức upload file lên server
    private void uploadFileToServer(Uri fileUri) {
        // Cài đặt mã để upload file ở đây
    }
}
