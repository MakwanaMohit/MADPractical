package com.mk.madpractical;


import android.content.Context;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.StringReader;

public class XMLParser {

    private Context context;
    public DatabaseHelper dpHelper;

    public XMLParser(Context context,DatabaseHelper dbHelper) {
        this.context = context;
        this.dpHelper = dbHelper;
    }

    public void parseAndInsertData(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xmlData));

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG && "PrintLetterBarcodeData".equals(parser.getName())) {
                    String uid = parser.getAttributeValue(null, "uid");
                    String name = parser.getAttributeValue(null, "name");
                    String gender = parser.getAttributeValue(null, "gender");
                    String yob = parser.getAttributeValue(null, "yob");
                    String gname = parser.getAttributeValue(null, "gname");
                    String street = parser.getAttributeValue(null, "street");
                    String loc = parser.getAttributeValue(null, "loc");
                    String vtc = parser.getAttributeValue(null, "vtc");
                    String po = parser.getAttributeValue(null, "po");
                    String dist = parser.getAttributeValue(null, "dist");
                    String subdist = parser.getAttributeValue(null, "subdist");
                    String state = parser.getAttributeValue(null, "state");
                    String pc = parser.getAttributeValue(null, "pc");
                    String dob = parser.getAttributeValue(null, "dob");


                    dpHelper.insertData(uid, name, gender, yob, gname, street, loc, vtc, po, dist, subdist, state, pc, dob);
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

