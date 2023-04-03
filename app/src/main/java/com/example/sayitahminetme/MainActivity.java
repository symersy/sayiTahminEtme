package com.example.sayitahminetme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtKalanHak , txtSonuc;
    private EditText editTxtSayi;
    private String gelenDeger;
    private int kalanHak = 3 , randomSayi;
    private Random rndNumber;//Random sınıfından rndNumber isimli bir değişken oluşturdum.
    private boolean tahminDogrumu = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKalanHak = (TextView)findViewById(R.id.txtViewKalanHak);
        txtSonuc = (TextView)findViewById(R.id.txtViewSonuc);
        editTxtSayi = (EditText)findViewById(R.id.editTxtSayi);

        rndNumber = new Random();
        randomSayi = rndNumber.nextInt(10);//parantezin dışına +1 yazsaydım 1 ve 10 arasındaki sayılardan random bir sayı gelecekti.
        //Ve 1 ve 10 da dahiş.Ama bu şekilde 0 ve 10 dahil.
        System.out.println("Random Sayı: " + randomSayi);
    }

    public void btnTahminEt(View v){
        gelenDeger = editTxtSayi.getText().toString();

        if(!TextUtils.isEmpty(gelenDeger)){
            if(kalanHak > 0 && tahminDogrumu == false){
                if(gelenDeger.equals(String.valueOf(randomSayi))) {
                    sonucGoster("Tebrikler Doğru Tahminde Bulundunuz...");
                    tahminDogrumu = true;
                }
                else {
                    txtSonuc.setText("Yanlış Tahminde Bulundunuz!");
                    editTxtSayi.setText("");
                }

                kalanHak--;
                txtKalanHak.setText("Kalan Hak: " + kalanHak);

                if (kalanHak == 0 && tahminDogrumu == false) {
                    sonucGoster("Tahmin Hakkınız Bitti.\nBilmeniz gereken Sayı "+randomSayi+" İdi!");
                    editTxtSayi.setText(" ");/*Bir boşluk olsa bile içerisi dolu olarak çalışır ve tahmin hakkı bittiğinde
                    içerisi dolu olduğu için boş değer uyarısı gelmesi önlenir.*/
                }
            }else
                txtSonuc.setText("Oyun Bitti !");
        }else
            txtSonuc.setText("Girilen Değer Boş Olamaz !");

    }

    private void sonucGoster(String mesaj) {
        editTxtSayi.setEnabled(false);
        txtSonuc.setText(mesaj);
    }
}