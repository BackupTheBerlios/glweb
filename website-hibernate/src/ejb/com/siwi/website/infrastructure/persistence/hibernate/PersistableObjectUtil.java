/*
 * $Id: PersistableObjectUtil.java,v 1.1 2003/10/29 08:27:23 paxson Exp $
 */

package com.siwi.website.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.siwi.website.infrastructure.persistence.PersistableObject;

/**
 * PersistableObjectUtil
 *
 * @author   $Author: paxson $
 * @version  $Revision: 1.1 $ $Date: 2003/10/29 08:27:23 $
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
