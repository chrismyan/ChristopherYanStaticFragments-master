package edu.westga.christopheryanstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataDisplayFragment extends Fragment {
    TextView product;
    double secondNumber;
    double firstNumber;
    double productNumber;
    DataAddEntryListener listener;

    EditText firstTxt;
    EditText secondTxt;

    public interface DataAddEntryListener {
        void onDataAddEntry(double first, double second);
    }

    public double multiply(double first, double second) {
        this.productNumber = this.firstNumber * this.secondNumber;
        return this.productNumber;
    }

    public void displayProduct() {
        product.setText(Double.toString(productNumber));
    }

    public double getFirstNumber() {
        return this.firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return this.secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public DataDisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_display, container, false);

        //TODO: Is this how you store a reference to the TextView in the data member declared in step 1
        this.product = (TextView) theView.findViewById(R.id.textView);

        // Get Values from editText fields
        this.firstTxt = (EditText) theView.findViewById(R.id.editText);
        this.secondTxt = (EditText) theView.findViewById(R.id.editText2);

        Button sumButton = (Button) theView.findViewById(R.id.button2);
        sumButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sumButtonClicked(v);
            }
        });

        return theView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (DataAddEntryListener) context;
    }

    private void sumButtonClicked(View v) {
        listener.onDataAddEntry(firstNumber,secondNumber);
    }

}
