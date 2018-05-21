package org.pltw.examples.thecardgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CardInfoFragment extends Fragment {

    private LayoutInflater mInflater;
    private ViewGroup mContainer;


    private String TAG = this.getClass().getName();
    private Card card;
    private ImageView imageView;
    private TextView costDescText;
    private TextView costText;
    private TextView valueDescText;
    private TextView valueText;
    private TextView abilitiesDescText;
    private TextView abilitiesText;

    private String costString;
    private String valueString;

    public CardInfoFragment() {
        // Required empty public constructor
    }

    public void setCard(Card card) {
        this.card = card;

        updateView();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_card_info, container, false);
        imageView = v.findViewById(R.id.cardDescImage);

        costText = v.findViewById(R.id.costText);
        costDescText = v.findViewById(R.id.costDescText);
        valueText = v.findViewById(R.id.valueText);
        valueDescText = v.findViewById(R.id.valueDescText);
        abilitiesDescText = v.findViewById(R.id.descDescText);
        abilitiesText = v.findViewById(R.id.descText);
        return v;
    }

    public void updateView() {
        abilitiesDescText.setText(getString(R.string.abilities_text_value));
        if (card != null) {
            String suit = card.getSuit();
            String value = card.getValue();
            int intValue = 0;
            boolean red = false;
            int cost = card.getCost();
            if (suit.equals("h") || suit.equals("d")) {
                red = true;
            }

            if (value.equals("j") || value.equals("q") || value.equals("k")) { //get the attack/defend value for the card
                intValue = 10;
            } else if (value.equals("a")) {
                intValue = 1;
            } else {
                intValue = card.getCost();
            }

            if (red) { //set either damage or health indicator
                valueDescText.setText(getString(R.string.health_text)); //red cards
                switch (value) {
                    case "j":
                        abilitiesDescText.setText(getString(R.string.red_jack_abilities));
                        break;
                    case "k":
                        abilitiesDescText.setText(getString(R.string.red_king_abilities));
                        break;
                    case "q":
                        abilitiesDescText.setText(getString(R.string.red_queen_abilities));
                        break;
                    case "a":
                        abilitiesDescText.setText(getString(R.string.red_ace_abilities));
                        break;
                    case "10":
                        abilitiesDescText.setText(getString(R.string.ten_card_abilities));
                        break;
                }
            } else {
                valueDescText.setText(getString(R.string.damage_text));
                switch (value) {
                    case "j":
                        abilitiesDescText.setText(getString(R.string.black_jack_abilities));
                        break;
                    case "k":
                        abilitiesDescText.setText(getString(R.string.black_king_abilities));
                        break;
                    case "q":
                        abilitiesDescText.setText(getString(R.string.black_queen_abilities));
                        break;
                    case "a":
                        abilitiesDescText.setText(getString(R.string.black_ace_abilities));
                        break;
                    case "10":
                        abilitiesDescText.setText(getString(R.string.ten_card_abilities));
                        break;
                }
            }



            costString = String.format(getResources().getString(R.string.cost_text_value), cost);
            costText.setText(costString);
            valueText.setText(Integer.toString(intValue));
            imageView.setImageResource(getResources().getIdentifier(card.getImageSource(), "drawable", "org.pltw.examples.thecardgame"));
        }
    }

}
