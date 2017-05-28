// <editor-fold defaultstate="collapsed" desc="Imports">
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

// </editor-fold>


@ViewScoped
@Named
public class ControlFacturacio implements Serializable {

    
    public void onDialogReturn(SelectEvent event) {
          
        String textPassat = (String) event.getObject();
        
        FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_INFO,textPassat,null);

        FacesContext.getCurrentInstance().addMessage(
                null, message);
        
        System.out.println("form Return " + textPassat);
        
    }   
        
     public void showDialogForm(String nomDialeg, String parametrePassat) {
        
        String rutaDialeg =  "/dialogs/" + nomDialeg;
         
        Map<String, Object> options =  new HashMap<>();
        
        options.put("modal", true);
        options.put("draggable", true);
        options.put("resizable", false);
        options.put("contentWidth", 700);
        //options.put("contentHeight", 400);
        options.put("includeViewParams", true);

        Map<String, List<String>> params = new HashMap<>();
        List<String> values = new ArrayList<>();
        
        values.add(parametrePassat);
        
        params.put("bookName", values);

        RequestContext.getCurrentInstance().openDialog(rutaDialeg, options, params);
    }   
    
    



}
