/*
 *
 * $Id: PersistableObjectUtil.java,v 1.1 2003/05/10 11:41:13 paxson Exp $
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

package com.glweb.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.glweb.infrastructure.persistence.PersistableObject;

/**
 * PersistableObjectUtil
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/05/10 11:41:13 $
 */
public class PersistableObjectUtil {

    public static ArrayList findDeletedItemsFromCollection(
            Collection originalCollection, Collection updatedCollection) {
        ArrayList _originalIds = getPersistableObjectIds(originalCollection);
        ArrayList _updatedIds = getPersistableObjectIds(updatedCollection);
        ArrayList _deletedIds = new ArrayList();

        for (Iterator _iterator = _originalIds.iterator(); _iterator.hasNext();) {
            Long id = (Long) _iterator.next();
            
            if (!_updatedIds.contains(id)) {
                _deletedIds.add(id);
            }
        }

        return _deletedIds;
    }

    public static ArrayList getPersistableObjectIds(Collection collection) {
        ArrayList _ids = new ArrayList(collection.size());

        for (Iterator _iterator = collection.iterator(); _iterator.hasNext();) {
            PersistableObject _persistableObject = (PersistableObject) _iterator.next();
            _ids.add(new Long(_persistableObject.getId()));
        }

        return _ids;
    }

    public static HashMap buildPeristableObjectHashMap(Collection collection) {
        HashMap _objectMap = new HashMap(collection.size());

        for (Iterator _iterator = collection.iterator(); _iterator.hasNext();) {
            PersistableObject _persistableObject = (PersistableObject) _iterator.next();
            _objectMap.put(new Long(_persistableObject.getId()), _persistableObject);
        }

        return _objectMap;
    }

}
