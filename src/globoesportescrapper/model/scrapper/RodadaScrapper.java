/*
 * The MIT License
 *
 * Copyright 2017 Victor Santiago.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package globoesportescrapper.model.scrapper;

import globoesportescrapper.model.objects.Rodada;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;

/**
 *
 * @author Victor Santiago
 */
public class RodadaScrapper {
    
    private String url;

    public RodadaScrapper(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Rodada scrap() throws IOException {
        Rodada r = new Rodada();
        
        Pattern p = Pattern.compile("rodada\\/\\s*(\\d+)\\s*\\/");
        Matcher m = p.matcher(url);
        
        if(m.find())
            r.setNumber(Integer.parseInt(m.group(1)));
        
        String html = Jsoup.connect(url).get().html();
        r.setPartidas(PartidaScrapper.scrapIt(html));
        
        return r;
    }
    
    public static Rodada scrapIt(String url) throws IOException {
        return new RodadaScrapper(url).scrap();
    }
    
}