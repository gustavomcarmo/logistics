/* 
 * The MIT License
 *
 * Copyright 2015 Esign Consulting Ltda.
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
package br.com.esign.logistics.web.response;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gustavomunizdocarmo
 */
public class WebServiceBadResponseTest {
    
    /**
     * Test of getCode method, of class WebServiceBadResponse.
     */
    @Test
    public void testGetCode() {
        WebServiceBadResponse response = new WebServiceBadResponse(500, "The route already exists.");
        assertEquals(500, response.getCode());
    }

    /**
     * Test of getStatus method, of class WebServiceBadResponse.
     */
    @Test
    public void testGetStatus() {
        WebServiceBadResponse response = new WebServiceBadResponse(500, "The route already exists.");
        assertEquals("fail", response.getStatus());
    }

    /**
     * Test of getData method, of class WebServiceBadResponse.
     */
    @Test
    public void testGetData() {
        WebServiceBadResponse response = new WebServiceBadResponse(500, "The route already exists.");
        assertNull(response.getData());
    }
    
    /**
     * Test of getMessage method, of class WebServiceBadResponse.
     */
    @Test
    public void testGetMessage() {
        WebServiceBadResponse response = new WebServiceBadResponse(500, "The route already exists.");
        assertEquals("The route already exists.", response.getMessage());
    }
    
}
