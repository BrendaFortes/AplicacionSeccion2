package com.example.brend.aplicacionseccion2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private EditText mNombre, mApellido, mNumeroEmp, mNSS, mRFC, mCURP, mNacimiento;
    private Button mAceptar;
    private Button titulo;
    private LinearLayout linear;
    private boolean bandera = true;
//    private Button mVer;

    private ListView listV_Empleados;
    private List<Empleado> listEmpleado=new ArrayList<Empleado>();
    ArrayAdapter<Empleado> arrayAdapterEmpleado;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNombre = findViewById(R.id.txt_nombre);
        mApellido = findViewById(R.id.txt_apellidos);
        mNumeroEmp = findViewById(R.id.txt_noemp);
        mNSS = findViewById(R.id.txt_nss);
        mRFC = findViewById(R.id.txt_rfc);
        mCURP = findViewById(R.id.txt_curp);
        mNacimiento = findViewById(R.id.txt_nacimiento);

        titulo=findViewById(R.id.txt_titulo);
        linear=findViewById(R.id.linearlay);
        listV_Empleados=findViewById(R.id.listview);

        mAceptar = findViewById(R.id.btn_aceptar);
        initializeFirebase();
        listData();

        mAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Empleado e=new Empleado();
                e.setUid(UUID.randomUUID().toString()); //
                e.setNombre_emp(mNombre.getText().toString());
                e.setApellido_emp(mApellido.getText().toString());
                e.setNum_emp(mNumeroEmp.getText().toString());
                e.setNSS_emp(mNSS.getText().toString());
                e.setRFC_emp(mRFC.getText().toString());
                e.setCURP_emp(mCURP.getText().toString());
                e.setNacimiento_emp(mNacimiento.getText().toString());
                databaseReference.child("Empleado").child(e.getUid()).setValue(e);
                ClearText();
                    Toast.makeText(MainActivity.this, "Empleado Agregado", Toast.LENGTH_LONG).show();
            }
        });

        titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bandera){
                    linear.setVisibility(View.VISIBLE);
                    bandera = false;
                }
                else {
                    linear.setVisibility(View.GONE);
                    bandera = true;
                }
            }
        });
    }

    private void listData(){
        databaseReference.child("Empleado").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listEmpleado.clear();
                for(DataSnapshot objSnapShop :dataSnapshot.getChildren()){
                    Empleado e=objSnapShop.getValue(Empleado.class);
                    listEmpleado.add(e);
                    arrayAdapterEmpleado=new ArrayAdapter<Empleado>(MainActivity.this,android.R.layout.simple_list_item_1,listEmpleado);
                    listV_Empleados.setAdapter(arrayAdapterEmpleado);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initializeFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void ClearText(){
        mNombre.setText("");
        mApellido.setText("");
        mNumeroEmp.setText("");
        mNSS.setText("");
        mRFC.setText("");
        mCURP.setText("");
        mNacimiento.setText("");
    }
}
