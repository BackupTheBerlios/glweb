/*
 *
 * $Id: SetCharacterEncodingFilter.java,v 1.1 2003/09/24 06:54:33 paxson Exp $
 *
 * Copyright (c) 2003 SIWI.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the 
 * "Software"), to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, merge, publish, 
 * distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject to 
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY 
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.glweb.system.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/09/24 06:54:33 $
 * 
 * @web.filter name="Set Character Encoding"
 * 
 * @web.filter-init-param name="encoding" 
 *                        value="Big5"
 * 
 * @web.filter-mapping servlet-name="action"
 */
public final class SetCharacterEncodingFilter implements Filter {

    private String _encoding;
    
    private FilterConfig _filterConfig = null;    

    protected String getEncoding(ServletRequest request) {
        return _encoding;
    }

    public void destroy() {
        _encoding = null;
        _filterConfig = null;
    }
    
    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
        _encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain)
            throws IOException, ServletException {
        String _encoding = getEncoding(request);
        
        if (null != _encoding) {
            request.setCharacterEncoding(_encoding);
        }

        chain.doFilter(request, response);
    }
}