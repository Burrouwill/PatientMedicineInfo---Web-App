package com.example.demo.Data;

import com.example.demo.Adr.Adr;
import com.example.demo.Drug.Drug;
import org.springframework.core.io.Resource;

import java.util.List;

public class DrugParser {
    public List<Drug> parseDrugsFromText(Resource data) {
            Drug d = new Drug();
            return List.of(d);
    }
}
