package net.sparkminds.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.user.entity.History;
import net.sparkminds.user.service.HistoryService;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
	
	private final HistoryService historyService;
	
	public HistoryController(HistoryService historyService) {
		this.historyService = historyService;
	}

	@GetMapping
	public ResponseEntity<List<History>> getAllHistory(){
		return ResponseEntity.ok(historyService.getAllData());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<History> getHistory(@PathVariable("id") Long id){
		return ResponseEntity.ok(historyService.getDataById(id));
	}
}
