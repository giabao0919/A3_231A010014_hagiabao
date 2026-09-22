package vn.edu.vhu.ltdd.a3layout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

/**
 * Lab A3 tập trung vào XML Layout, nên phần Java chỉ làm 3 việc:
 * ánh xạ view, hiện Snackbar khi bấm Đăng nhập và mở màn hình ConstraintLayout.
 */
public class MainActivity extends AppCompatActivity {

    // TODO: thay 2201234567 bằng MSSV của bạn
    private static final String TAG = "A3_2201234567";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        boolean nam = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
        Log.d(TAG, "Hệ thống đã nạp layout: " + (nam ? "res/layout-land" : "res/layout"));

        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnConstraint = findViewById(R.id.btnConstraintDemo);
        CheckBox cbRemember = findViewById(R.id.cbRemember);

        btnLogin.setOnClickListener(v ->
                Snackbar.make(v, getString(R.string.login_success)
                        + (cbRemember.isChecked() ? " (đã ghi nhớ)" : ""), Snackbar.LENGTH_SHORT).show());

        // Chuyển màn hình sẽ học kỹ ở Lab A5; ở đây chỉ dùng một dòng để xem bản ConstraintLayout
        btnConstraint.setOnClickListener(v ->
                startActivity(new Intent(this, ConstraintDemoActivity.class)));

        // Mở màn hình Đăng ký
        Button btnRegister = findViewById(R.id.btnRegister);
        if (btnRegister != null) {
            btnRegister.setOnClickListener(v ->
                    startActivity(new Intent(this, RegisterActivity.class)));
        }

        // Chuyển đổi giữa Chế độ Sáng (Light Mode) và Chế độ Tối (Dark Mode)
        Button btnToggleTheme = findViewById(R.id.btnToggleTheme);
        if (btnToggleTheme != null) {
            int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
            boolean isNight = currentNightMode == Configuration.UI_MODE_NIGHT_YES;
            btnToggleTheme.setText(isNight ? R.string.theme_light : R.string.theme_dark);

            btnToggleTheme.setOnClickListener(v -> {
                if (isNight) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
            });
        }
    }
}