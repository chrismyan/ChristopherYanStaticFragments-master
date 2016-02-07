package edu.westga.christopheryanstaticfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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




    public double multiply(double first, double second) {
        this.productNumber = this.firstNumber * this.secondNumber;
        return this.productNumber;
    }

//    public void displayProduct(View view) {
//        TextView result = (TextView) view.findViewById(R.id.textView);
//        result.setText(Double.toString(productNumber));
//    }

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

        return theView;
    }

}
