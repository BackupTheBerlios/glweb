<%--
 $Id: scriptcss.jsp,v 1.2 2003/06/12 05:53:11 paxson Exp $
 $Revision: 1.2 $
 $Date: 2003/06/12 05:53:11 $
 $Author: paxson $
--%>

<script language="javascript">


    with (document) {
        write("<STYLE TYPE='text/css'>");
        if (document.layers) {
            write(".buddy { position:relative; visibility:hidden;}");
//            write(".parent {position:absolute; visibility:visible}");

        }
        else {
            write(".buddy { position:relative; padding:0px;display:none;}");
            write(".parent { position:relative; }");

        }
        write("</STYLE>");
    }

</script>
