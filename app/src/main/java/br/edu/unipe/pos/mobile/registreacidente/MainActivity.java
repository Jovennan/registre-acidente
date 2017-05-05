package br.edu.unipe.pos.mobile.registreacidente;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import br.edu.unipe.pos.mobile.registreacidente.model.Pessoa;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, PessoaInsertFragment.OnFragmentInteractionListener,
        PessoaFragment.OnListFragmentInteractionListener, VeiculoInsertFragment.OnFragmentInteractionListener {
//    private static final int CODE_PHOTO = 567;
//    private String pathPhoto;
//    private ImageView imageViewPhoto;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
//        }else if(id == R.id.itemMenuAddPessoa){
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new PessoaInsertFragment()).commit();
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Boolean FragmentoSelecionado = false;

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_add_pessoa) {

            fragment = new PessoaFragment();
            FragmentoSelecionado = true;

        } else if (id == R.id.nav_add_veiculo) {
            fragment = new VeiculoInsertFragment();
            FragmentoSelecionado = true;
        } else if (id == R.id.nav_relatorio) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        if(FragmentoSelecionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(Pessoa item) {

    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        pathPhoto = getExternalFilesDir(null)+"/"+ System.currentTimeMillis()+".jpg";
//        if(resultCode == Activity.RESULT_OK && requestCode == CODE_PHOTO){
//            imageViewPhoto = (ImageView) findViewById((R.id.veiculoInsert_imageViewPhoto));
//            imageViewPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
//            Bitmap bitmap = BitmapFactory.decodeFile(pathPhoto);
//            Bitmap bitmapReduce = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
//            imageViewPhoto.setImageBitmap(bitmapReduce);
//            imageViewPhoto.setTag(pathPhoto);
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}
