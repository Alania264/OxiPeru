package com.oxiperu.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import com.oxiperu.appweb.model.Producto;
import com.oxiperu.appweb.model.Proforma;
import com.oxiperu.appweb.model.Usuario;
import com.oxiperu.appweb.repository.ProformaRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

@Controller
public class ProformaController {
    private static final String VIEW_INDEX ="proforma/index";
    private static String MODEL_PRODUCTO="proforma";
    private final ProformaRepository proformaData;
    
    public ProformaController(ProformaRepository proformaData
        ){
        this.proformaData = proformaData;
    }      

    public static String getMODEL_PRODUCTO() {
        return MODEL_PRODUCTO;
    }
    public static void setMODEL_PRODUCTO(String mODEL_PRODUCTO) {
        MODEL_PRODUCTO = mODEL_PRODUCTO;
    }

    @GetMapping("/proforma/index")
    public String index(Model model, HttpSession session){
        Usuario user = (Usuario)session.getAttribute("user"); 
        List<Proforma> listItems = this.proformaData.findItemsByUsuario(user);
        model.addAttribute("proformas",listItems);
        return VIEW_INDEX;
    }    

    @PostMapping("/proforma/update")
    public String createSubmitForm(Model model, 
    @Valid Proforma objProforma, BindingResult result ){
        Proforma prof = proformaData.getOne(objProforma.getId());
        prof.setCantidad(objProforma.getCantidad());
        proformaData.save(prof);
        return "redirect:/proforma/index";
    }

}
