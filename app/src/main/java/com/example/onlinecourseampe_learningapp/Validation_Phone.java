//package com.example.onlinecourseampe_learningapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.FirebaseException;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.PhoneAuthCredential;
//import com.google.firebase.auth.PhoneAuthOptions;
//import com.google.firebase.auth.PhoneAuthProvider;
//
//import java.util.concurrent.TimeUnit;
//
//public class Validation_Phone extends AppCompatActivity {
//
//    private EditText phoneEditText;
//    private Button btnSendCode;
//    private FirebaseAuth mAuth;
//    private String verificationId;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_validation_phone);
//
//        phoneEditText = findViewById(R.id.phoneEditText);
//        btnSendCode = findViewById(R.id.btnSendCode);
//
//        mAuth = FirebaseAuth.getInstance();
//
//        btnSendCode.setOnClickListener(v -> {
//            String phoneNumber = phoneEditText.getText().toString().trim();
//
//            if (TextUtils.isEmpty(phoneNumber)) {
//                phoneEditText.setError("يرجى إدخال رقم الهاتف");
//                return;
//            }
//
//            sendVerificationCode(phoneNumber);
//        });
//    }
//
//    private void sendVerificationCode(String phoneNumber) {
//        PhoneAuthOptions options =
//                PhoneAuthOptions.newBuilder(mAuth)
//                        .setPhoneNumber(phoneNumber)       // رقم الهاتف
//                        .setTimeout(60L, TimeUnit.SECONDS) // وقت المهلة
//                        .setActivity(this)
//                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                            @Override
//                            public void onVerificationCompleted(PhoneAuthCredential credential) {
//                                // التحقق التلقائي (اختياري)
//                            }
//
//                            @Override
//                            public void onVerificationFailed(@NonNull FirebaseException e) {
//
//                            }
//
//                            public void onVerificationFailed(Exception e) {
//                                Toast.makeText(Validation_Phone.this, "فشل الإرسال: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken token) {
//                                super.onCodeSent(verificationId, token);
//                                Validation_Phone.this.verificationId = verificationId;
//
//                                // الانتقال إلى واجهة إدخال الرمز
//                                Intent intent = new Intent(Validation_Phone.this, VerifyCodeActivity.class);
//                                intent.putExtra("verificationId", verificationId);
//                                startActivity(intent);
//                            }
//                        }).build();
//        PhoneAuthProvider.verifyPhoneNumber(options);
//    }
//}
