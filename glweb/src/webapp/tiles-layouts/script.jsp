<%--
 $Id: script.jsp,v 1.2 2003/06/12 05:53:11 paxson Exp $
 $Revision: 1.2 $
 $Date: 2003/06/12 05:53:11 $
 $Author: paxson $
--%>

<script language="javascript" >

    NS4 = (document.layers) ? 1 : 0;
    IE4 = (document.all) ? 1 : 0;
    ver4 =  (NS4 || IE4) ? 1 : 0;
    GK =  (document.getElementById) ? 1 : 0;

    var elm = null;
    var whichIm = null;
 
    VISIBLE = (NS4) ? 'show' : 'visible';
    HIDDEN = (NS4) ? 'hide' : 'hidden';
    
   function buddy(id) {
   

      if(GK) {elm = document.getElementById(id); }
      else if(IE4)  {elm = document.all[id]; }
      else if (NS4) { elm = document.layers[id]; }

        if(id.indexOf("On") > -1) {
            whichIm = document.images["imExOn"];
        }
        else 
        {  whichIm = document.images["imExOff"]; }


        if (elm.style)
        {
            // browser implements part of W3C DOM Style
            // Gecko, Internet Explorer 4+, Opera 5+
            //alert(elm.style.display);

            var l = elm.innerHTML.length;
            //alert(leng);
            
    
            if(elm.style.display  == 'none') { 
                elm.style.display  = 'block'; 
                if(l > 75)
                    whichIm.src = "images/1515down.gif";        
    
                
            }
            else { 
                elm.style.display  = 'none'; 
                if(l > 75)
                    whichIm.src = "images/1515right.gif";        
               
            }
     
        }
        else {
            
           var h = elm.document.height;
            
            // Navigator 4
            if(elm.visibility  == VISIBLE) { 
                elm.visibility  = HIDDEN;
                if(h > 15)
                whichIm.src = "images/1515right.gif";        
                 
             }
            else { 
                elm.visibility  = VISIBLE; 
                 if(h > 15) whichIm.src = "images/1515down.gif";        

            
             }
            
        }

   
   }
   
   if(document.images["imExOn"]) {
        
        buddy('buddiesOnline');
        buddy('buddiesOffline');
        if(!NS4) { buddy('buddiesOnline'); }
    }
    

</script>
