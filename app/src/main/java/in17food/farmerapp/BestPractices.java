package in17food.farmerapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.Button;
import android.widget.TextView;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

public class BestPractices extends AppCompatActivity {

    /*
    I deeply apologize for what you are about to witness below
     */
    HtmlTextView bestPracticesSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_practices);

        bestPracticesSummary = (HtmlTextView) findViewById(R.id.best_practices_summary);

        Spanned result;
        String html = "<h1>Test</h1><center><img src='government' /></center>";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html,Html.FROM_HTML_MODE_LEGACY, new ImageGetter(), null);
        } else {
            result = Html.fromHtml(html, new ImageGetter(), null);
        }

        bestPracticesSummary.setHtml(html, new HtmlResImageGetter(bestPracticesSummary));
    }
    private class ImageGetter implements Html.ImageGetter {

        public Drawable getDrawable(String source) {
            int id;

            if (source.equals("government.png")) {
                id = R.drawable.government;
            }
            else if (source.equals("contact.png")) {
                id = R.drawable.contact;
            }
            else {
                return null;
            }

            Drawable d = getResources().getDrawable(id);
            d.setBounds(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());
            return d;
        }
    };
}
