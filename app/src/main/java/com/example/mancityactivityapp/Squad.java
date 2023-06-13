package com.example.mancityactivityapp;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Squad {
    public Player getPlayerAt(int position) {
        return players.get(position);
    }

    public int getSquadSize() {
        return players.size();
    }

    private List<Player> players ;

    private Context mContext;
    public Squad(Context context) {
        this.players = new ArrayList<Player>();
        mContext=context;
    }
    public void PopulateSquad() {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();

            InputStream is = mContext.getResources().openRawResource(R.raw.players);
            parser.setInput(is, null);

            int eventType = parser.getEventType();
            Player currentPlayer = null;
            String currentTagName = null;

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        currentTagName = parser.getName();
                        if (currentTagName.equals("player")) {
                            currentPlayer = new Player();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        String text = parser.getText().trim();
                        if (currentPlayer != null && !text.isEmpty()) {
                            switch (currentTagName) {
                                case "name":
                                    currentPlayer.setName(text);
                                    break;
                                case "dob":
                                    currentPlayer.setDob(text);
                                    break;
                                case "position":
                                    currentPlayer.setPosition(text);
                                    break;
                                case "joined":
                                    currentPlayer.setJoined(text);
                                    break;
                                case "shirt_number":
                                    int shirtNumber = Integer.parseInt(text);
                                    currentPlayer.setShirtNumber(shirtNumber);
                                    break;
                                case "birth_place":
                                    currentPlayer.setBirthPlace(text);
                                    break;
                                case "nationality":
                                    currentPlayer.setNationality(text);
                                    break;
                                case "summary":
                                    currentPlayer.setSummary(text);
                                    break;
                                case "url":
                                    currentPlayer.setUrl(text);
                                    break;
                                case "image":
                                    currentPlayer.setImage(text);
                                    break;
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("player")) {
                            players.add(currentPlayer);
                            currentPlayer = null;
                        }
                        break;
                }

                eventType = parser.next();
            }

        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
    }

}
