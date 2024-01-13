package vn.poly.mob305.demologin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail,edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);


        findViewById(R.id.btnLogin).setOnClickListener(v ->{

            String email = edtEmail.getText().toString().trim();// lấy ra string đã nhập và cắt khoảng space 2 đầu
            String password = edtPassword.getText().toString().trim();// lấy ra string đã nhập và cắt khoảng space 2 đầu
            // viết câu lệnh truy vấn để Fireabse để kiểm tra tài khoản có tồn tại ko
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, task -> {
                if (task.isSuccessful()){
                    Toast.makeText(this, "OK LOGIN THANH CONG!!!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Login Fail.!!!", Toast.LENGTH_SHORT).show();
                }
            });
        });

        findViewById(R.id.tvSignUp).setOnClickListener(v->{
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.createUserWithEmailAndPassword("huynguyen@gmail.com","123456").addOnCompleteListener(this,
                    task -> {
                        if (task.isSuccessful()){
                            Toast.makeText(this, "OK SIGN UP THANH CONG!!!", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(this, "SIGN UP Fail.!!!", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}