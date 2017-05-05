package br.edu.unipe.pos.mobile.registreacidente;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.unipe.pos.mobile.registreacidente.adapter.FotoVeiculoAdapter;
import br.edu.unipe.pos.mobile.registreacidente.model.FotoVeiculo;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VeiculoInsertFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VeiculoInsertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VeiculoInsertFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final int CODE_PHOTO = 567;
    private OnFragmentInteractionListener mListener;
    private String pathPhoto;
    private ImageView imageViewPhoto;
    private ListView fotosListView;
//    private Spinner spnPerspectivas;
//    private List<String> perspectivas; // = new ArrayList<String>();

    public VeiculoInsertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PessoaInsertFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VeiculoInsertFragment newInstance(String param1, String param2) {
        VeiculoInsertFragment fragment = new VeiculoInsertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        buildFotosVeiculoList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        perspectivas.add("Esquerda");
//        perspectivas.add("Direita");
//        perspectivas.add("Frontal");
//        perspectivas.add("Traseira");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_veiculo_insert, container, false);

        //Identifica o ListView das fotos no layout
        fotosListView = (ListView) view.findViewById(R.id.fotosVeiculo_listView);
        //Identifica o Spinner no layout
//        spnPerspectivas = (Spinner) view.findViewById(R.id.spinnerPerspectiva);
//
//        //Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, perspectivas);
//        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
//        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        spnPerspectivas.setAdapter(spinnerArrayAdapter);
//
//        //Método do Spinner para capturar o item selecionado
//        spnPerspectivas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
//                //pega a perspectivas pela posição
//                String perspectiva = parent.getItemAtPosition(posicao).toString();
//                //imprime um Toast na tela com o nome que foi selecionado
//                Toast.makeText(getActivity(), "Perspectiva Selecionada: " + perspectiva, Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        FloatingActionButton buttonPhoto = (FloatingActionButton) view.findViewById(R.id.fab_add_photo);
        buttonPhoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "Button Clicado", Toast.LENGTH_LONG).show();

                try{
                    Intent intentCaptureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    pathPhoto = getActivity().getExternalFilesDir(null)+"/"+ System.currentTimeMillis()+".jpg";
                    File filePhoto = new File(pathPhoto);
                    FotoVeiculo novaFotoVeiculo = new FotoVeiculo();
                    novaFotoVeiculo.setCaminho(pathPhoto);
                    novaFotoVeiculo.save();
                    Uri photoURI = FileProvider.getUriForFile(getActivity(), getActivity().getApplicationContext().getPackageName() + ".files", filePhoto);
                    intentCaptureImage.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(intentCaptureImage, CODE_PHOTO);
                }catch (Exception ex){
                    ex.printStackTrace();
                    Log.e("Error "+ex.toString(), ex.getMessage());
                    Toast.makeText(getContext(), "error no onClick "+ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == CODE_PHOTO){
            Toast.makeText(getContext(), "entrou no onActivityResult", Toast.LENGTH_SHORT).show();
            try{
                imageViewPhoto = (ImageView) getActivity().findViewById((R.id.veiculoInsert_imageViewPhoto));
                imageViewPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
                Bitmap bitmap = BitmapFactory.decodeFile(pathPhoto);
                Bitmap bitmapReduce = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
                imageViewPhoto.setImageBitmap(bitmapReduce);
                imageViewPhoto.setTag(pathPhoto);

            }catch (Exception ex){
                ex.printStackTrace();
                Log.e("Error "+ex.toString(), ex.getMessage());
                Toast.makeText(getContext(), "error no onActivityResult "+ex.getMessage(), Toast.LENGTH_LONG).show();
            }
            Toast.makeText(getContext(), "saindo do onActivityResult", Toast.LENGTH_SHORT).show();

        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void buildFotosVeiculoList(){
        List<FotoVeiculo> fotoVeiculoList = FotoVeiculo.listAll(FotoVeiculo.class);
        FotoVeiculoAdapter fotoVeiculoAdapter = new FotoVeiculoAdapter(getActivity(), fotoVeiculoList);
        fotosListView.setAdapter(fotoVeiculoAdapter);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
