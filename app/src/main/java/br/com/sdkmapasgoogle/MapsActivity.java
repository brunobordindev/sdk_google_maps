package br.com.sdkmapasgoogle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import br.com.sdkmapasgoogle.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //MUDAR TIPO DE MAPA
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        //CLIQUE CURTO - ADICIONAR EVENTO DE CLIQUE NO MAPA e ADICIONA MAIS UM MARCADOR
//        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(@NonNull LatLng latLng) {
//
//                mMap.addMarker(
//                        new MarkerOptions()
//                                .position(latLng)
//                                .title("Local")
//                );
//            }
//        });
//
        //CLIQUE LONGO - ADICIONAR EVENTO DE CLIQUE NO MAPA e ADICIONA MAIS UM MARCADOR
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(@NonNull LatLng latLng) {

                mMap.addMarker(
                        new MarkerOptions()
                                .position(latLng)
                                .title("Local")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icone_loja))
                );
            }
        });

        // Add a marker in Sydney and move the camera
        LatLng local = new LatLng(-25.39872958528963, -49.241735864233576);

        //COMO FAZER UM CIRCULO
//        CircleOptions circleOptions = new CircleOptions();
//        circleOptions.center(local);
//        circleOptions.radius(500); // em metros
//        circleOptions.strokeWidth(4); // de 0 a 10 a grossura da linha
//        circleOptions.strokeColor(Color.GREEN); //posso utilizar tbm o argb de cor
//        circleOptions.fillColor(Color.argb(128, 255, 153, 0)); //aplha 0 ate 255 opacidade
//        mMap.addCircle(circleOptions);

        //CRIANDO A AREA QUE DESEJO MARCAR
//        PolygonOptions polygonOptions = new PolygonOptions();
//        polygonOptions.add(new LatLng( -25.39838550322965, -49.24217736065561));
//        polygonOptions.add(new LatLng( -25.39757481877607, -49.24146173690013));
//        polygonOptions.add(new LatLng(   -25.39892247244801, -49.240405595291314));
//        polygonOptions.add(new LatLng(   -25.399503904339387, -49.24128853374149));
//        mMap.addPolygon(polygonOptions);

        //DESENHANDO LINHAS
//        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(@NonNull LatLng latLng) {
//
//                PolylineOptions polylineOptions = new PolylineOptions();
//                polylineOptions.add(local);
//                polylineOptions.add(latLng);
//                polylineOptions.color(Color.BLUE);
//                polylineOptions.width(8);
//                mMap.addPolyline(polylineOptions);
//
//                mMap.addMarker(
//                        new MarkerOptions()
//                                .position(latLng)
//                                .title("Local")
//                );
//            }
//        });

        mMap.addMarker(
                new MarkerOptions()
                        .position(local)
                        .title("Marker in Local")
//                        .snippet("minha casa") //descricao
//                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))//consigo definir a cor do marcador
//                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.home))// consigo trocar o icone
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 15)); // 2.0 ate 21.0
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(local));
    }
}