/**
 * Copyright (C) 2012 Xeiam LLC http://xeiam.com
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xeiam.xchange.bitstamp.service.marketdata;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.xeiam.xchange.bitstamp.dto.marketdata.BitstampTicker;

/**
 * Test BitstampTicker JSON parsing
 */
public class TickerJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is = TickerJSONTest.class.getResourceAsStream("/marketdata/example-ticker-data.json");

    ObjectMapper mapper = new ObjectMapper();
    BitstampTicker bitstampTicker = mapper.readValue(is, BitstampTicker.class);

    // Verify that the example data was unmarshalled correctly
    assertThat("Unexpected Return Last value", bitstampTicker.getLast(), is(equalTo(new BigDecimal("13.06"))));
    assertThat("Unexpected Return High value", bitstampTicker.getHigh(), is(equalTo(new BigDecimal("13.15"))));
    assertThat("Unexpected Return Low value", bitstampTicker.getLow(), is(equalTo(new BigDecimal("13.03"))));
    assertThat("Unexpected Return Volume value", bitstampTicker.getVolume(), is(equalTo(new BigDecimal("1127.55649327"))));
    assertThat("Unexpected Return Bid value", bitstampTicker.getBid(), is(equalTo(new BigDecimal("13.06"))));
    assertThat("Unexpected Return Ask value", bitstampTicker.getAsk(), is(equalTo(new BigDecimal("13.14"))));
  }

}