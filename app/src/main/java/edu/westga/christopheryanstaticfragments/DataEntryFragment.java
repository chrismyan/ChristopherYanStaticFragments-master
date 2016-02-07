package edu.westga.christopheryanstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataEntryFragment extends Fragment {
    EditText firstNumber;
    EditText secondNumber;
    DataEntryListener listener;

    public interface DataEntryListener {
        void onDataEntry(double first, double second);
    }


    public DataEntryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_entry, container, false);

        this.firstNumber = (EditText) theView.findViewById(R.id.editText);
        this.secondNumber = (EditText) theView.findViewById(R.id.editText2);
        
        //Button handler
        Button multiplyButton = (Button) theView.findViewById(R.id.button);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                multiplyButtonClicked(v);
            }
        });
        
        return  theView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (DataEntryListener) context;
    }

    private void multiplyButtonClicked(View v) {
        try {
            double number1 = Double.parseDouble(this.firstNumber.getText().toString());
            double number2 = Double.parseDouble(this.secondNumber.getText().toString());
            listener.onDataEntry(number1, number2);
        } catch (NumberFormatException ex) {

        }
    }

}
