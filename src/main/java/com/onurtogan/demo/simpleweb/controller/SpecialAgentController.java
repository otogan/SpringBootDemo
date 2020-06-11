package com.onurtogan.demo.simpleweb.controller;

import com.onurtogan.demo.simpleweb.model.SpecialAgent;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class SpecialAgentController {

    @PostMapping(value = "/validate/agent", consumes = "application/json")
    public ResponseEntity<String> validateAgent(@Valid @RequestBody SpecialAgent agent) {
        return ResponseEntity.ok("Agent info is valid.");
    }

    @GetMapping(value = "/validate/agent/{id}")
    ResponseEntity<String> validateAgentPathVariable(@PathVariable("id") @Min(1) int id) {
        return ResponseEntity.ok("Agent id is valid.");
    }

    @GetMapping("/validate/agent")
    ResponseEntity<String> validateAgentRequestParam(@RequestParam("code") @Pattern(regexp = "[0-9]{1,3}") String code) {
        return ResponseEntity.ok("Agent code is valid.");
    }
}
