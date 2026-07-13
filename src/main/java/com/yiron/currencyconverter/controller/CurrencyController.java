package com.yiron.currencyconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class CurrencyController {

    // Fixed rates relative to 1 INR. Easy to extend with more currencies later.
    private static final Map<String, Double> RATES_FROM_INR = new LinkedHashMap<>();

    static {
        RATES_FROM_INR.put("USD", 0.012);
        RATES_FROM_INR.put("EUR", 0.011);
        RATES_FROM_INR.put("GBP", 0.0095);
        RATES_FROM_INR.put("JPY", 1.73);
        RATES_FROM_INR.put("PNR", 0.50);
        RATES_FROM_INR.put("Psss", 0.90);
        RATES_FROM_INR.put("pounds", 1.5);


    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("currencies", RATES_FROM_INR.keySet());
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("amount") double amount,
                           @RequestParam("targetCurrency") String targetCurrency,
                           Model model) {

        double rate = RATES_FROM_INR.getOrDefault(targetCurrency, 0.0);
        double result = amount * rate;

        model.addAttribute("currencies", RATES_FROM_INR.keySet());
        model.addAttribute("amount", amount);
        model.addAttribute("targetCurrency", targetCurrency);
        model.addAttribute("result", String.format("%.2f", result));

        return "index";
    }
}
