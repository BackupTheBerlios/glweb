/*
 * $ Id: $
 * 
 */

package com.siwi.website.ejb.entity;

/**
 *  LanguageCodeEJBBean
 *
 * @author  Paxson Yang
 * @created  2002/8/7
 * @version  $Revision: 1.1 $ $Date: 2003/10/28 02:56:05 $
 * 
 * @ejb:bean  type="CMP" cmp-version="2.x" name="LanguageCode"
 *            jndi-name="ejb/entity/LanguageCode"
 *            local-jndi-name="ejb/entity/LanguageCodeLocal" 
 *            view-type="both"
 * 
 * @ejb:transaction  type="Required"
 * 
 * @jboss:table-name  "language_code"
 * @jboss:create-table  "true"
 * @jboss:remove-table  "false"
 * @jboss:read-only  "false"
 * 
 * @struts:form  include-all="true"
 */
public abstract class LanguageCodeEJBBean implements javax.ejb.EntityBean {

    private javax.ejb.EntityContext _entityContext;

    /**
     *  Sets the entityContext attribute of the LanguageCodeEJBBean object
     *
     * @param  entityContext  The new entityContext value
     */
    public void setEntityContext(javax.ejb.EntityContext entityContext) {
        _entityContext = entityContext;
    }

    /**
     * @param  id  id of this language code
     */
    public abstract void setId(java.lang.String id);

    /**
     * @param  language  language of this language code
     * 
     * @ejb:interface-method  view-type="local"
     */
    public abstract void setLanguage(LanguageLocal language);

    /**
     * @param  name  name of this language code
     * 
     * @ejb:interface-method  view-type="local"
     * 
     * @ejb:interface-method  view-type="remote"
     */
    public abstract void setName(java.lang.String name);

    /**
     * @return  id of this language code
     * 
     * @ejb:persistent-field
     * 
     * @ejb:pk-field
     */
    public abstract java.lang.String getId();

    /**
     * @return  language of this language code
     * 
     * @ejb:interface-method  view-type="local"
     * 
     * @ejb:relation  name="language-languagecode"
     *                role-name="one-languagecode-has-one-language"
     * 
     * @jboss:relation  related-pk-field="id"
     *                  fk-column="language_code_id"
     */
    public abstract LanguageLocal getLanguage();

    /**
     * @return  name of this language code
     * 
     * @ejb:interface-method  view-type="local"
     * 
     * @ejb:interface-method  view-type="remote"
     * 
     * @ejb:persistent-field
     */
    public abstract java.lang.String getName();

    /**
     *  Description of the Method
     */
    public void ejbActivate() { }

    /**
     *  Description of the Method
     */
    public void ejbLoad() { }

    /**
     *  Description of the Method
     */
    public void ejbPassivate() { }

    /**
     *  Description of the Method
     *
     * @exception  javax.ejb.RemoveException  Description of the Exception
     */
    public void ejbRemove() throws javax.ejb.RemoveException { }

    /**
     *  Description of the Method
     */
    public void ejbStore() { }

    /**
     *  Description of the Method
     */
    public void unsetEntityContext() {
        setEntityContext(null);
    }

}