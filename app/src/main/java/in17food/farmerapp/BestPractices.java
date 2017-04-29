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
        String html = "<h1>Best Practices</h1>\n" +
                "\n" +
                "<p>The sections below cover different ways to provide better cares for apples and apple trees to decrease damage, and increase growth and quality.</p>\n" +
                "\n" +
                "<h1>Tree Care</h1>\n" +
                "\n" +
                "<h2>Caring for Young Trees</h2>\n" +
                "\n" +
                "<p>It is important to be careful when pruning young trees, as this can slow growth. If you wish to promote growth, follow the steps below:</p>\n" +
                "\n" +
                "<ul>\n" +
                "  <li>Rub off buds that are poorly placed, or may not grow correctly, rather than cutting them</li>\n" +
                "  <li>Bend growing branches until they are almost horizontal for a few weeks to slow growth and promote fruiting. Tie them to stakes int eh ground or to lower branches (see image below)</li>\n" +
                "</ul>\n" +
                "\n" +
                "<!--<center><img src='horizontal_branches'/></center>-->\n" +
                "<center><p>(PLACEHOLDER FOR IMAGE)</p></center>\n" +
                "\n" +
                "<h2>Pruning Trees</h2>\n" +
                "\n" +
                "<p>In the process of pruning, follow the below guidelines:</p>\n" +
                "\n" +
                "<ul>\n" +
                "  <li>Get rid of diseased, broken, and dead limbs to make space for new limbs, and increase sunlight and airflow</li>\n" +
                "</ul>\n" +
                "\n" +
                "<center><p>(PLACEHOLDER FOR IMAGE)</p></center>\n" +
                "\n" +
                "<ul>\n" +
                "  <li>Remove any stems that are overly upright, or vertical (commonly found higher up in trees)</li>\n" +
                "  <li>Shortern stems that point toward the ground or droop, especially those that are lower down in the tree</li>\n" +
                "  <li>After 10 years, fruiting spurs on branches may begin to crowd each other. Cut away some, and shorten others</li>\n" +
                "  <li>If a whole limb of fruiting spurts is declining with age, cut back the limb to make room for new growth</li>\n" +
                "</ul>\n" +
                "\n" +
                "\n" +
                "\n";

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
