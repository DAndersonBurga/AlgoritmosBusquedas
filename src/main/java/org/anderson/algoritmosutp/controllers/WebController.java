package org.anderson.algoritmosutp.controllers;

import org.anderson.algoritmosutp.classes.BinarySearcher;
import org.anderson.algoritmosutp.classes.OxfordDictionary;
import org.anderson.algoritmosutp.classes.SequentialSearcher;
import org.anderson.algoritmosutp.classes.Word;
import org.anderson.algoritmosutp.utils.LectorTxt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController {

    private SequentialSearcher sequentialSearcher;
    private BinarySearcher binarySearcher;

    @Autowired
    public WebController(SequentialSearcher sequentialSearcher, BinarySearcher binarySearcher) {
        this.sequentialSearcher = sequentialSearcher;
        this.binarySearcher = binarySearcher;
    }

    @GetMapping("/")
    public String index(Model model) {
        OxfordDictionary elementos = LectorTxt.leerTxt();

        model.addAttribute("elementos", elementos);

        return "index";
    }

    @GetMapping("/buscar")
    public String buscar(Model model, @RequestParam String query,
                         @RequestParam int busqueda) {
        OxfordDictionary elementos = LectorTxt.leerTxt();
        int posicion;
        Word palabraEncontrada = null;

        if(busqueda == 1) {
            posicion = binarySearcher.search(elementos.getWords(), query);
            if(posicion != -1) {
                palabraEncontrada = elementos.getWords()[posicion];
            }
        } else if (busqueda == 2){
            posicion = sequentialSearcher.search(elementos.getWords(), query);
            if(posicion != -1) {
                palabraEncontrada = elementos.getWords()[posicion];
            }
        }

        model.addAttribute("buscar", true);
        model.addAttribute("elementos", elementos);
        model.addAttribute("palabraEncontrada", palabraEncontrada);

        return "index";
    }
}
