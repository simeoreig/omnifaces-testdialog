// <editor-fold defaultstate="collapsed" desc="Imports">    
package beans;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;
// </editor-fold>

@ViewScoped
@Named
public class BeanFormesPagament implements Serializable {

    private String formaPagament;


    public boolean insereixTipus(ActionEvent actionEvent) {

        FacesMessage message;

        try {

            String MissatgeRetorn =  this.formaPagament;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipus forma de pagament afegida correctament", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().closeDialog(MissatgeRetorn);

        } catch (Exception ex) {
            
            System.out.println("Error " + ex.getMessage());            
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, " + ex.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return false;
        }

        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="Geters & Setters">    
    public String getFormaPagament() {
        return formaPagament;
    }

    public void setFormaPagament(String formaPagament) {
        this.formaPagament = formaPagament;
    }
    // </editor-fold>

}
