package edu.westga.christopheryanstaticfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplaySumFragment extends Fragment {
    TextView theSum;
    double firstDbl;
    double secondDbl;
    double sumDbl;

    public double getFirstNumber() {
        return firstDbl;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstDbl = firstNumber;
    }

    public double getSecondNumber() {
        return secondDbl;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondDbl = secondNumber;
    }

    public DisplaySumFragment() {
        // Required empty public constructor
    }

    public void sum() {
        this.sumDbl = this.firstDbl + this.secondDbl;
    }

    public void displaySum() {
        this.theSum.setText(Double.toString(this.sumDbl));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_display_sum, container, false);
        this.theSum = (TextView) theView.findViewById(R.id.sumTextView);
        return theView;
    }

}
