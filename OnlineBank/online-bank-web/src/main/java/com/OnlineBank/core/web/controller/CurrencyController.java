package com.OnlineBank.core.web.controller;

import com.onlinebank.core.data.model.Currency;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
 import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.onlinebank.core.data.model.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/currencies")
public class CurrencyController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public Response<Map<String, List<JSONObject>>> getCurrencies() {
        List<JSONObject> currencies = new ArrayList<>();

        for(Currency currency : Currency.values()) {
            currencies.add(currency.toJSON());
        }

        return new Response<>(new HashMap<String, List<JSONObject>>() {{
            put("currencies", currencies);
        }});
    }
}
