package vn.edu.vhu.ltdd.a3layout;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

/** Màn hình Đăng ký tài khoản dựng bằng ConstraintLayout, tái sử dụng thẻ hồ sơ qua <include>. */
public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        Button btnDoRegister = findViewById(R.id.btnDoRegister);
        Button btnBackToLogin = findViewById(R.id.btnBackToLogin);

        if (btnDoRegister != null) {
            btnDoRegister.setOnClickListener(v ->
                    Snackbar.make(v, getString(R.string.register_success), Snackbar.LENGTH_SHORT).show());
        }

        if (btnBackToLogin != null) {
            btnBackToLogin.setOnClickListener(v -> finish());
        }
    }
}